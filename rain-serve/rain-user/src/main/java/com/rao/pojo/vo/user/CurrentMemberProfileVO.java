package com.rao.pojo.vo.user;

import lombok.Data;

/**
 * 当前用户个人资料
 *
 * @author raojing
 * @date 2020/4/6 17:37
 */
@Data
public class CurrentMemberProfileVO {

    /**
     * 会员编号
     */
    private String memberNo;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 性别 0-未知 1-男 2-女
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 个性签名
     */
    private String personalSignature;

    /**
     * 出生日期
     */
    private String birthday;

}
