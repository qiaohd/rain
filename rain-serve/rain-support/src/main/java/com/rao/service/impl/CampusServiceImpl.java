package com.rao.service.impl;

import com.rao.constant.common.StateConstants;
import com.rao.dao.campus.RainCampusDao;
import com.rao.dao.campus.RainCampusFacultyDao;
import com.rao.dao.campus.RainFacultyDao;
import com.rao.pojo.dto.SaveCampusDTO;
import com.rao.pojo.entity.campus.RainCampus;
import com.rao.pojo.entity.campus.RainCampusFaculty;
import com.rao.pojo.entity.campus.RainFaculty;
import com.rao.pojo.vo.ListCampusVO;
import com.rao.pojo.vo.ListFacultyVO;
import com.rao.pojo.vo.PageCampusVO;
import com.rao.service.CampusService;
import com.rao.util.common.CopyUtil;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
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

    @Override
    public PageResult<PageCampusVO> pageCampus(PageParam pageParam) {
        return null;
    }

    @Override
    public String addCampus(SaveCampusDTO saveCampusDTO) {
        return null;
    }

    @Override
    public String updateCampus(Long id, SaveCampusDTO saveCampusDTO) {
        return null;
    }

    @Override
    public void deleteCampus(Long id) {

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

        Example example = new Example(RainFaculty.class);
        example.createCriteria().andIn("id", facultyIdList);
        example.orderBy("weight").desc();
        List<RainFaculty> faculties = rainFacultyDao.selectByExample(example);
        return CopyUtil.transToObjList(faculties, ListFacultyVO.class);
    }
}
