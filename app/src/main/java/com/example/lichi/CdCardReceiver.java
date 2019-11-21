package com.example.lichi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**监听cd卡的插入拔出
 * 一旦定义系统的广播的接收者，特点：自动启动，app可以不打开，
 * cd卡卸载-》系统发送广播-》只有定义了广播接收者（类）以收听广播-》做处理
 * 拨电话要加权限
 *
 * 黑客：短信发送的广播接收者，
 * 自定义广播->点按钮以发广播，这要需要指定频道
 */
public class CdCardReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
            System.out.println("sd卡已卸载");
        }
        else if("android.intent.action.MEDIA_MOUNTED".equals(action)){
            System.out.println("sd卡已安装");
        }
    }
}
