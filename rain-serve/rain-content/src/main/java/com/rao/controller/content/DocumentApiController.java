package com.rao.controller.content;

import com.rao.util.result.ResultMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章-controller
 *
 * @author raojing
 * @date 2020/4/11 11:09
 */
@RestController
@RequestMapping("/document")
public class DocumentApiController {


    public ResultMessage dd(){

        return ResultMessage.success();
    }

}
