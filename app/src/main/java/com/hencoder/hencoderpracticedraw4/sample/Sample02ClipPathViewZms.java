package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Sample02ClipPathViewZms extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 600);

    public Sample02ClipPathViewZms(Context context) {
        super(context);
    }

    public Sample02ClipPathViewZms(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample02ClipPathViewZms(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        Path path1 = new Path();
        path1.addCircle(point1.x + bitmap.getWidth()/2, point1.y + bitmap.getHeight()/2, 100, Path.Direction.CW);
        canvas.clipPath(path1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        Path path2 = new Path();
        path2.addCircle(point2.x + bitmap.getWidth()/2, point2.y + bitmap.getHeight()/2, 50, Path.Direction.CW);
        path2.addCircle(point2.x + bitmap.getWidth()/2, point2.y + bitmap.getHeight()/2 + 50, 50, Path.Direction.CW);
        path2.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(path2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
