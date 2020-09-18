package cn.elvea.platform.commons.utils;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.Map;

/**
 * Json相关的工具类
 *
 * @author elvea
 */
@SuppressWarnings({"unchecked"})
public abstract class JsonUtils {

    private final static JsonMapper objectMapper = JsonMapper.builder()
            .enable(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES)
            .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS)
            .enable(JsonReadFeature.ALLOW_MISSING_VALUES)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build();

    private JsonUtils() {
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    /**
     * Object -> Json
     */
    public static String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * Json -> Object
     */
    public static <T> T toObject(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * Json -> Map
     */
    public static Map<String, Object> toMap(String json) throws Exception {
        return objectMapper.readValue(json, Map.class);
    }

}
