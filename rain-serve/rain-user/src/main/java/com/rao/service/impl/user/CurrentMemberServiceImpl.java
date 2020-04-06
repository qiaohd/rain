package com.rao.service.impl.user;

import com.rao.constant.common.DateFormatEnum;
import com.rao.dao.user.RainMemberDao;
import com.rao.pojo.dto.WxProfileDTO;
import com.rao.pojo.entity.user.RainMember;
import com.rao.pojo.vo.user.CurrentMemberProfileVO;
import com.rao.service.user.CurrentMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 当前会员 service impl
 *
 * @author raojing
 * @date 2020/4/6 17:21
 */
@Slf4j
@Service
public class CurrentMemberServiceImpl implements CurrentMemberService {

    @Resource
    private RainMemberDao rainMemberDao;

    @Override
    public void updateWxProfile(WxProfileDTO wxProfileDTO, Long id) {
        RainMember member = rainMemberDao.selectByPrimaryKey(id);
        log.info("用户更新之前的信息:{}", member);
        if(member != null){
            RainMember updateMember = new RainMember();
            updateMember.setId(member.getId());
            updateMember.setAvatar(wxProfileDTO.getAvatar());
            updateMember.setWxNickname(wxProfileDTO.getWxNickname());
            updateMember.setGender(wxProfileDTO.getGender());
            if(StringUtils.isBlank(member.getNickname())){
                // 如果昵称为空，将微信昵称填入，昵称支持用户修改
                updateMember.setNickname(wxProfileDTO.getWxNickname());
            }
            rainMemberDao.updateByPrimaryKeySelective(updateMember);
        }
    }

    @Override
    public CurrentMemberProfileVO profile(Long id) {
        RainMember member = rainMemberDao.selectByPrimaryKey(id);
        CurrentMemberProfileVO memberProfile = new CurrentMemberProfileVO();
        BeanUtils.copyProperties(member, memberProfile);
        // 用户编号为随机生成的用户名
        memberProfile.setMemberNo(member.getUserName());
        memberProfile.setBirthday(DateFormatUtils.format(member.getBirthday(), DateFormatEnum.FORMAT_SYMBOL_BASE.getFormatString()));
        return memberProfile;
    }

}
