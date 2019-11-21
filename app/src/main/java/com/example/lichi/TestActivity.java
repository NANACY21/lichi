package com.example.lichi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 安卓课实验考核
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void shiyan1(View v){
        TextView tv_show = findViewById(R.id.tv_show);

//        Toast.makeText(TestActivity.this,s,Toast.LENGTH_LONG).show();
        EditText et_shuru = findViewById(R.id.et_shuru);
        Intent intent=new Intent(this,shiyanFuzhuActivity.class);
        intent.putExtra("shuru",et_shuru.getText().toString());
        startActivity(intent);


    }
}
