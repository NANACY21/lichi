package com.example.lichi;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lichi.util.DBUtils;
import com.example.lichi.util.MySqliteHelper;

import java.util.ArrayList;
import java.util.List;

/**有关Sqlite的
 */
public class SqliteActivity extends AppCompatActivity {
    MySqliteHelper helper;
    private EditText et_name;
    private EditText et_sex;
    private EditText et_age;
    List<Person> list;
    int id=0;
    private ListView lv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        helper = new MySqliteHelper(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_sex = (EditText) findViewById(R.id.et_sex);
        et_age = (EditText) findViewById(R.id.et_age);
        list  = new ArrayList<Person>();
        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id11) {
                Person person = list.get(position);
                et_name.setText(person.getName());
                et_sex.setText(person.getSex());
                et_age.setText(person.getAge());
                id=person.getId();
//				Toast.makeText(SqliteActivity.this, id+"", 0).show();
            }

        });

    }
    public void createTable(View v) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.close();
    }
    public void add(View v) {
        String name = et_name.getText().toString();
        String sex = et_sex.getText().toString();
        int age = Integer.parseInt(et_age.getText().toString());
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(sex)){
            Toast.makeText(this, "姓名或性别不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Person person = new Person(name, sex,age);
        DBUtils.add(helper, person);
        find();
    }
    public void delete(View v) {
        if(id==0){
            Toast.makeText(this, "先选择您要删除的条目", Toast.LENGTH_SHORT).show();
            return;
        }

        //personid从listview来

        DBUtils.delete(helper, id);
        find();
    }
    public void update(View v) {
        if(id==0){
            Toast.makeText(this, "先选择您要修改的条目", Toast.LENGTH_SHORT).show();
            return;
        }
        String name = et_name.getText().toString();
        String sex = et_sex.getText().toString();
        int age = Integer.parseInt(et_age.getText().toString());
        Person person = new Person(id,name, sex,age);
        DBUtils.update(helper, person);
        find();
    }
    public void query(View v) {
        find();

    }
    private class MyAdapter extends BaseAdapter {
        public int getCount() {
            return list.size();
        }
        public Object getItem(int position) {
            return list.get(position);
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View v;
            if(convertView==null){
                v = View.inflate(SqliteActivity.this, R.layout.item, null);
            }
            else{
                v=convertView;
            }
            TextView tv_name = (TextView) v.findViewById(R.id.tv_name);
            TextView tv_sex = (TextView) v.findViewById(R.id.tv_sex);
            TextView tv_age = (TextView) v.findViewById(R.id.tv_age);
            tv_name.setText(list.get(position).getName());
            tv_sex.setText(list.get(position).getSex());
            tv_age.setText(list.get(position).getAge());
            return v;
        }
    }
    public void find(){
        List<Person> persons = DBUtils.query(helper);
        list=persons;
        lv.setAdapter(new MyAdapter());
    }
}
