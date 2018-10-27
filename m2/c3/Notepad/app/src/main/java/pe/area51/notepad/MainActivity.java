package pe.area51.notepad;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentList.FragmentListInterface {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        final FragmentList fragmentList;
        if (savedInstanceState == null) {
            /*
            Creamos los fragments e iniciamos la transacción cuando este Activity se cree
            por primera vez.
             */
            fragmentList = new FragmentList();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragmentList)
                    .commit();
        }
        /*
        Si el Activity tiene un estado anterior, no es necesario crear los fragments o ejecutar nuevamente
        la transacción, puesto que en el proceso de recreación de estados, se recrea también el estado
        del FragmentManager.
        */
    }

    @Override
    public void onNoteSelected(Note note) {
        final FragmentContent fragmentContent = FragmentContent.newInstance(note);
        fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainer, fragmentContent)
                .commit();
    }
}
