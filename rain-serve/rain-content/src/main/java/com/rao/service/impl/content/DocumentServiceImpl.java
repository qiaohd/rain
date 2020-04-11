package com.rao.service.impl.content;

import com.rao.constant.common.StateConstants;
import com.rao.dao.content.RainDocumentDao;
import com.rao.pojo.entity.content.RainDocument;
import com.rao.pojo.vo.content.DocumentDetailVO;
import com.rao.pojo.vo.content.ListDocumentVO;
import com.rao.service.content.DocumentService;
import com.rao.util.common.CopyUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章-service impl
 *
 * @author raojing
 * @date 2020/4/11 11:12
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Resource
    private RainDocumentDao rainDocumentDao;

    @Override
    public DocumentDetailVO detail(Long id) {
        RainDocument document = new RainDocument();
        document.setId(id);
        document.setStatus(StateConstants.STATE_ENABLE);
        document = rainDocumentDao.selectOne(document);
        return CopyUtil.transToObj(document, DocumentDetailVO.class);
    }

    @Override
    public List<ListDocumentVO> listByType(Integer type) {
        RainDocument document = new RainDocument();
        document.setType(type);
        document.setStatus(StateConstants.STATE_ENABLE);
        List<RainDocument> documentList = rainDocumentDao.select(document);
        return documentList.stream().map(item -> {
            return CopyUtil.transToObj(item, ListDocumentVO.class);
        }).collect(Collectors.toList());
    }
}
