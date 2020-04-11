
package com.rao.component.resolver;

import com.alibaba.fastjson.JSONObject;
import com.rao.annotation.SimpleParam;
import com.rao.exception.BusinessException;
import com.rao.pojo.bo.RequestProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;


/**
 * @author raojing
 * @date 2020-04-11 11:12
 */
@Slf4j
public class SimpleParamResolver implements HandlerMethodArgumentResolver {

    /**
     * 判断Resolver是否支持该参数
     *
     * @param methodParameter 方法参数
     * @return boolean true为支持
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Parameter param = methodParameter.getParameter();
        return param.getDeclaredAnnotation(SimpleParam.class) != null;

    }

    /**
     * 参数转换
     *
     * @param methodParameter       方法参数
     * @param modelAndViewContainer model容器
     * @param nativeWebRequest      与HttpServletRequest相关
     * @param webDataBinderFactory  数据绑定相关
     * @return 转换后的对象
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {

        // 获取注解上的值
        String parameterName = methodParameter.getParameter().getDeclaredAnnotation(SimpleParam.class).value();
        if (StringUtils.isEmpty(parameterName)) {
            parameterName = methodParameter.getParameterName();
        }

        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        try {
            // 将body字符串转化为json，然后从json中获取key = parameterName的值
            // 先下转型，转成自己定义的RequestProxy，获取方法的参数Json
            RequestProxy requestProxy = (RequestProxy) request;

            JSONObject json = requestProxy.getAttributeJson();

            Parameter parameter = methodParameter.getParameter();
            if (json == null) {
                return null;
            }
            return json.getObject(parameterName, parameter.getType());

        } catch (Exception e) {
            throw BusinessException.operate("参数错误");
        }
    }
}
