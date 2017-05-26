package com.wb.lazydemo.main;

import android.content.Context;
import android.view.View;

import com.wb.lazydemo.BasePresenter;
import com.wb.lazydemo.BaseView;

/**
 * Created by lazydemo on 2017/05/19 0019.
 * email: lazydemo@163.com
 */

public interface MainContract {
    interface View extends BaseView<Presenter>{


    }
    interface Presenter extends BasePresenter{
        public void doListener(android.view.View view, Context context);
    }
}
