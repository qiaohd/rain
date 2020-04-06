package com.rao.client;

import com.rao.client.fallback.SystemInitClientFallback;
import com.rao.configuration.FeignRequestConfiguration;
import com.rao.constant.server.ServiceInstanceConstant;
import com.rao.util.result.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 系统初始化 客户端
 *
 * @author raojing
 * @date 2020/4/6 14:26
 */
@FeignClient(
        value = ServiceInstanceConstant.RAIN_USER,
        path = "/user",
        configuration = FeignRequestConfiguration.class,
        fallbackFactory = SystemInitClientFallback.class
)
public interface SystemInitClient {

    /**
     * 初始化会员角色
     * @param userId
     * @return
     */
    @PostMapping("/init/member_role")
    ResultMessage initMemberRole(@RequestParam("userId") Long userId);

}
