package com.tiandennis.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

class DrawView extends View {
    Cell[] Cells = new Cell[81];

    public DrawView(Context context) {
        super(context);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                Cells[i * 9 + j] = new Cell(i * 100, j * 100, (i + 1) * 100, (j + 1) * 100);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int a = getWidth();
//        c1.left = a / 2f - 50;
//        c1.top = a / 2f - 50;
//        c1.right = a / 2f + 50;
//        c1.bottom = a / 2f + 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Cell c:Cells)
            c.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            for(Cell c:Cells)
                if(c.contains(event.getX(), event.getY()))
                    c.setValue("8");
//        System.out.println("Test: " + c1.getValue());
        invalidate();
        return true;
    }
}
