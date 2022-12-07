package com.app.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MyJSONUtil {
    public static<T> String addKeyValue(String json , String key ,T value ){

        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.put(key , value);
        return JSON.toJSONString(jsonObject);

    }
}
