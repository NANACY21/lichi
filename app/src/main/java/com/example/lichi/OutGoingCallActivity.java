package com.example.lichi;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**输入一个ip号码，保存。即保存号码偏好，下次还拨打这个号码
 */
public class OutGoingCallActivity extends AppCompatActivity {
    EditText et_ipnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outgoingcall);
        et_ipnumber=(EditText) findViewById(R.id.et_ipnumber);
        //打开ipsave.xml
        SharedPreferences ipsave = this.getSharedPreferences("ipsave", 0);
        String ipnumber = ipsave.getString("ipnumber", "");//取
        et_ipnumber.setText(ipnumber);//启动默认文本框上有内容
    }
    public void save(View v){
        String ipNumber=et_ipnumber.getText().toString();
        if(TextUtils.isEmpty(ipNumber)){
            Toast.makeText(getApplicationContext(), "先输入ip号码", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp=getSharedPreferences("ipsave", Context.MODE_PRIVATE);
        //往里存
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("ipnumber", ipNumber);
        edit.commit();
        Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
    }
}
