package cn.elvea.platform.commons.web.filter;

import cn.elvea.platform.commons.web.support.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * XssFilter
 *
 * @author elvea
 */
public class XssFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        XssHttpServletRequestWrapper wrapper = new XssHttpServletRequestWrapper(req);
        chain.doFilter(wrapper, response);
    }

}
