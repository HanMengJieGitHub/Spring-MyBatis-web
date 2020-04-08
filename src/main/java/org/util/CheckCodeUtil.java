package org.util;

public class CheckCodeUtil {
    private CheckCodeUtil(){}

    public static String getCheckCode(){
        String code = String.valueOf((int)((Math.random()*9+1)*100000));
        return code;
    }
}
