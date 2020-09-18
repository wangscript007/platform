package cn.elvea.platform.commons.web.support;

import cn.elvea.platform.commons.utils.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * XssHttpServletRequestWrapper
 *
 * @author elvea
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = super.getHeader(name);
        if (StringUtils.isEmpty(headerValue)) {
            return headerValue;
        }
        return handleValue(super.getHeader(name));
    }

    @Override
    public String getParameter(String name) {
        String parameterValue = super.getParameter(name);
        if (StringUtils.isEmpty(parameterValue)) {
            return parameterValue;
        }
        return handleValue(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameterValues = super.getParameterValues(name);
        if (parameterValues != null) {
            int length = parameterValues.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapseValues[i] = handleValue(parameterValues[i]);
            }
            return escapseValues;
        }
        return null;
    }

    private String handleValue(String value) {
        return WebUtils.escapeHtml(value);
    }

}
