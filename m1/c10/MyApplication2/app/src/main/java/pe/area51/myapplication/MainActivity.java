package pe.area51.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final static String FRAGMENT_TAG_LIST = "fragmentList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            final FragmentList fragmentList = new FragmentList();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragmentList, FRAGMENT_TAG_LIST)
                    .commit();

        }
    }
}
