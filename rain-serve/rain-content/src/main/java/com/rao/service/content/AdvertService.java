package com.rao.service.content;

import com.rao.pojo.vo.content.ListAdvertVO;

import java.util.List;

/**
 * 广告-service
 *
 * @author raojing
 * @date 2020/4/11 11:10
 */
public interface AdvertService {

    /**
     * 根据广告类型查询列表
     * @param type
     * @return
     */
    List<ListAdvertVO> listByType(Integer type);
}
