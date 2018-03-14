package com.zhudong.dialogfragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhudong.easydialogfragment.dragDialog.DragAwayDialogFragment;


/**
 * Created by zhudong on 2017/10/7.
 */

public class ShowDialogFragment extends DragAwayDialogFragment {
    private Context mContext;
    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_cancle;
    private TextView tv_sure;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.dialog_cancle_save, null);
        Dialog loadingDialog = new Dialog(getActivity(), R.style.loading_dialog);
        loadingDialog.setCancelable(true);
        loadingDialog.setContentView(v);// 设置布局
        loadingDialog.getWindow().setGravity(Gravity.LEFT | Gravity.BOTTOM);
        init(v);
        return loadingDialog;
    }


    private void init(View v) {
        tv_title = v.findViewById(R.id.tv_title);
        tv_content = v.findViewById(R.id.tv_content);
        tv_cancle = v.findViewById(R.id.tv_cancle);
        tv_sure = v.findViewById(R.id.tv_sure);
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"cancle",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"sure",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
