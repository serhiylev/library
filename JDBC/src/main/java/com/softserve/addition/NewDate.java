package com.softserve.addition;

import java.sql.Date;

public class NewDate extends Date {

    Date date;

    public NewDate(int year, int month, int day) {
        super(year-1900, month, day);
    }

    public NewDate(long date) {
        super(date);
    }


}
