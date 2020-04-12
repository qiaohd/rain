package com.rao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rao.constant.common.StateConstants;
import com.rao.dao.RainBroadbandPackageDao;
import com.rao.dao.RainProductBroadbandDao;
import com.rao.exception.BusinessException;
import com.rao.pojo.entity.RainBroadbandPackage;
import com.rao.pojo.entity.RainProductBroadband;
import com.rao.pojo.vo.BroadbandPackageVO;
import com.rao.pojo.vo.BroadbandProductDetailVO;
import com.rao.pojo.vo.BroadbandProductVO;
import com.rao.service.ProductBroadbandService;
import com.rao.util.common.CopyUtil;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 宽带产品-service impl
 *
 * @author raojing
 * @date 2020/4/11 21:01
 */
@Service
public class ProductBroadbandServiceImpl implements ProductBroadbandService {

    @Resource
    private RainProductBroadbandDao rainProductBroadbandDao;
    @Resource
    private RainBroadbandPackageDao rainBroadbandPackageDao;

    @Override
    public PageResult<BroadbandProductVO> broadbandPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNumber(), pageParam.getPageSize());
        Example example = new Example(RainProductBroadband.class);
        example.createCriteria()
                .andEqualTo("status", StateConstants.STATE_ENABLE);
        example.orderBy("weight").desc();
        List<RainProductBroadband> broadbandList = rainProductBroadbandDao.selectByExample(example);
        PageInfo<RainProductBroadband> pageInfo = PageInfo.of(broadbandList);
        List<BroadbandProductVO> broadbandVOList = CopyUtil.transToObjList(broadbandList, BroadbandProductVO.class);
        return PageResult.build(pageInfo.getTotal(), broadbandVOList);
    }

    @Override
    public BroadbandProductDetailVO broadbandDetail(Long id) {
        RainProductBroadband broadband = new RainProductBroadband();
        broadband.setId(id);
        broadband.setStatus(StateConstants.STATE_ENABLE);
        broadband = rainProductBroadbandDao.selectOne(broadband);

        if(broadband == null){
            throw BusinessException.operate("产品已下架");
        }

        Example example = new Example(RainBroadbandPackage.class);
        example.createCriteria()
                .andEqualTo("productId", id)
                .andEqualTo("status", StateConstants.STATE_ENABLE);
        example.orderBy("weight").desc();
        List<RainBroadbandPackage> packageList = rainBroadbandPackageDao.selectByExample(example);

        BroadbandProductDetailVO broadbandDetailVO = CopyUtil.transToObj(broadband, BroadbandProductDetailVO.class);
        broadbandDetailVO.setProductImages(Arrays.asList(broadband.getProductImages().split(",")));
        broadbandDetailVO.setPackages(CopyUtil.transToObjList(packageList, BroadbandPackageVO.class));
        return broadbandDetailVO;
    }
}
