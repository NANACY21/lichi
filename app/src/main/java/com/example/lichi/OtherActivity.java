package com.example.lichi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }
    public void open1(View v){
        Intent intent = new Intent(this,LaunchModeActivity.class);
        startActivity(intent);
    }
    public void open2(View v){
        Intent intent = new Intent(this,OtherActivity.class);
        startActivity(intent);
    }
}
