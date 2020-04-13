package com.rao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.rao.constant.common.StateConstants;
import com.rao.dao.campus.RainCampusDao;
import com.rao.dao.campus.RainCampusFacultyDao;
import com.rao.dao.campus.RainFacultyDao;
import com.rao.exception.BusinessException;
import com.rao.pojo.dto.SaveCampusDTO;
import com.rao.pojo.entity.campus.RainCampus;
import com.rao.pojo.entity.campus.RainCampusFaculty;
import com.rao.pojo.entity.campus.RainFaculty;
import com.rao.pojo.vo.ListCampusVO;
import com.rao.pojo.vo.ListFacultyVO;
import com.rao.pojo.vo.PageCampusVO;
import com.rao.service.CampusService;
import com.rao.service.RegionService;
import com.rao.util.common.CopyUtil;
import com.rao.util.common.TwiterIdUtil;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 学校管理 service 实现
 *
 * @author raojing
 * @date 2020/1/26 13:31
 */
@Service
public class CampusServiceImpl implements CampusService {

    @Resource
    private RainCampusDao rainCampusDao;
    @Resource
    private RainFacultyDao rainFacultyDao;
    @Resource
    private RainCampusFacultyDao rainCampusFacultyDao;
    @Resource
    private RegionService regionService;

    @Override
    public PageResult<PageCampusVO> pageCampus(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNumber(), pageParam.getPageSize());
        Example example = new Example(RainCampus.class);
        example.orderBy("weight").desc();
        List<RainCampus> rainCampuses = rainCampusDao.selectByExample(example);
        PageInfo<RainCampus> pageInfo = PageInfo.of(rainCampuses);
        List<PageCampusVO> pageCampusVOS = CopyUtil.transToObjList(rainCampuses, PageCampusVO.class);
        return PageResult.build(pageInfo.getTotal(), pageCampusVOS);
    }

    @Override
    public String addCampus(SaveCampusDTO saveCampusDTO) {
        RainCampus rainCampus = CopyUtil.transToObj(saveCampusDTO, RainCampus.class);
        String provinceCode = rainCampus.getProvinceCode();
        String cityCode = rainCampus.getCityCode();
        // 获取全部的省市区键值对
        Map<Integer, String> region = regionService.getRegion();

        Date now = new Date();
        rainCampus.setId(TwiterIdUtil.getTwiterId());
        rainCampus.setProvinceName(region.getOrDefault(Integer.valueOf(provinceCode), "未知"));
        rainCampus.setCityName(region.getOrDefault(Integer.valueOf(cityCode), "未知"));
        rainCampus.setCreateTime(now);
        rainCampus.setUpdateTime(now);
        rainCampusDao.insertSelective(rainCampus);
        return String.valueOf(rainCampus.getId());
    }

    @Override
    public String updateCampus(Long id, SaveCampusDTO saveCampusDTO) {
        RainCampus rainCampus = rainCampusDao.selectByPrimaryKey(id);
        BeanUtils.copyProperties(saveCampusDTO, rainCampus);
        String provinceCode = rainCampus.getProvinceCode();
        String cityCode = rainCampus.getCityCode();
        // 获取全部的省市区键值对
        Map<Integer, String> region = regionService.getRegion();
        rainCampus.setProvinceName(region.getOrDefault(Integer.valueOf(provinceCode), "未知"));
        rainCampus.setCityName(region.getOrDefault(Integer.valueOf(cityCode), "未知"));
        rainCampus.setUpdateTime(new Date());
        rainCampusDao.updateByPrimaryKeySelective(rainCampus);
        return String.valueOf(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteCampus(Long id) {
        RainCampus rainCampus = rainCampusDao.selectByPrimaryKey(id);
        if (rainCampus == null) {
            throw BusinessException.operate("学校不存在");
        }
        // 删除学校信息
        rainCampusDao.deleteByPrimaryKey(id);

        // 删除学校和院系的关联信息
        RainCampusFaculty campusFaculty = new RainCampusFaculty();
        campusFaculty.setCampusId(id);
        rainCampusFacultyDao.delete(campusFaculty);
    }

    @Override
    public List<ListCampusVO> allCampus() {
        Example example = new Example(RainCampus.class);
        example.createCriteria()
                .andEqualTo("status", StateConstants.STATE_ENABLE);
        example.orderBy("weight").desc();
        List<RainCampus> rainCampuses = rainCampusDao.selectByExample(example);
        return CopyUtil.transToObjList(rainCampuses, ListCampusVO.class);
    }

    @Override
    public List<ListFacultyVO> listFacultyByCampusId(Long campusId) {
        RainCampusFaculty campusFaculty = new RainCampusFaculty();
        campusFaculty.setCampusId(campusId);
        List<Long> facultyIdList = rainCampusFacultyDao.select(campusFaculty).stream().map(item -> item.getFacultyId()).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(facultyIdList)){
            return Lists.newArrayList();
        }
        Example example = new Example(RainFaculty.class);
        example.createCriteria().andIn("id", facultyIdList);
        example.orderBy("weight").desc();
        List<RainFaculty> faculties = rainFacultyDao.selectByExample(example);
        return CopyUtil.transToObjList(faculties, ListFacultyVO.class);
    }
}
