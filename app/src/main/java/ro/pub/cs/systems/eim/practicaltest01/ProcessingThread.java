package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Context;
import android.content.Intent;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {
    private int value1, value2;
    private Context context;
    private boolean isRunning = true;
    private Random random = new Random();

    public ProcessingThread(Context context, int value1, int value2) {
        this.context = context;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void run() {
        double am = (value1 + value2) / 2;
        double gm = Math.sqrt(value1 * value2);

        while (isRunning) {
            Intent intent = new Intent(Constants.intentActions[random.nextInt(Constants.intentActions.length)]);
            String message = new Date(System.currentTimeMillis()).toString() + am + " " + gm;
            intent.putExtra("message", message);
            context.sendBroadcast(intent);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
