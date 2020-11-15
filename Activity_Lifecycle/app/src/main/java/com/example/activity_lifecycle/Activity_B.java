package com.example.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_B extends AppCompatActivity {
    private static final String ACTIVITY_TAG="Activity_B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用來做程式的初使化動作
        setContentView(R.layout.activity_b);
        Log.i(Activity_B.ACTIVITY_TAG, "onCreate()");

        Button btn_to_a = findViewById(R.id.button_To_A);
        btn_to_a.setOnClickListener(btn_to_a_Listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //當Activity變得可見時調用該函數
        Log.i(Activity_B.ACTIVITY_TAG, "onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //把保存的資料拿回來使用
        Log.i(Activity_B.ACTIVITY_TAG, "onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        //時把需要保存的資料保存
        Log.i(Activity_B.ACTIVITY_TAG, "onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Activity變得不可見時調用該方法
        Log.i(Activity_B.ACTIVITY_TAG, "onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //通常都拿來把onCreate()時的資料做釋放的動作
        Log.i(Activity_B.ACTIVITY_TAG, "onDestroy()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        //再次啟動之前將會調用該方法
        Log.i(Activity_B.ACTIVITY_TAG, "onRestart()");
    }

    private Button.OnClickListener btn_to_a_Listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(Activity_B.this , MainActivity.class);

            startActivity(intent);
            Activity_B.this.finish();
        }
    };
}