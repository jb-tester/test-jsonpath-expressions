package com.mytests.jsonpath;

/**
 * *
 * <p>Created by irina on 11.02.2021.</p>
 * <p>Project: test-jsonpath-expressions</p>
 * *
 */
public class MainClass2 {
    public static void main(String[] args) {
        UpdateJson updateJson = new UpdateJson();
        System.out.println("== read == ");
        System.out.println(updateJson.readJson());
        System.out.println("== set == ");
        System.out.println(updateJson.setJson().toString());
        System.out.println("== add == ");
        System.out.println(updateJson.addJson().toString());
        System.out.println("== delete == ");
        System.out.println(updateJson.deleteJson().toString());
    }
}
