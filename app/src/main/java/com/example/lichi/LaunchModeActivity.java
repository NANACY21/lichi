package com.example.lichi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/*

 */
public class LaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
    }
    public void open1(View v) {
        Intent intent = new Intent(this,LaunchModeActivity.class);
        startActivity(intent);
    }
    public void open2(View v){
        //显式意图 用于激活本app的界面
        //Intent intent = new Intent(this,OtherActivity.class);
        //startActivity(intent);

        //隐式意图 没有说明要激活哪个组件 用于激活其它app的界面
        Intent intent1=new Intent();
        intent1.addCategory(Intent.CATEGORY_DEFAULT);
        intent1.setAction("aa.bb.cc.dd");
        //intent1.setData(Uri.parse("tel:"+"abc"));//使setType无效
        //intent1.setType();//使setData无效
        intent1.setDataAndType(Uri.parse("tel:"+"abc"),"text/plain");
        startActivity(intent1);

    }
}
