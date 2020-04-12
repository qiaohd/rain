package com.rao.service;

import java.util.Map;

/**
 * 省市区-service
 *
 * @author raojing
 * @date 2020/4/12 16:39
 */
public interface RegionService {

    /**
     * 获取省市区列表
     *
     * @return
     */
    Map<Integer, String> getRegion();

}
