package com.mytests.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.util.Scanner;

/**
 * *
 * <p>Created by irina on 11.02.2021.</p>
 * <p>Project: test-jsonpath-expressions</p>
 * *
 */
public class UpdateJson {
    private InputStream initialJsonInputStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream("my1.json");
    private String initialJsonDataString = new Scanner(initialJsonInputStream, "UTF-8").useDelimiter("\\Z").next();
    private InputStream valueJsonInputStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream("my2.json");
    private String valueJsonDataString = new Scanner(valueJsonInputStream, "UTF-8").useDelimiter("\\Z").next();
    
    public  String readJson(){
        
        DocumentContext jsonContext = JsonPath.parse(initialJsonDataString);
        return jsonContext.read("$..p2[*].foo");
    }
    
    public  Object setJson(){
        DocumentContext valueJsonContext = JsonPath.parse(valueJsonDataString);
        Object value_json = valueJsonContext.json();
        DocumentContext jsonContext = JsonPath.parse(initialJsonDataString);
        return jsonContext.set("$..*",value_json).json();
    }
    public Object addJson(){
        DocumentContext valueJsonContext = JsonPath.parse(valueJsonDataString);
        Object value_json = valueJsonContext.json();
        DocumentContext jsonContext = JsonPath.parse(initialJsonDataString);
        return jsonContext.add("$..p2",value_json).json();
    }
    public Object deleteJson(){
        DocumentContext valueJsonContext = JsonPath.parse(valueJsonDataString);
        Object value_json = valueJsonContext.json();
        DocumentContext jsonContext = JsonPath.parse(initialJsonDataString);
        return jsonContext.delete("$..p2[?(@.zoo == 'ddd3')]").json();
    }
}
