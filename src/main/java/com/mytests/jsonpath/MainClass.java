package com.mytests.jsonpath;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * *
 * <p>Created by irina on 10.02.2021.</p>
 * <p>Project: test-jsonpath-expressions</p>
 * *
 */
public class MainClass {
    
    public static void main(String[] args) {
       
       String intro_user = "src/main/resources/intro_user.json";
       String json_lines = "src/main/resources/test_jsonl.jsonl";
       String meta = "src/main/resources/meta.json";
       String product = "src/main/resources/product.json";
       String foo = "src/main/resources/foo.json";
       String my = "src/main/resources/my.json";
       
       Charset charset = StandardCharsets.UTF_8;
        //language=JSONPath
        String expr0 = "$..*";
        
        //language=JSONPath
        String expr1 = "$.[*].password.old[?((@.value in ['Java_SE_7', 'L']&&(@.created > 0)))]";
        
        
        //language=JSONPath
        String expr2 = "$..name";
        
        //language=JSONPath
        String expr3 = "$.[*]['Value Information']['Platform Compensation'][*]['Platform mission Id', 'Value Rate']";

        //language=JSONPath
        String expr4 = "$.[?(@.Goal contains '2')]['Start Date']";  // contains n/s

        //language=JSONPath
        String expr5 = "$.rules.[0:3:1][?(@.comment && (@..rc empty false))].sinceBuild";  // slice start:end:step n/s
        //language=JSONPath
        String expr51 = "$.rules.[*][?(@.comment &&  (@..rc empty false || @.types size 2))].sinceBuild";  

        //language=JSONPath
        String expr6 = "$..[?(" +
                "['\"org.jetbrains.plugins.yaml\"','org.jetbrains.kotlin'] subsetof " +
                "@['optionalDependencies']" +
                ")].xmlId";
        //language=JSONPath
        String expr7 = "$..[?(@.bar[*] subsetof [\"aaa\",\"\\\"bbb\\\"\",@.['zoo']] )]";   // error is shown but probably this is ok
        //language=JSONPath
        String expr8 = "$..[?(@.['foo']==$.p1 || @.foo==@.zoo)]['foo','zoo']";
        //language=JSONPath
        String expr9 = "$.p2[?(@.foo===@.zoo)]['foo','zoo']";

        //language=JSONPath
        String expr10 = "$.p2[?(@.bar all [\"aaa\",\"bbb\",\"ccc\"])]";
        try {
            /*Processor.evaluateJsonPath(expr1,charset,intro_user);
            Processor.evaluateJsonPath(expr0,charset,json_lines);
            Processor.evaluateJsonPath(expr6,charset,meta);
            Processor.evaluateJsonPath(expr2,charset,meta);
            Processor.evaluateJsonPath(expr5,charset,product);
         Processor.evaluateJsonPath(expr3,charset,foo);
         Processor.evaluateJsonPath(expr4,charset,foo);*/
//         Processor.evaluateJsonPath(expr8,charset,my);
//         Processor.evaluateJsonPath(expr7,charset,my);
       //  Processor.evaluateJsonPath(expr9,charset,my);
         Processor.evaluateJsonPath(expr10,charset,my);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        //language=JSONPath
        String expr11 = "$.**.current";
        //language=JSONPath
        String expr12 = "[1].**.created";
        //language=JSONPath
        String expr14 = "[1]['username']";
        //language=JSONPath
        String expr13 = "*[1]";
        //language=JSONPath
        String expr15 = "***.size()";
        //language=JSONPath
        String expr16 = "[0]..created";
    }
}
