package cn.elvea.platform.commons.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * WebResponse
 * 接口数据
 *
 * @param <E>
 * @author elvea
 */
@Data
@AllArgsConstructor
@Builder
@Schema
public class WebResponse<E> implements Serializable {
    public final static int SUCCESS = 1;
    public final static int ERROR = 0;
    public final static int TOKEN_EXPIRE = -1;

    /**
     * 状态编码
     */
    private int code;
    /**
     * 信息
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    /**
     * 数据
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private E data;

    public static WebResponse<?> success() {
        return WebResponse.builder().code(SUCCESS).build();
    }

    public static <T> WebResponse<T> success(T data) {
        return WebResponse.<T>builder().code(SUCCESS).data(data).build();
    }

    public static WebResponse<?> error() {
        return WebResponse.builder().code(ERROR).build();
    }

    public static WebResponse<?> error(String message) {
        return WebResponse.builder().code(ERROR).message(message).build();
    }

    public static <T> WebResponse<T> error(String message, T data) {
        return WebResponse.<T>builder().code(ERROR).message(message).data(data).build();
    }

}
