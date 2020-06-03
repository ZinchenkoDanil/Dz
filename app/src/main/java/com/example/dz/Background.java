package com.example.dz;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
public class Background {
    private Point Size, Loc;
    private Bitmap mBitmap;
    private String name = "background";
    private Canvas mCanvas;
    private Paint mPaint;
    private SurfaceHolder mSurfaceHolder;

    Background(SurfaceView sh, Context context, Point size){
        Size = size;
        Loc = new Point(0, 0);
        mSurfaceHolder = sh.getHolder();
        mPaint = new Paint();

        int resID = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        mBitmap = BitmapFactory.decodeResource(context.getResources(), resID);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, Size.x, Size.y, false);
    }

    void draw(){
        if( mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawBitmap(mBitmap, Loc.x, Loc.y,mPaint);
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }
}
