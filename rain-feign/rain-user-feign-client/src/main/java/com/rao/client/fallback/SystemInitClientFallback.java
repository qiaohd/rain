package com.rao.client.fallback;

import com.rao.client.SystemInitClient;
import com.rao.util.result.ResultMessage;
import feign.hystrix.FallbackFactory;

/**
 * 熔断器
 *
 * @author raojing
 * @date 2020/4/6 14:28
 */
public class SystemInitClientFallback implements FallbackFactory<SystemInitClient> {

    @Override
    public SystemInitClient create(Throwable throwable) {
        return new SystemInitClient() {
            @Override
            public ResultMessage initMemberRole(Long userId) {
                return ResultMessage.fail().message("初始化会员角色失败");
            }
        };
    }

}
