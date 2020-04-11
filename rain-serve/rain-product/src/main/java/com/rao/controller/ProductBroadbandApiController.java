package com.rao.controller;

import com.rao.annotation.IgnoreTokenAuth;
import com.rao.annotation.SimpleParam;
import com.rao.pojo.vo.BroadbandProductDetailVO;
import com.rao.pojo.vo.BroadbandProductVO;
import com.rao.service.ProductBroadbandService;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import com.rao.util.result.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 宽带产品-controller
 *
 * @author raojing
 * @date 2020/4/11 18:40
 */
@RestController
@RequestMapping("/product/broadband")
public class ProductBroadbandApiController {

    @Resource
    private ProductBroadbandService productBroadbandService;

    /**
     * 首页宽带列表
     *
     * @return
     */
    @IgnoreTokenAuth
    @RequestMapping("/list")
    public ResultMessage<PageResult<BroadbandProductVO>> broadbandList(@RequestBody PageParam pageParam) {
        PageResult<BroadbandProductVO> broadbandPage = productBroadbandService.broadbandPage(pageParam);
        return ResultMessage.success(broadbandPage).message("获取宽带列表成功");
    }

    /**
     * 宽带详情
     *
     * @param id
     * @return
     */
    @IgnoreTokenAuth
    @GetMapping("/{id}")
    public ResultMessage<BroadbandProductDetailVO> broadbandDetail(@SimpleParam Long id) {
        BroadbandProductDetailVO broadbandDetail = productBroadbandService.broadbandDetail(id);
        return ResultMessage.success(broadbandDetail).message("获取宽带详情成功");
    }

}
