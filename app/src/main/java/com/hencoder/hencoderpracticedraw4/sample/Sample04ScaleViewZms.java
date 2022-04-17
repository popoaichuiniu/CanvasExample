package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Sample04ScaleViewZms extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Sample04ScaleViewZms(Context context) {
        super(context);
    }

    public Sample04ScaleViewZms(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample04ScaleViewZms(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(point1.x, point1.y, 10, paint);
        canvas.save();
        canvas.rotate(4, point1.x, point1.y);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        canvas.drawCircle(point2.x, point2.y, 10, paint);
        // 坐标x*sx  坐标y*sy
        canvas.scale(0.5f, 0.5f, -point2.x, -point2.y);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    }
}
