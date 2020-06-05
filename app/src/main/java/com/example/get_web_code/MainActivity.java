package com.example.get_web_code;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }






    public void get_web_code(View view) {   //按下按鈕
          new Thread(){  //用背景執行緒
              @Override
              public void run(){

                  try {
                      URL url=new URL("https://www.youtube.com/watch?v=pxuti_w8EuY&list=PLDwsR4fO8zMZMJMZ9PAYiiJwvMDlsDPc6&index=1"); //要抓取的對象
                      HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                      conn.connect();


                              BufferedReader reader=new BufferedReader(
                              new InputStreamReader(conn.getInputStream()));    //串流的方式抓取
                              String line;

                      while ((line=reader.readLine())!=null){   //每一行讀取出來
                          Log.v("data",""+line);
                      }

                      reader.close();
                  }
                  catch (IOException e) {

                      Log.v("data",""+e.toString());
                  }
              }

          }.start();



    }
}
