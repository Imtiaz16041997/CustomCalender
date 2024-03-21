package com.imtiaz.customtrycal;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class SimpleCalendarActivity extends AppCompatActivity {
    CustomCalendarView calendarView;
    private TextView selectedDateTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calendar);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Initialize CustomCalendarView from layout
        calendarView = (CustomCalendarView) findViewById(R.id.calendar_view);
        selectedDateTv = (TextView) findViewById(R.id.selected_date);
        //Initialize calendar with date
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        //Show monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        //Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);

        //call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);




/*
 Specific date specific color
// Create a map of specific dates and their corresponding colors
        Map<Date, Integer> specificDateColorMap = new HashMap<>();
// Create specific Date objects for your dates
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MARCH, 25); // Set the year, month, and day for your first specific date
        Date firstSpecificDate = calendar.getTime();

        calendar.set(2024, Calendar.APRIL, 10); // Set the year, month, and day for your second specific date
        Date secondSpecificDate = calendar.getTime();

// Add your specific dates and colors to the map
        specificDateColorMap.put(firstSpecificDate, Color.GREEN); // Add first specific date with color green
        specificDateColorMap.put(secondSpecificDate, Color.BLUE); // Add second specific date with color blue

// Call the method to set specific dates and their colors
        calendarView.setSpecificDatesColor(specificDateColorMap);*/

        // Create a list of specific dates
        List<Date> specificDates = new ArrayList<>();
        // Add your specific dates to the list
        // For example:
         specificDates.add(new Date()); // Add specific date
         //specificDates.add(anotherDate); // Add another specific date

        // Call the method to color specific dates
        calendarView.setSpecificDatesColor(specificDates, Color.RED);
        // Initialize PopupWindow


        //Handling custom calendar events
        // Handling custom calendar events
        calendarView.setCalendarListener(new CalendarListener() {
            @Override
            public void onDateSelected(final Date date) {
                if (!CalendarUtils.isPastDay(date)) {
                    // Format the selected date
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                    String selectedDate = df.format(date);

                    // Create and show an AlertDialog to display the selected date
                    new AlertDialog.Builder(SimpleCalendarActivity.this)
                            .setTitle("Selected Date")
                            .setMessage("Selected date is " + selectedDate)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Handle OK button click if needed
                                }
                            })
                            .show();
                } else {
                    selectedDateTv.setText("Selected date is disabled!");
                }
            }

            @Override
            public void onMonthChanged(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
                Toast.makeText(SimpleCalendarActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
