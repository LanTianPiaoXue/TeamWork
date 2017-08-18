package com.learn.ygz.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JSONUtils {
    private static Logger logger = Logger.getLogger(JSONUtils.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static ObjectMapper objectMapperNew = new ObjectMapper();

    public static String toJsonStrByList(List<String> list) {
        return JSON.toJSONString(list, true);
    }

    public static String map2Json(Map map) {
        return JSON.toJSONString(map, true);
    }

    public static String array2Json(String[] arr) {
        return JSON.toJSONString(arr, true);
    }

    public static String json2Array(String str) {
        return JSON.parseArray(str).toString();
    }

    public static String[] convertListToJsonStrs(List<?> list) {
        JSONObject jsonObject = null;
        if (list != null && list.size() > 0) {
            String jsonStrs[] = new String[list.size()];
            for (int j = 0; j < list.size(); j++) {
                jsonObject = (JSONObject) JSON.toJSON(list.get(j));
                jsonStrs[j] = jsonObject.toString();
            }
            return jsonStrs;
        }
        return null;
    }

    private JSONUtils() {

    }

    public static ObjectMapper getInstance() {

        return objectMapper;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz)
            throws Exception {
        return objectMapper.readValue(jsonStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static <T> Map<String, Object> json2map(String jsonStr)
            throws Exception {
        return objectMapper.readValue(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean on unknown properties
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> List<T> json2listNew(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        objectMapperNew.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Map<String, Object>> list = objectMapperNew.readValue(
                jsonArrayStr, new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(objectMapperNew.convertValue(map, clazz));
        }
        return result;
    }

    /**
     * map convert to javaBean
     */
    public static <T> T map2pojo(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

    /**
     * 灏唎bj杞崲鎴恓son鏍煎紡鏁版嵁
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     * @date xieyunme 2015-8-6
     */
    public static String toJSONString(Object object) {
        String jsonStr = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // 鏄惁缂╂斁鎺掑垪杈撳嚭锛岄粯璁alse锛屾湁浜涘満鍚堜负浜嗕究浜庢帓鐗堥槄璇诲垯闇�瑕佸杈撳嚭鍋氱缉鏀炬帓鍒�
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * list convert to javaBean
     *
     * @param jsonStr
     * @param clazz
     * @return
     */
    public static <T> List<T> fromJsonArray(String jsonStr, Class<T> clazz)
            throws Exception {
        JavaType javaType = objectMapper.getTypeFactory()
                .constructParametricType(ArrayList.class, clazz);
        return objectMapper.readValue(jsonStr, javaType);
    }
    public static <T> T json2pojoNew(String jsonStr, Class<T> clazz) throws Exception {
        objectMapperNew.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapperNew.readValue(jsonStr, clazz);
    }

    /**
     * 灏唎bj杞崲鎴恓son鏍煎紡鏁版嵁
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     * @date xieyunme 2015-8-6
     */
    public static String toJSONString(Object object,boolean isformat) {
        String jsonStr = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // 鏄惁缂╂斁鎺掑垪杈撳嚭锛岄粯璁alse锛屾湁浜涘満鍚堜负浜嗕究浜庢帓鐗堥槄璇诲垯闇�瑕佸杈撳嚭鍋氱缉鏀炬帓鍒�
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, isformat);
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
