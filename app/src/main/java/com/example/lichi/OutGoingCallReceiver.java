package com.example.lichi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**广播接收者
 * 修改清单文件：意图过滤器以说明收听的频道（订阅）...
 * 加权限
 *
 * 一个activivty可以发广播（父类的方法以发广播），设置发送频道
 * 广播接收者 （一个类），（设置清单文件，绑定该类，  接收的频道）
 */
public class OutGoingCallReceiver extends BroadcastReceiver {
    /**收听完要做什么
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("xscavdvsd");
        //系统发广播 广播 -- 意图对象
        String resultData = getResultData();//电话号码
        System.out.println(resultData);
        SharedPreferences ipsave = context.getSharedPreferences("ipsave", 0);
        String ipnumber = ipsave.getString("ipnumber", "");
        if(resultData.startsWith("0")){
            setResultData(ipnumber+resultData);
        }
    }
}
