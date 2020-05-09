package cn.elvea.platform.commons.utils;

import cn.elvea.platform.commons.constants.SystemConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * WebUtils
 *
 * @author elvea
 */
public class WebUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 判断当前请求是否是Ajax请求
     *
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }

    /**
     * 判断当前请求是否是JSONP请求
     *
     * @param request HttpServletRequest
     * @param param   String
     * @return boolean
     */
    public static boolean isJsonpRequest(HttpServletRequest request, String param) {
        return request.getParameter(param) != null;
    }

    public static String isJsonpCallback(HttpServletRequest request, String param) {
        return request.getParameter(param);
    }

    /**
     * 获取Referer
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getReferer(HttpServletRequest request) {
        return request.getHeader("REFERER");
    }

    /**
     * 获取提交方式
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getMethod(HttpServletRequest request) {
        return request.getMethod();
    }

    /**
     * 获取客户端IP
     *
     * @param request HttpServletRequest
     * @return String
     */

    public static String getHost(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (Strings.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (Strings.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (Strings.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (Strings.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip)) {
            InetAddress inet;
            try { // 根据网卡取本机配置的IP
                inet = InetAddress.getLocalHost();
                ip = inet.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * 直接输出内容的简便函数.
     */
    public static void render(HttpServletResponse response, final String contentType, final String content, final String... headers) {
        response = initResponseHeader(response, contentType, headers);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 直接输出文本.
     */
    public static void renderText(HttpServletResponse response, final String text, final String... headers) {
        render(response, ServletUtils.TEXT_TYPE, text);
    }

    /**
     * 直接输出HTML.
     */
    public static void renderHtml(HttpServletResponse response, final String html, final String... headers) {
        render(response, ServletUtils.HTML_TYPE, html, headers);
    }

    /**
     * 直接输出XML.
     */
    public static void renderXml(HttpServletResponse response, final String xml, final String... headers) {
        render(response, ServletUtils.XML_TYPE, xml, headers);
    }

    /**
     * 直接输出JSON.
     */
    public static void renderJson(HttpServletResponse response, final String jsonString, final String... headers) {
        render(response, ServletUtils.JSON_TYPE, jsonString, headers);
    }

    /**
     * 直接输出JSON,使用Jackson转换Java对象.
     */
    public static void renderJson(HttpServletResponse response, final Object data, final String... headers) {
        response = initResponseHeader(response, ServletUtils.JSON_TYPE);
        try {
            mapper.writeValue(response.getWriter(), data);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 直接输出支持跨域Mashup的JSONP.
     */
    public static void renderJsonp(HttpServletResponse response, final String callbackName, final Object object, final String... headers) {
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        String result = callbackName + "(" + jsonString + ");";

        render(response, ServletUtils.JS_TYPE, result, headers);
    }

    private static HttpServletResponse initResponseHeader(HttpServletResponse response, final String contentType, final String... headers) {
        // 设置headers参数
        String fullContentType = contentType + "; charset=" + SystemConstants.ENCODING;
        response.setContentType(fullContentType);
        ServletUtils.setNoCacheHeader(response);
        return response;
    }
}
