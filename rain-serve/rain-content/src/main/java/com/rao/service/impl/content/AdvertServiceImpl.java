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
                .andEqualTo("adType", type)
                .andGreaterThanOrEqualTo("startTime", now)
                .andLessThanOrEqualTo("endTime", now);
        List<RainAdvert> adverts = rainAdvertDao.selectByExample(example);
        return adverts.stream().map(item -> {
            return CopyUtil.transToObj(item, ListAdvertVO.class);
        }).collect(Collectors.toList());
    }

}
