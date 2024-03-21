package com.imtiaz.customtrycal;

import android.graphics.Color;

public class DisabledColorDecorator implements DayDecorator {
    @Override
    public void decorate(DayView dayView) {
        if (CalendarUtils.isPastDay(dayView.getDate())) {
            int color = Color.parseColor("#a9afb9");
            dayView.setBackgroundColor(color);
        }
    }
}