package com.example.dz;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
public class GameEngine extends SurfaceView implements Runnable {
    Thread mThread = null;
    private Renderer mRenderer;
    private int x, y;
    public GameEngine (Context context, Point size){
        super(context);
        mRenderer = new Renderer(this, context, size);
        Log.e("Обьект GameEngine ", "создан");
    }

    @Override
    public void run(){
        while (true){
            mRenderer.draw();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int i = event.getActionIndex();
        x = (int) event.getX(i);
        y = (int) event.getY(i);

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_UP:
                mRenderer.spawn(new Point(x, y));
                break;
        }
        return true;
    }
    public void stopThread(){
        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception ", "stopThread()" + e.getMessage());
        }
    }
    public void startThread() {
        mThread = new Thread(this);
        mThread.start();
    }
}
