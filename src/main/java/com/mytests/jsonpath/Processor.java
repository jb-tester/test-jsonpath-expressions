package com.mytests.jsonpath;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * *
 * <p>Created by irina on 10.02.2021.</p>
 * <p>Project: test-jsonpath-expressions</p>
 * *
 */
public class Processor {
    private static String readFile(String filepath, Charset charset) throws IOException {
        File file = new File(filepath);
        return new String(Files.readAllBytes(file.toPath()), charset);
        
    }
    public static void evaluateJsonPath(String expr, Charset charset, String filepath) throws IOException {
        
        String json = readFile(filepath, charset);
        JSONArray rez = JsonPath.read(json, expr);
        System.out.println("==== evaluate expression " + expr + " =====");
        System.out.println(rez.toJSONString());
    }
}
