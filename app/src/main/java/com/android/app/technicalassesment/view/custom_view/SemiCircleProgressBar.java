package com.android.app.technicalassesment.view.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.android.app.technicalassesment.R;

public class SemiCircleProgressBar extends View {

    private int progress =0;
    private int stockWidth =60;
    private int radius =120;
    private int bgColor =-1;
    private int progressColor =-1;
    private int maxProgress =100;
    private static final float START_ANGLE=178;
    private static final float SWEEP_ANGLE=184;

    public SemiCircleProgressBar(Context context) {
        super(context);
        radius = (getWidth()/2)-10;
    }
    public SemiCircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SemiCircleProgress, 0, 0);
        progress = Math.max(a.getInteger(R.styleable.SemiCircleProgress_progress, 0), 0);
        maxProgress = Math.max(a.getInteger(R.styleable.SemiCircleProgress_max, maxProgress), 0);
        radius =a.getInteger(R.styleable.SemiCircleProgress_sc_radius, radius);
        stockWidth =a.getInteger(R.styleable.SemiCircleProgress_stroke_width, stockWidth);
        bgColor =a.getColor(R.styleable.SemiCircleProgress_bg_color,bgColor);
        progressColor =a.getColor(R.styleable.SemiCircleProgress_progress_color, progressColor);
        a.recycle();
    }
    public SemiCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SemiCircleProgress, 0, 0);
        progress = Math.max(a.getInteger(R.styleable.SemiCircleProgress_progress, 0), 0);
        maxProgress = Math.max(a.getInteger(R.styleable.SemiCircleProgress_max, maxProgress), 0);
        radius =a.getInteger(R.styleable.SemiCircleProgress_sc_radius, radius);
        stockWidth =a.getInteger(R.styleable.SemiCircleProgress_stroke_width, stockWidth);
        bgColor =a.getColor(R.styleable.SemiCircleProgress_bg_color, bgColor);
        progressColor =a.getColor(R.styleable.SemiCircleProgress_progress_color, progressColor);
        a.recycle();
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if(progress >100){
            progress =100;
        }
        float angle = (progress * SWEEP_ANGLE) / 100;
        Paint p1 = new Paint();
        final RectF rectF = new RectF();
        int half_width = getWidth() / 2;

        int StockWidth = half_width/3;
        int Radius = half_width - StockWidth - 10;

        int left = half_width - Radius;
        int half_height = getHeight() / 2;
        int top = half_height - Radius;
        int right = half_width + Radius;
        int bottom = half_height + Radius;

        rectF.set(left, top, right, bottom);
        if(bgColor ==-1){
            p1.setColor(Color.WHITE);
        }else{
            p1.setColor(bgColor);
        }

        p1.setStrokeWidth(StockWidth);
        p1.setAntiAlias(true);
        p1.setStrokeCap(Paint.Cap.BUTT);
        p1.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, START_ANGLE,SWEEP_ANGLE, false, p1);

        Paint p2 = new Paint();
        if(progressColor ==-1){
            p2.setColor(Color.RED);
        }else{
            p2.setColor(progressColor);
        }
        p2.setStrokeWidth(StockWidth);
        p2.setAntiAlias(true);
        p2.setStrokeCap(Paint.Cap.BUTT);
        p2.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, START_ANGLE, angle, false, p2);

    }
    public  void setProgress(int progress){
        this.progress =progress;
        invalidate();
    }

    public void setBgColor(int color){
        this.bgColor =color;
        invalidate();
    }

    public void setProgressColor(int color){
        this.progressColor =color;
        invalidate();
    }
    public int getProgress(){
        return progress;
    }

    public void updateGraph(int bgColor,int progressColor,int progress){
        this.bgColor =bgColor;
        this.progressColor =progressColor;
        this.progress =progress;
        invalidate();
    }
}
