package com.apinanpaska.web.util;

import java.util.UUID;

public class GeneralUtil {
    //change later to a better algorithm
    public static String randomToken(){
        return UUID.randomUUID().toString();
    }
}
