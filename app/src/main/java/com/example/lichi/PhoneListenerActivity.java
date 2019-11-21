package com.example.lichi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**监视接电话：服务：1.得到电话管理器 ->听 第一个参数：监听者
 * MIC：录自己说的
 * VOICE_CALL：双方
 * 录的音：mnt/sdcard/录音1.3gp
 */
public class PhoneListenerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_listener);
        startService(new Intent(this,PhoneService.class));
    }
}
