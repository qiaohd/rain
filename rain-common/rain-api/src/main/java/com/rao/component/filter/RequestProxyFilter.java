

package com.rao.component.filter;


import com.rao.pojo.bo.RequestProxy;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 替换Request对象过滤器
 * 将所有的Request替换成自定义的RequestProxy
 *
 * @author raojing
 * @date 2020-04-11 11:12
 */

public class RequestProxyFilter implements Filter {

    public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestProxy = null;
        if (request instanceof HttpServletRequest) {
            if (StringUtils.isEmpty(request.getContentType()) || !request.getContentType().contains(RequestProxyFilter.CONTENT_TYPE_MULTIPART_FORM_DATA)) {
                requestProxy = new RequestProxy((HttpServletRequest) request);
            }
        }
        if (requestProxy == null) {
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(requestProxy, response);
        }
    }

    @Override
    public void destroy() {
    }
}
