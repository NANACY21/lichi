package com.example.lichi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private ListView lv_contact;
    private List<Contact> contacts;//联系人们
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        lv_contact= findViewById(R.id.lv_contact);
        contacts=new ArrayList<>();
        for(int i=0;i<20;i++){
            Contact contact=new Contact();
            contact.setName("张"+i);
            contact.setPhoneNum("131496"+i);
            contacts.add(contact);
        }
        lv_contact.setAdapter(new MyAdapter());
        /*
        点击条目
         */
        lv_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phoneNum = contacts.get(position).getPhoneNum();
                /*
                第二步
                把这个电话号码发回文本框
                 */
                Intent intent=new Intent();
                intent.putExtra("phoneNum",phoneNum);
                setResult(1,intent);
                /*
                关掉当前界面
                 */
                finish();
            }
        });


    }

    private class MyAdapter extends BaseAdapter{

        /**
         * 得到contacts的长度
         * @return
         */
        @Override
        public int getCount() {
            return contacts.size();
        }

        @Override
        public Object getItem(int position) {
            return contacts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        /**
         *
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
            联系人的一行
             */
            View view;
            if(convertView==null){
                view = View.inflate(ContactActivity.this, R.layout.contactitem, null);
            }
            /*
            联系人列表向上划
             */
            else{
                view=convertView;
            }
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_phoneNum = view.findViewById(R.id.tv_phoneNum);
            tv_name.setText(contacts.get(position).getName());
            tv_phoneNum.setText(contacts.get(position).getPhoneNum());
            return view;
        }
    }
}
