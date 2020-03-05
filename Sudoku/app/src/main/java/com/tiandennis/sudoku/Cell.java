package com.tiandennis.sudoku;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

class Cell extends RectF {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    private String value;
    private boolean clicked;
    Cell(float left, float top, float right, float bottom){
        super(left, top, right, bottom);
        value="9";
        clicked=false;
    }
    void draw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.RED);

        c.drawRect(this, p);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(20);
        p.setTextSize(100);
        c.drawText(value,left, bottom,p);
    }
}
