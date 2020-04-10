package com.rao.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单操作日志
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainOrderDisposeLog {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @Id
    private Long orderId;

    /**
     * 是否为管理员处理 1-是 2-否
     */
    @Column(name = "dispose_is_manager")
    private Integer disposeIsManager;

    /**
     * 操作人ID
     */
    @Column(name = "dispose_user_id")
    private Long disposeUserId;

    /**
     * 操作人昵称
     */
    @Column(name = "dispose_nickname")
    private String disposeNickname;

    /**
     * 操作描述
     */
    @Column(name = "operation_desc")
    private String operationDesc;

    /**
     * 操作时间
     */
    @Column(name = "create_time")
    private Date createTime;


}
