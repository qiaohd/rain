package com.rao.service.impl.content;

import com.rao.constant.common.StateConstants;
import com.rao.dao.content.RainAdvertDao;
import com.rao.pojo.entity.content.RainAdvert;
import com.rao.pojo.vo.content.ListAdvertVO;
import com.rao.service.content.AdvertService;
import com.rao.util.common.CopyUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 广告-service impl
 *
 * @author raojing
 * @date 2020/4/11 11:11
 */
@Service
public class AdvertServiceImpl implements AdvertService {

    @Resource
    private RainAdvertDao rainAdvertDao;

    @Override
    public List<ListAdvertVO> listByType(Integer type) {
        Example example = new Example(RainAdvert.class);
        Date now = new Date();
        example.createCriteria()
                .andEqualTo("status", StateConstants.STATE_ENABLE)
                .andEqualTo("position", type)
                .andLessThanOrEqualTo("startTime", now)
                .andGreaterThanOrEqualTo("endTime", now);
        List<RainAdvert> adverts = rainAdvertDao.selectByExample(example);
        return adverts.stream().map(item -> {
            ListAdvertVO advertVO = CopyUtil.transToObj(item, ListAdvertVO.class);
            int adType = item.getAdType();
            if (adType == 1) {
                advertVO.setAdContent(item.getAdUrl());
            } else if (adType == 2) {
                advertVO.setAdContent(String.valueOf(item.getDocumentId()));
            }
            return advertVO;
        }).collect(Collectors.toList());
    }

}
