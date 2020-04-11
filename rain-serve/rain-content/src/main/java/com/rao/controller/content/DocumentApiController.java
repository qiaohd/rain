package com.rao.controller.content;

import com.rao.annotation.IgnoreTokenAuth;
import com.rao.annotation.SimpleParam;
import com.rao.annotation.SimpleValid;
import com.rao.pojo.vo.content.DocumentDetailVO;
import com.rao.pojo.vo.content.ListDocumentVO;
import com.rao.service.content.DocumentService;
import com.rao.util.result.ResultMessage;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 文章-controller
 *
 * @author raojing
 * @date 2020/4/11 11:09
 */
@RestController
@RequestMapping("/api/document")
public class DocumentApiController {

    @Resource
    private DocumentService documentService;

    /**
     * 文章列表-C端
     *
     * @param type
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping("/list")
    public ResultMessage<List<ListDocumentVO>> list(@SimpleParam @SimpleValid @NotNull(message = "广告类型不能为空") @Range(min = 1, max = 3, message = "广告类型不合法") Integer type) {
        List<ListDocumentVO> listDocument = documentService.listByType(type);
        return ResultMessage.success(listDocument).message("获取文章列表成功");
    }

    /**
     * 获取文章详情
     *
     * @param id
     * @return
     */
    @IgnoreTokenAuth
    @GetMapping("/{id}")
    public ResultMessage<DocumentDetailVO> detail(@PathVariable("id") Long id) {
        DocumentDetailVO documentDetail = documentService.detail(id);
        return ResultMessage.success(documentDetail).message("获取文章详情成功");
    }

}
