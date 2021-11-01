package com.mytests.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class Main {
    public static void main(String[] args) {
        DocumentContext data = JsonPath.parse("{\n" +
                "  \"name\" : \"name1\",\n" +
                "  \"version\": 1,\n" +
                "  \"features\" : {\n" +
                "    \"part1\" : {\n" +
                "      \"group\" : \"g1\",\n" +
                "      \"id\" : \"Part1\",\n" +
                "      \"description\" : \"xxx\"\n" +
                "    },\n" +
                "    \"part2\" : {\n" +
                "      \"group\" : \"g2\",\n" +
                "      \"id\" : \"Part2\",\n" +
                "      \"description\" : \"yyy\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"devs\": {\n" +
                "    \"dev1\": {\n" +
                "      \"name\": \"vasya\",\n" +
                "      \"age\": 25\n" +
                "    },\n" +
                "    \"dev2\": {\n" +
                "      \"name\": \"masha\",\n" +
                "      \"age\": 27\n" +
                "    }\n" +
                "  }\n" +
                "}");
         
        data.put("$.features.*", "num", 333);
        System.out.println(data.jsonString());
        data.put("$.devs.*","level","junior");
        System.out.println(data.jsonString());
        data.renameKey("$.devs.*", "level", "grade");
        System.out.println(data.jsonString());
        data.renameKey("$.features.*", "num", "size");
        System.out.println(data.jsonString());
        
    }
}