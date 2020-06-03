package com.example.dz;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
public class Renderer {


    private Ball mBall;
    private Background mBackground;

    Renderer(GameEngine sh, Context context, Point size){

        mBall = new Ball(sh, context);
        mBackground = new Background(sh, context, size);
    }

    public void spawn(Point spawn){
        mBall.spawn(spawn);
    }

    public void draw(){
        mBackground.draw();
        mBall.move();
        mBall.draw();
    }
}
