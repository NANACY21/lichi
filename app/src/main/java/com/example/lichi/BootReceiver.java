package com.example.lichi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**手机启动广播的广播接收者，接收到手机启动广播时启动PhoneService这个服务
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context,PhoneService.class));
    }
}
