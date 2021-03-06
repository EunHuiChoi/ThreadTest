package com.example.notbreaingtherules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View v) {
        new MyAsyncTask().execute();
    }

    public class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            status = findViewById(R.id.countdown);
            super.onPreExecute();
            status.setText("Start");
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            try {
                for (int i = 3; i >= 0; i--) {
                    Thread.sleep(1000);
                    publishProgress(i);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            return 0;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            status = findViewById(R.id.countdown);
            status.setText(Integer.toString(progress[0]));
        }

        @Override
        protected void onPostExecute (Integer result) {
            status = findViewById(R.id.countdown);
            status.setText("Done");
            super.onPostExecute(result);
        }
    }
}
