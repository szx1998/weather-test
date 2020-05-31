package com.weather.service.impl;
import com.weather.service.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class JsonUtilImpl implements JsonUtil {
    @Override
    public List<String> getData(String json) {
        ArrayList<String> lists = new ArrayList<String>();
        JsonParser jsonParser = new JsonParser();
        JsonObject object=(JsonObject) jsonParser.parse(json);
        JsonArray array=object.get("results").getAsJsonArray();
        JsonObject sJsonObject = array.get(0).getAsJsonObject();
        JsonObject location = sJsonObject.get("location").getAsJsonObject();
        JsonObject now = sJsonObject.get("now").getAsJsonObject();

        lists.add(location.get("name").getAsString());
        lists.add(now.get("text").getAsString());
        lists.add(now.get("temperature").getAsString());
        return lists;

    }
}
