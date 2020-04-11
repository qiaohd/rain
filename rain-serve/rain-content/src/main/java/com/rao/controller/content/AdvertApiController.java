package com.rao.controller.content;

import com.rao.pojo.vo.content.ListAdvertVO;
import com.rao.service.content.AdvertService;
import com.rao.util.result.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 广告-controller
 *
 * @author raojing
 * @date 2020/4/11 11:08
 */
@RestController
@RequestMapping("/api/advert")
public class AdvertApiController {

    @Resource
    private AdvertService advertService;

    /**
     * 广告列表-C端
     * @return
     */
    @GetMapping()
    public ResultMessage<ListAdvertVO> list(){

        return ResultMessage.success();
    }

}
