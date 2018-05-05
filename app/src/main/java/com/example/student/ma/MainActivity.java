package com.example.student.ma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MaActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        if(view.getId()==R.id.id1){
            ThreadT tc=new ThreadT();
            tc.start();
        }
    }

    class ThreadT extends Thread{
        @Override
        public void run() {
            super.run();
            Log.e(TAG, "kklfk");
            try {
                URL url= new URL("http://api.openweathermap.org/data/2.5/weather?q=Odessa&appid=2e8071162c252667850af8964461d855");
                HttpURLConnection huc=(HttpURLConnection)url.openConnection();
                BufferedReader br=new BufferedReader(new InputStreamReader(huc.getInputStream()));
                StringBuilder sb=new StringBuilder();
                String line;
                while((line=br.readLine())!=null){sb.append(line);}
                Log.d(TAG, sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
