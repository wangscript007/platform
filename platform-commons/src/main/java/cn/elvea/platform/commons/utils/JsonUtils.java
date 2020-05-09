package cn.elvea.platform.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Json相关的工具类
 *
 * @author elvea
 */
@SuppressWarnings({"unchecked"})
public class JsonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T toObject(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }

    public static Map<String, Object> toMap(String json) throws Exception {
        return objectMapper.readValue(json, Map.class);
    }

    public static <T> T mapToObject(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

}
