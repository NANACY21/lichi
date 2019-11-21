package com.example.lichi;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**发短信
 */
public class Main2Activity extends AppCompatActivity {
    private EditText et_number, et_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);//关联

        et_number=findViewById(R.id.et_phoneNum);
        et_content=findViewById(R.id.et_content);
        /*
        主界面1携带数据跳转到该界面
         */
        Intent intent=this.getIntent();
        String sum = intent.getStringExtra("sum");
        System.out.println(sum+"cscsva");
        Toast.makeText(this,sum,Toast.LENGTH_LONG).show();
    }

    /**
     * 第三步，自动调用该方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2){
            String phoneNum = data.getStringExtra("phoneNum");
            /*
            点击加号后
            把phoneNum显示在文本框
             */
            et_number.setText(phoneNum);
        }
        else if(requestCode==3){
            String content = data.getStringExtra("content");
            /*
            点击加号后
            把phoneNum显示在文本框
             */
            et_content.setText(content);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    /*
    点击加号
     */
    public void add(View v){
        Intent intent=new Intent(this,ContactActivity.class);
        /*
        第一步
         */
        startActivityForResult(intent,2);
    }

    /**
     * 点击模板
     * @param v
     */
    public void template(View v){
        Intent intent=new Intent(this,TemplateActivity.class);
        /*
        第一步
         */
        startActivityForResult(intent,3);
    }
    //发短信应用的清单文件
    public void sendMessage(View v){
        SmsManager aDefault = SmsManager.getDefault();
        String s = et_number.getText().toString();
        String content = et_content.getText().toString();
        if(TextUtils.isEmpty(s)){
            Toast.makeText(this,"电话号码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(content)){
            Toast.makeText(this, "必须要有短信内容", Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayList<String> divideMessage = aDefault.divideMessage(content);
        //aDefault.sendTextMessage(null,null);
        for (String ss : divideMessage) {
            aDefault.sendTextMessage(s, null, s, null, null);
        }
    }
    public void open1(View v){
        Intent intent = new Intent(this,LaunchModeActivity.class);
        startActivity(intent);
    }
}
