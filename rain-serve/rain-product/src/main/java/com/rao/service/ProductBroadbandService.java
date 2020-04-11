package com.rao.service;

import com.rao.pojo.vo.BroadbandProductDetailVO;
import com.rao.pojo.vo.BroadbandProductVO;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;

/**
 * 宽带-service
 *
 * @author raojing
 * @date 2020/4/11 21:00
 */
public interface ProductBroadbandService {

    /**
     * 宽带列表-分页
     *
     * @param pageParam
     * @return
     */
    PageResult<BroadbandProductVO> broadbandPage(PageParam pageParam);

    /**
     * 宽带详情
     *
     * @param id
     * @return
     */
    BroadbandProductDetailVO broadbandDetail(Long id);
}
