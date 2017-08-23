package com.sunilsahoo.testapp3.utils;

/**
 * Created by sunilkumarsahoo on 5/19/16.
 */
public class Utility {
    public static boolean isEmpty(String str){
        if((str == null) || str.trim().length() <=0){
            return true;
        }
        return false;
    }
}
