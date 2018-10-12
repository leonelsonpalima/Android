package pe.area51.clase05;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonExecutelongTaskOnMainThread)
                .setOnClickListener(this);

        findViewById(R.id.buttonExecutelongTaskOnWorkerThread)
                .setOnClickListener(this);
    }

    private void executeLongTask(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonExecutelongTaskOnMainThread:
                executeLongTaskOnMainThread();
                break;
            case R.id.buttonExecutelongTaskOnWorkerThread:
                executeLongTaskOnWorkerThread();
                break;
        }
    }

    private void executeLongTaskOnMainThread(){
        final Dialog progressDialog = createProgressDialog();
        progressDialog.show();
        executeLongTask();
        progressDialog.dismiss();
    }

    private void executeLongTaskOnWorkerThread(){
        final Dialog progressDialog = createProgressDialog();
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                executeLongTask();
                progressDialog.dismiss();
            }
        }).start();
    }

    private Dialog createProgressDialog(){
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.progress_message));
        return progressDialog;
    }
}
