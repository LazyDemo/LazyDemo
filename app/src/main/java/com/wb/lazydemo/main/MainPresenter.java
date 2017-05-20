package com.wb.lazydemo.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

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
    public void doListener(int position, Context context) {
        switch (position){
            case 0:
                Toast.makeText(context,String.valueOf(position),Toast.LENGTH_LONG).show();
                break;
        }
    }
}
