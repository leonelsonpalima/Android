package pe.area51.airplanemoddetector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewAirplaneMode;
    private AirplaneModBroadcastReceiver airplaneModBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewAirplaneMode = findViewById(R.id.TextViewAirplaneMode);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showAirplaneModeState(isAirplaneModeOn());
        airplaneModBroadcastReceiver = new AirplaneModBroadcastReceiver();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModBroadcastReceiver);
    }

    private void showAirplaneModeState(final boolean isAirplaneModeOn){
        if(isAirplaneModeOn){
            textViewAirplaneMode.setText(R.string.airplane_mode_enabled);
            return;
        }
        textViewAirplaneMode.setText(R.string.airplane_mode_disabled);
    }

    private boolean isAirplaneModeOn(){
        return false;
    }

    private class AirplaneModBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            final boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

            //Toast.makeText(context, "onReceive", Toast.LENGTH_SHORT).show();
            showAirplaneModeState(isAirplaneModeOn);

        }
    }

    /*
    *
    * Cuatro componentes tienen los sistemas Android
    *
    * Activity: Presentar una interfaz al usuario
    * Broadcast Receiver: Componente diseñado para capturar eventos de las aplicaciones del sistema
    * Service: Para funcionar en segundo plano
    * Content Provider: Esta diseñado para compartir información
    *
    * */


}
