package com.example.lichi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AdapterView.*;
import android.widget.TextView;

public class TemplateActivity extends AppCompatActivity {
    private String[] ss;

    public TemplateActivity() {
        ss = new String[]{"我正在开车","我正在开会","我在忙","晚点联系"};
    }

    /**
     * 启动该界面马上执行该方法
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        /*
        很重要的组件
         */
        ListView lv_template=(ListView) findViewById(R.id.lv_template);
        /*
        数组适配器（适用每一行仅一条数据）
         */
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.templateitem,ss);
        /*
        Base适配器（适用每一行数据有一些项）
         */
        lv_template.setAdapter(new MyAdapter());
//        lv_template.setAdapter(adapter);
//        CursorAdapter 数据库读取
        lv_template.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content=ss[position];
                Intent intent=new Intent();
                intent.putExtra("content",content);
                setResult(10,intent);
                finish();
            }
        });
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return ss.length;
        }

        @Override
        public Object getItem(int position) {
            return ss[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * 该方法固定的格式
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView==null){
                view=View.inflate(TemplateActivity.this,R.layout.templateitem,null);
            }
            else{
                view=convertView;
            }
            TextView tv_sms_temp=(TextView) view.findViewById(R.id.tv_sms_temp);
            tv_sms_temp.setText(ss[position]);
            return view;
        }
    }
}
