package com.rao.controller.user;

import com.rao.annotation.BeanValid;
import com.rao.pojo.bo.CurrentUserInfo;
import com.rao.pojo.dto.WxProfileDTO;
import com.rao.pojo.vo.user.CurrentMemberProfileVO;
import com.rao.service.user.CurrentMemberService;
import com.rao.util.result.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 当前系统用户
 *
 * @author raojing
 * @date 2020/4/6 17:01
 */
@Slf4j
@RestController
@RequestMapping("/current/member")
public class CurrentMemberController {

    @Resource
    private CurrentMemberService currentMemberService;

    /**
     * 更新微信个人信息
     *
     * @param wxProfileDTO
     * @param currentUser
     * @return
     */
    @PostMapping("/update_wx_profile")
    public ResultMessage updateWxProfile(@BeanValid @RequestBody WxProfileDTO wxProfileDTO,
                                         CurrentUserInfo currentUser) {
        currentMemberService.updateWxProfile(wxProfileDTO, currentUser.getId());
        return ResultMessage.success().message("更新用户信息成功");
    }

    /**
     * 用户个人信息
     *
     * @param currentUser
     * @return
     */
    @GetMapping("/profile")
    public ResultMessage<CurrentMemberProfileVO> profile(CurrentUserInfo currentUser) {
        CurrentMemberProfileVO memberProfile = currentMemberService.profile(currentUser.getId());
        return ResultMessage.success(memberProfile).message("获取个人信息成功");
    }

}
