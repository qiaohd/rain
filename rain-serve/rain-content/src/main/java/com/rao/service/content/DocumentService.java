package com.rao.service.content;

import com.rao.pojo.vo.content.DocumentDetailVO;
import com.rao.pojo.vo.content.ListDocumentVO;

import java.util.List;

/**
 * 文章-service
 *
 * @author raojing
 * @date 2020/4/11 11:11
 */
public interface DocumentService {

    /**
     * 根据ID获取文章详情
     *
     * @param id
     * @return
     */
    DocumentDetailVO detail(Long id);

    /**
     * 根据文章类型获取列表
     *
     * @param type
     * @return
     */
    List<ListDocumentVO> listByType(Integer type);
}
