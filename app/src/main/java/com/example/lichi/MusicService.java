package com.example.lichi;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;

/**音乐播放器的服务
 */
public class MusicService extends Service {
    @Override
    public void onCreate() {
        initMedia();
        super.onCreate();
    }
    @Override
    public IBinder onBind(Intent arg0) {
        return new MyBinder();
    }
    public void play(){
        System.out.println(Thread.currentThread().getId());
        System.out.println("开始播放");
        SystemClock.sleep(1000*20);
    }
    public void pause(){
        System.out.println("暂停播放");
    }
    public void nextOne(){
        System.out.println("下一首");
    }
    public void lastOne(){
        System.out.println("上一首");
    }
    public void initMedia(){
        System.out.println("初始化");
    }
    public void finaliz(){
        System.out.println("收尾工作");
    }

    private class MyBinder extends Binder implements IService{
        @Override
        public void callTestMethod() {

        }

        public void callPlay(){
            play();
        }
        public void callPause(){
            pause();
        }
        public void callNextOne(){
            nextOne();
        }
        public void callLastOne(){
            lastOne();
        }
        public void callFinallize(){
            finaliz();
        }
    }
}
