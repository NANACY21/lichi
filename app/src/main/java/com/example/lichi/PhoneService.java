package com.example.lichi;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

/**一开机就开启了这个服务
 */
public class PhoneService extends Service {
    public PhoneService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        // 准备监听电话
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//		inflater.inflate(resource, root)
//		View.inflate(context, resource, root)
        tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
        super.onCreate();
    }
    private class MyListener extends PhoneStateListener {
        private MediaRecorder recorder;

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE://空闲
                    System.out.println("空闲状态");
                    if(recorder!=null){
                        recorder.stop();
                        recorder.reset();   // You can reuse the object by going back to setAudioSource() step
                        recorder.release(); // Now the object cannot be reused
                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK://接听
                    System.out.println("接听状态");
                    recorder.start();
                    //开始录
                    break;
                case TelephonyManager.CALL_STATE_RINGING://响铃状态
                    System.out.println("响铃状态");
                    //准备开录
                    recorder = new MediaRecorder();
                    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    recorder.setOutputFile("/mnt/sdcard/myaudio.3gp");
                    try {
                        recorder.prepare();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    }
}
