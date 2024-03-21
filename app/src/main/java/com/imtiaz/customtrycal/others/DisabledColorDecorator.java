package com.imtiaz.customtrycal.others;

import android.graphics.Color;

import com.imtiaz.customtrycal.CalendarUtils;
import com.imtiaz.customtrycal.DayDecorator;
import com.imtiaz.customtrycal.DayView;

public class DisabledColorDecorator implements DayDecorator {
    @Override
    public void decorate(DayView dayView) {
        if (CalendarUtils.isPastDay(dayView.getDate())) {
            int color = Color.parseColor("#a9afb9");
            dayView.setBackgroundColor(color);
        }
    }
}