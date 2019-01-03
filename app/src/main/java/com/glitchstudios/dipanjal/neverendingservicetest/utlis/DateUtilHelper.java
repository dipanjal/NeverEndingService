package com.glitchstudios.dipanjal.neverendingservicetest.utlis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilHelper {
    public static String CURRENT_TIME_12HOURS_FORMAT = "HH:mm:ss a";
    private static DateUtilHelper dateUtilHelper;
    public static DateUtilHelper getInstance(){
        if(dateUtilHelper==null){
            dateUtilHelper = new DateUtilHelper();
        }
        return dateUtilHelper;
    }

    public String getCurrentdateString(String dateFormat) throws Exception{
        return new SimpleDateFormat(dateFormat).format(new Date());
    }
}
