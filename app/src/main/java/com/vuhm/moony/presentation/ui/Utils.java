package com.vuhm.moony.presentation.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss yyyy-mm-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
