package com.example.dz;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.SurfaceHolder;

public class Ball  {
    private static Point Location;
    private Paint mPaint;
    private Canvas mCanvas;
    private SurfaceHolder mSurfaceHolder;
    private Bitmap mBitmap;
    private Point Speed;
    private Point Size;
    private String name = "ball_2";

    Ball(GameEngine sh, Context context){
        Log.e("Обьект ball ", "создан");
        mSurfaceHolder = sh.getHolder();
        mPaint = new Paint();
        Size = new Point(100, 100);
        Speed = new Point(4, 0);
        Location = new Point(-1000, -1000);

        int resID = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        mBitmap = BitmapFactory.decodeResource(context.getResources(), resID);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, Size.x, Size.y, false);

    }

    static void spawn(Point spawn){
        Location=spawn;
    }

    void move(){
        Location.x += Speed.x;
        Location.y += Speed.y;
    }

    void draw(){
        if( mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawBitmap(mBitmap, Location.x, Location.y, mPaint);
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }

}
