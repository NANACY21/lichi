package com.example.lichi;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**绑定服务的界面，在该界面绑定服务
 */
public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener {
    ServiceConnection conn;
    private IService binder;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button) findViewById(R.id.stop);
        Button play = (Button) findViewById(R.id.play);
        Button pause = (Button) findViewById(R.id.pause);
        Button nextOne = (Button) findViewById(R.id.nextOne);
        Button lastOne = (Button) findViewById(R.id.lastOne);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        nextOne.setOnClickListener(this);
        lastOne.setOnClickListener(this);
    }

    /**
     * 绑定服务
     * @param v
     */
    public void click1(View v) {
        Intent intent = new Intent(this, MyService.class);
        conn = new MyConn();
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    private class MyConn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (IService) service;
            // binder.callTestMethod();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    /**
     * 取消绑定服务
     * @param v
     */
    public void click2(View v) {
        if(conn!=null)
            unbindService(conn);
//		binder.callTestMethod();
        // binder.callAdd();
        // binder.callSub();
    }

    @Override
    protected void onDestroy() {
//		if (conn != null)
//			unbindService(conn);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                Intent intent = new Intent(this,MyService.class);
                startService(intent);
                break;
            case R.id.stop:
                Intent intent1 = new Intent(this,MyService.class);
                stopService(intent1);
                break;
            case R.id.play:
                break;
            case R.id.pause:
                break;
            case R.id.nextOne:
                break;
            case R.id.lastOne:
                break;
        }
    }
}