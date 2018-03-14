package com.zhudong.easydialogfragment.dragDialog;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/**
 * Created by zhudong on 2017/10/7.
 */
public class DragableFrameLayout extends FrameLayout {

    private DragDismissTouchListener mTouchListener;

    public DragableFrameLayout(Context context) {
        super(context);
    }

    public void setDragDismissTouchListener(DragDismissTouchListener touchListener) {
        mTouchListener = touchListener;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mTouchListener != null) {
            if (mTouchListener.onTouch(this, ev)) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

}
