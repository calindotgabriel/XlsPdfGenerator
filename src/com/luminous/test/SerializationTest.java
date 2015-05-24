package com.luminous.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luminous.JsonSerializer;
import com.luminous.domain.Rule;
import com.luminous.utils.Util;
import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class SerializationTest extends TestCase {

    public static final String SIMPLE_PATH = "res/fill_rule.json";
    public static final String ARRAY_PATH = "res/fill_rule2.json";

    public void testSimpleSerialization() throws IOException {
        Rule rule = buildRule(SIMPLE_PATH);
        assertNotNull(rule);
    }

    private Rule buildRule(String path) throws IOException {
        Gson gson = new Gson();
        String in = Util.readFile(path);
        return gson.fromJson(in, Rule.class);
    }

    public void testMultipleSerialization() throws IOException, ClassNotFoundException {

        JsonSerializer serializer = new JsonSerializer(ARRAY_PATH);
        List<Rule> rules = serializer.serializeJsonArray();

        assertEquals(2, rules.size());
    }
}
