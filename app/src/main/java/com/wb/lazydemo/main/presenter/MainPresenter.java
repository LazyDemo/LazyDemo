package com.wb.lazydemo.main.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wb.lazydemo.R;
import com.wb.lazydemo.main.MainContract;

/**
 * Created by lazydemo on 2017/05/20 0020.
 * email: lazydemo@163.com
 */

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View mainView;

    public MainPresenter(@NonNull MainContract.View mainView) {
        this.mainView = mainView;
        mainView.setPresenter(this);
    }


    @Override
    public void doListener(View view, Context context) {
//        switch (view){
//            case R.id.:
////                Toast.makeText(context,String.valueOf(position),Toast.LENGTH_LONG).show();
//                Intent intent = new Intent();
//                intent.setAction("com.wb.lazydemo.LotteryActivity");
//                context.startActivity(intent);
//                break;
//        }
        if (view instanceof TextView){
            String text = ((TextView) view).getText().toString();
            if (text.equals(context.getResources().getString(R.string.lotteryTo))){
                Intent intent = new Intent();
                intent.setAction("com.wb.lazydemo.LotteryActivity");
                context.startActivity(intent);
            }else if (text.equals(context.getResources().getString(R.string.animTo))){
                Intent intent = new Intent();
                intent.setAction("com.wb.lazydemo.AnimActivity");
                context.startActivity(intent);
            }
        }
    }
}
