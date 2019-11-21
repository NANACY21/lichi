package com.example.lichi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lichi.util.IOUtil;

/**有关java文件io的
 */
public class FilestoreActivity extends AppCompatActivity {
    private EditText et_filename;
    private EditText et_content;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestore);
        et_filename = (EditText) findViewById(R.id.et_filename);
        et_content = (EditText) findViewById(R.id.et_content);
    }
    public void save(View v){
        String name = et_filename.getText().toString().trim();
        String content = et_content.getText().toString().trim();
        if(TextUtils.isEmpty(name)|| TextUtils.isEmpty(content)){
            Toast.makeText(this, "文件名或文件内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //io
//    	IOUtil.write(name, content);
        IOUtil.write1(this,name, content);

//    	Context.M
    }
}
