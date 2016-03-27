package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Service extends Service {

    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Context context = getApplicationContext();
        int value1 = intent.getIntExtra("value1", 0);
        int value2 = intent.getIntExtra("value2", 0);
        processingThread = new ProcessingThread(context, value1, value2);

        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        processingThread.stopThread();
        super.onDestroy();
    }
}
