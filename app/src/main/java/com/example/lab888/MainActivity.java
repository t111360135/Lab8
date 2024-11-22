package com.example.lab888;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //初始化 Activity
        setContentView(R.layout.activity_main); //連接 activity_main.xml 畫面

        Button button = findViewById(R.id.button); //連接 Button 元件
        button.setOnClickListener(new View.OnClickListener() { //Button 點擊事件

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent); //啟動 Service
                Toast.makeText(MainActivity.this, "啟動Service", Toast.LENGTH_LONG).show();
                finish(); //關閉 Activity

            }
        });
    }
}