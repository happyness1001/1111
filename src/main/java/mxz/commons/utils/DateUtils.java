package mxz.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     *将指定日期格式化为：yyyy-MM-dd HH:mm:ss
     * @param date 日期
     * @return 字符串
     */
    public static String formateDateTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = simpleDateFormat.format(date);
        return datestr;
    }
}
