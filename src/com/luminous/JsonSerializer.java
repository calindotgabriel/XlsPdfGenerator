package com.luminous;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luminous.domain.Rule;
import com.luminous.utils.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class JsonSerializer {

    private String jsonPath;
    private String jsonArray;

    public static final Type LIST_TYPE = new TypeToken<ArrayList<Rule>>() {
    }.getType();


    public JsonSerializer(String jsonPath) throws IOException {
        this.jsonPath = jsonPath;
        this.jsonArray = Util.readFile(jsonPath);
    }


    public List<Rule> serializeJsonArray() {
        return new Gson().fromJson(jsonArray, LIST_TYPE);
    }
}
