package com.example.lichi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

    private ListView lv_person;
    private List<Person> contacts;//人们
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        lv_person= findViewById(R.id.lv_person);
        contacts=new ArrayList<>();
        for(int i=0;i<4;i++){
            Person p=new Person("兆麟"+i+1,"男",19+i);
            contacts.add(p);
        }
        lv_person.setAdapter(new MyAdapter());
        /*
        点击条目
         */
        lv_person.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phoneNum = contacts.get(position).getName();
                System.out.println(phoneNum);
                Toast.makeText(PersonActivity.this,"你选择了"+phoneNum+"！",Toast.LENGTH_SHORT).show();
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
                view = View.inflate(PersonActivity.this, R.layout.personitem, null);
            }
            /*
            联系人列表向上划
             */
            else{
                view=convertView;
            }
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_sex = view.findViewById(R.id.tv_sex);
            TextView tv_age = view.findViewById(R.id.tv_age);
            tv_name.setText(contacts.get(position).getName());
            tv_sex.setText(contacts.get(position).getSex());
            tv_age.setText(contacts.get(position).getAge()+"");
            return view;
        }
    }
}
