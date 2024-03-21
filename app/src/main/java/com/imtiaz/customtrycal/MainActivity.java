package com.imtiaz.customtrycal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.imtiaz.customtrycal.others.CalendarDayDecoratorActivity;
import com.imtiaz.customtrycal.others.CustomisedCalendarActivity;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private String[] listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listData = getResources().getStringArray(R.array.calendar_demos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, R.id.textView, listData);

        listView = (ListView) findViewById(R.id.demo_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://stacktips.com"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final String selectedValue = listData[position];
        if (selectedValue.equals(getString(R.string.simple_calendar))) {
            startActivity(new Intent(this, SimpleCalendarActivity.class));
        } /*else if (selectedValue.equals(getString(R.string.calendar_day_decorator))) {
            startActivity(new Intent(this, CalendarDayDecoratorActivity.class));
        } else if (selectedValue.equals(getString(R.string.customizing_custom_calendar))) {
            startActivity(new Intent(this, CustomisedCalendarActivity.class));
        }*/
    }
}
