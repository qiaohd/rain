package com.rao.service.user;

import com.rao.pojo.dto.WxProfileDTO;
import com.rao.pojo.vo.user.CurrentMemberProfileVO;

/**
 * 当前会员 service
 *
 * @author raojing
 * @date 2020/4/6 17:21
 */
public interface CurrentMemberService {

    /**
     * 更新微信个人信息
     *
     * @param wxProfileDTO
     * @param id
     */
    void updateWxProfile(WxProfileDTO wxProfileDTO, Long id);

    /**
     * 用户个人信息
     *
     * @param id
     * @return
     */
    CurrentMemberProfileVO profile(Long id);
}
