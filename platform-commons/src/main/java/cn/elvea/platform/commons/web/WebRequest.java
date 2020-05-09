package cn.elvea.platform.commons.web;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * 请求上下文
 *
 * @author elvea
 */
public class WebRequest {
    // 分页查询相关属性
    private int page;
    private int size;
    private String sort;
    private String order;
    private String q;

    // 请求参数
    private Map<String, Object> params = Maps.newHashMap();

    public WebRequest(NativeWebRequest webRequest) {
        this(webRequest.getNativeRequest(HttpServletRequest.class));
    }

    public WebRequest(HttpServletRequest request) {
        String param = null;
        String value = null;

        param = "page";
        value = request.getParameter(param);
        if (!Strings.isNullOrEmpty(value)) {
            this.page = Integer.parseInt(value);
        } else {
            this.page = 1;
        }

        param = "size";
        value = request.getParameter(param);
        if (!Strings.isNullOrEmpty(value)) {
            this.size = Integer.parseInt(value);
        } else {
            this.size = 10;
        }

        param = "sort";
        value = request.getParameter(param);
        if (!Strings.isNullOrEmpty(value)) {
            this.sort = value;
        } else {
            this.sort = null;
        }

        param = "order";
        value = request.getParameter(param);
        if (!Strings.isNullOrEmpty(value)) {
            this.order = value;
        } else {
            this.order = "asc";
        }

        // 搜索关键字
        param = "q";
        value = request.getParameter(param);
        if (!Strings.isNullOrEmpty(value)) {
            this.q = value;
        }

        // 请求参数
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            param = e.nextElement();
            value = request.getParameter(param);
            this.params.put(param, value);
        }
    }

    /**
     * 获取Spring Data的Pageable对象
     */
    public Pageable getPageable() {
        if (!Strings.isNullOrEmpty(sort)) {
            Sort.Direction direction = "desc".equalsIgnoreCase(this.getOrder()) ? Sort.Direction.DESC : Sort.Direction.ASC;
            return PageRequest.of(this.page - 1, size, Sort.by(direction, sort));
        } else {
            return PageRequest.of(this.page - 1, size);
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
