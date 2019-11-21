package com.example.lichi;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**音乐播放器
 *
 * 播音乐是服务
 */
public class MusicPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    MyConn conn;
    IService binder;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        Button bt_play = (Button) findViewById(R.id.button1);
        Button bt_pause = (Button) findViewById(R.id.button2);
        Button bt_next = (Button) findViewById(R.id.button3);
        Button bt_last = (Button) findViewById(R.id.button4);
        bt_play.setOnClickListener(this);
        bt_pause.setOnClickListener(this);
        bt_next.setOnClickListener(this);
        bt_last.setOnClickListener(this);
        Intent intent = new Intent(this,MusicService.class);
        //混合开启服务：musicplay
        startService(intent);
        conn = new MyConn();
        bindService(intent, conn, BIND_AUTO_CREATE);//必要
        System.out.println(Thread.currentThread().getId());
    }

    private class MyConn implements ServiceConnection {

        public void onServiceConnected(ComponentName name, IBinder service) {
            binder=(IService)service;
        }

        public void onServiceDisconnected(ComponentName name) {
        }

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                binder.callPlay();
                break;
            case R.id.button2:
                binder.callPause();
                break;
            case R.id.button3:
                binder.callNextOne();
                break;
            case R.id.button4:
                binder.callLastOne();
                break;

        }

    }
    @Override
    protected void onDestroy() {
        //销毁时：unbindService和stopService写一起
        unbindService(conn);
        super.onDestroy();
        //stopService()
    }
}
//activity和其startService在同一线程 耗时的事在服务里做 要新开线程