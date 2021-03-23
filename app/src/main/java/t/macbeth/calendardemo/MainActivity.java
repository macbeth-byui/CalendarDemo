package t.macbeth.calendardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<EventDay> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        events = new ArrayList<>();

        CalendarView calendarView = findViewById(R.id.calendarView);

        // Every time someone clicks on a date, then add a new Event
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                // Take the calendar information from the eventDay parameter and use
                // it to create a new EventDay with an associated picture
                EventDay newEvent = new EventDay(eventDay.getCalendar(), R.drawable.sample_three_icons);

                // Add the event to our list
                events.add(newEvent);

                // To refresh the calendar, we need to call setEvents again.
                calendarView.setEvents(events);
            }
        });
    }


}