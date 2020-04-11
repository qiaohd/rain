package com.rao.controller.content;

import com.rao.annotation.IgnoreTokenAuth;
import com.rao.annotation.SimpleParam;
import com.rao.annotation.SimpleValid;
import com.rao.pojo.vo.content.ListAdvertVO;
import com.rao.service.content.AdvertService;
import com.rao.util.result.ResultMessage;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    @IgnoreTokenAuth
    @PostMapping("/list")
    public ResultMessage<List<ListAdvertVO>> list(@SimpleParam @SimpleValid @NotNull(message = "广告类型不能为空") @Range(min = 1, max = 3, message = "广告类型不合法") Integer type){
        List<ListAdvertVO> listAdvert =  advertService.listByType(type);
        return ResultMessage.success(listAdvert).message("获取广告列表成功");
    }

}
