package pe.area51.timecounter;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCount;
    private Handler handler;
    private long startTimeStamp;
    private final static int DELAY_IN_MILLIS = 1;
    private boolean isCounterRunning;

    private Runnable counterRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount);
        startTimeStamp = SystemClock.elapsedRealtime();
        handler = new Handler();
        isCounterRunning = false;
        counterRunnable = new Runnable() {
            @Override
            public void run() {
                final int elapsedTime =(int) (SystemClock.elapsedRealtime() - startTimeStamp);
                showCount(elapsedTime);
                handler.postDelayed(this, DELAY_IN_MILLIS);
            }
        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionSwitchCounter) {
            switchTimeCounter();
            return true;
        }
        return false;
    }

    private void switchTimeCounter() {

        //Log.i("MainActivity", "switchTimeCounte");
        if (isCounterRunning) {
            handler.removeCallbacks(counterRunnable);
            isCounterRunning = false;
            return;
        }
        startTimeStamp = SystemClock.elapsedRealtime();
        handler.post(counterRunnable);
        isCounterRunning = true;
    }

    private void showCount(final int count) {
        textViewCount.setText(String.valueOf(count));
    }
}
