package com.kevin.kglib.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 关于String 相关的utils
 * Created by kevin on 16/8/18.
 */

public class StringUtils {

    /**
     * 是否是汉字
     * @param s
     * @return
     */
    public static boolean isChinese(String s) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}
