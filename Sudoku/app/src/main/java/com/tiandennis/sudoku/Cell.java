package com.tiandennis.sudoku;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

class Cell extends RectF {
    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    String getSol() {
        return sol;
    }

    boolean isFixed() {
        return fixed;
    }

    void setConflict(boolean conflict) {
        this.conflict = conflict;
    }

    float getLeft() {
        return left;
    }

    float getTop() {
        return top;
    }

    int getGroup() {
        return group;
    }

    private String value, sol;
    private boolean fixed, conflict;
    private float left, top, size;
    private int group;

    Cell(float left, float top, float right, float bottom, float size, String value, boolean fixed, String sol, boolean conflict, int group) {
        super(left, top, right, bottom);
        this.left = left;
        this.top = top;
        this.size = size;
        this.value = value;
        this.fixed = fixed;
        this.sol = sol;
        this.conflict = conflict;
        this.group = group;
    }

    void draw(Canvas c, boolean won) {
        Paint p = new Paint();
        p.setColor(Color.WHITE);

        c.drawRect(this, p);
//        if(value.equals(sol))
        if (won) {     // lost
            p.setColor(Color.GREEN);
            fixed = true;
        } else if (conflict)
            p.setColor(Color.RED);
        else if (fixed)
            p.setColor(Color.GRAY);
        else
            p.setColor(Color.BLACK);
//        else
//            p.setColor(Color.RED);
        p.setStrokeWidth(20);
        p.setTextSize(80);
        c.drawText(value, left + size * 27 / 100f, bottom - size * 9 / 50f, p);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);
        p.setColor(Color.BLACK);
        c.drawRect(this, p);
    }

    boolean equals(Cell c) {
        return c.getLeft() == left && c.getTop() == top;
    }
}
