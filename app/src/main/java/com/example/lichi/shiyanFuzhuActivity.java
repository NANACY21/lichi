package com.example.lichi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class shiyanFuzhuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiyan_fuzhu);

        Intent intent=this.getIntent();
        String sum = intent.getStringExtra("shuru");
        TextView viewById = findViewById(R.id.tv_show);
        viewById.setText(sum);

    }
}
