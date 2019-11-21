package com.example.lichi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 本APP主界面
 */
public class MainActivity extends AppCompatActivity {
    Button btn;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    TextView tv;

    /**
     * 初始化
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate()运行");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//绑定布局
        Toast.makeText(MainActivity.this, "lichi |--| 主界面", Toast.LENGTH_LONG).show();
        btn = findViewById(R.id.bt_confirm);
        cb1 = findViewById(R.id.sport);
        cb2 = findViewById(R.id.study);
        cb3 = findViewById(R.id.read);
        cb4 = findViewById(R.id.swim);
        tv = findViewById(R.id.show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "我爱";
                if (cb1.isChecked()) {
                    Toast.makeText(MainActivity.this, "运动", Toast.LENGTH_LONG).show();
                    result = result + "运动";
                    tv.setText(result);
                }
                if (cb2.isChecked()) {
                    Toast.makeText(MainActivity.this, "学习", Toast.LENGTH_LONG).show();
                    result = result + "学习";
                    tv.setText(result);
                }
                if (cb3.isChecked()) {
                    Toast.makeText(MainActivity.this, "看书", Toast.LENGTH_LONG).show();
                    result = result + "看书";
                    tv.setText(result);
                }
                if (cb4.isChecked()) {
                    Toast.makeText(MainActivity.this, "游泳", Toast.LENGTH_LONG).show();
                    result = result + "游泳";
                    tv.setText(result);
                }
            }
        });
    }

//    Log.d("c","dddd");//在logcat输入c

    /**
     * 关掉时
     */
    @Override
    protected void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        System.out.println("onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        System.out.println("onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        System.out.println("可操作了");
        super.onResume();
    }

    /**
     * 界面失去焦点时执行
     */
    @Override
    protected void onPause() {
        System.out.println("onPause");
        super.onPause();
    }


    /**
     * @param v
     */
    public void sum(View v) {
        //跳转
        EditText Num1 = findViewById(R.id.et_Num1);
        EditText Num2 = findViewById(R.id.et_Num2);
        int num1 = Integer.parseInt(Num1.getText().toString());
        int num2 = Integer.parseInt(Num2.getText().toString());
        Intent intent = new Intent(this, Main2Activity.class);//意图
        int sum = num1 + num2;
        intent.putExtra("sum", sum + "");
        startActivity(intent);
    }

    /**
     * 弹出对话框
     *
     * @param v
     */
    public void click2(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("确认");
        builder.setMessage("这是一个简单消息框");
        builder.setPositiveButton("是", null);
        builder.show();
        //Intent intent=new Intent(this,Main3Activity.class);
        //startActivity(intent);
    }

    public void openShiyan(View v) {
//        Intent intent=new Intent(this,PersonActivity.class);
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    /**
     * 打开音乐播放器
     *
     * @param v
     */
    public void MusicPlayer(View v) {
        Intent intent = new Intent(this, MusicPlayerActivity.class);
        startActivity(intent);
    }


}
