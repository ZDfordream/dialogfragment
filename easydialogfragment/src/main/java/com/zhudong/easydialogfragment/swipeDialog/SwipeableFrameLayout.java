package com.zhudong.easydialogfragment.swipeDialog;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/**
 * Created by zhudong on 2017/10/7.
 */
public class SwipeableFrameLayout extends FrameLayout {

    private SwipeDismissTouchListener mTouchListener;

    public SwipeableFrameLayout(Context context) {
        super(context);
    }

    public void setSwipeDismissTouchListener(SwipeDismissTouchListener touchListener) {
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
