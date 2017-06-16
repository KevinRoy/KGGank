package com.kevin.kglib.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式相关的utils
 * Created by kevin on 2017/6/16.
 */

public class FormatUtils {

    /**
     * 是否是汉字
     *
     * @param s
     * @return
     */
    public static boolean isChinese(String s) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    /**
     * 是否是手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobile(String mobiles) {
        Pattern p = Pattern.compile("^1[0-9]{10}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
