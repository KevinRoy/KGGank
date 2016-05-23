package com.kevin.kggank.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 16/5/22.
 */

public class DateUtil {

    /**
     * 截断日期
     *
     * @param date
     * @return
     */
    public static String cutDate(String date) {
        int position;
        String dateString = date;

        if (TextUtils.isEmpty(dateString)) {
            dateString = "";
        }

        if ((position = date.indexOf("T")) > 0) {
            dateString = date.substring(0, position);
        } else {
            dateString = "";
        }

        return dateString;
    }

    /**
     * 获取年月日的String list
     *
     * @param date
     * @return
     */
    public static List<String> getListDate(String date) {
        List<String> dates = new ArrayList<String>();
        if (TextUtils.isEmpty(date))
            return dates;

        int position = 0;

        for (int i = 0; i < 3; i++) {
            if (date.contains("-")) {
                dates.add(date.substring(position, date.indexOf("-")));
                date = date.substring(date.indexOf("-") + 1, date.length());
            } else {
                dates.add(date);
            }
        }

        return dates;
    }
}
