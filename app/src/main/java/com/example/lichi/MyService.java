package com.example.lichi;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**这是一个自定义的服务
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("in onBind");
        return new MyBinder();
    }
    @Override
    public void onCreate() {
        System.out.println("in onCreate");
        super.onCreate();
    }
    @Override
    public void onDestroy() {
        System.out.println("in onDestroy");
        super.onDestroy();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("in start");
        return super.onStartCommand(intent, flags, startId);
    }
    public void play(){}
    public void pause(){}
    public void nextOne(){
    }
    public void add(){}
    public void sub(){}
    public void testMethod(){
        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
    }
    public class MyBinder extends Binder implements IService{
        public void callTestMethod(){
            testMethod();
        }
        @Override
        public void callPlay() {

        }
        @Override
        public void callPause() {

        }
        @Override
        public void callNextOne() {

        }
        @Override
        public void callLastOne() {

        }
        public void callAdd(){
            add();
        }
        public void callSub(){
            sub();
        }
    }
}
