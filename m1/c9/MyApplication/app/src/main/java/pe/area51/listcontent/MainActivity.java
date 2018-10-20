package pe.area51.listcontent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if(savedInstanceState==null){
            final ListFragment listFragment = new ListFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, listFragment)
                    .commit();
        }
    }
}
