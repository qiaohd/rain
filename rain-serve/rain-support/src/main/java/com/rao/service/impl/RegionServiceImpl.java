package com.rao.service.impl;

import com.rao.dao.common.RainRegionDao;
import com.rao.pojo.entity.common.RainRegion;
import com.rao.service.RegionService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 省市区-service impl
 *
 * @author raojing
 * @date 2020/4/12 16:40
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RainRegionDao rainRegionDao;

    @Override
    @Cacheable(value = "region", unless = "#result==null")
    public Map<Integer, String> getRegion() {
        List<RainRegion> rainRegions = rainRegionDao.selectAll();
        return rainRegions.stream().collect(Collectors.toMap(item -> item.getId(), RainRegion::getAreaName));
    }
}
