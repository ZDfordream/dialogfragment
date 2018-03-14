package com.zhudong.easydialogfragment.dragDialog;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
/**
 * Created by zhudong on 2017/10/7.
 */
public class DragAwayDialogFragment extends DialogFragment {

    private boolean mDragable = true;
    private boolean mTiltEnabled = true;
    private boolean mSwipeLayoutGenerated = false;
    private DragDismissTouchListener mListener = null;

    public void setDragable(boolean swipeable) {
        mDragable = swipeable;
    }

    public boolean isDragable() {
        return mDragable;
    }

    public boolean onDragedAway(boolean toTop) {
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!mSwipeLayoutGenerated && getShowsDialog()) {
            Window window = getDialog().getWindow();
            ViewGroup decorView = (ViewGroup)window.getDecorView();
            View content = decorView.getChildAt(0);
            decorView.removeView(content);

            DragableFrameLayout layout = new DragableFrameLayout(getActivity());
            layout.addView(content);
            decorView.addView(layout);

            mListener = new DragDismissTouchListener(decorView, "layout", new DragDismissTouchListener.DismissCallbacks() {
                @Override
                public boolean canDismiss(Object token) {
                    return isCancelable() && mDragable;
                }

                @Override
                public void onDismiss(View view, boolean toTop, Object token) {
                    if (!onDragedAway(toTop)) {
                        dismiss();
                    }
                }
            });
            mListener.setTiltEnabled(mTiltEnabled);
            layout.setDragDismissTouchListener(mListener);
            layout.setOnTouchListener(mListener);
            layout.setClickable(true);
            mSwipeLayoutGenerated = true;
        }
    }

}
