package cn.elvea.platform.commons.web;

import java.io.Serializable;

/**
 * WebResponse
 *
 * @param <E>
 * @author elvea
 */
public class WebResponse<E> implements Serializable {

    public final static int SUCCESS = 1;
    public final static int ERROR = 0;
    public final static int TOKEN_EXPIRE = -1;

    // 状态编码
    private int code;
    // 信息
    private String message;
    // 数据
    private E data;

    public WebResponse() {
    }

    public static WebResponse success() {
        return new WebResponse(SUCCESS);
    }

    public static <T> WebResponse<T> success(T data) {
        WebResponse<T> result = new WebResponse<>(SUCCESS);
        result.setData(data);
        return result;
    }

    public static WebResponse error() {
        return new WebResponse<>(ERROR);
    }

    public static <T> WebResponse<T> error(String message) {
        return new WebResponse<>(ERROR, message);
    }

    public WebResponse(int code) {
        this.code = code;
    }

    public WebResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public WebResponse(int code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
