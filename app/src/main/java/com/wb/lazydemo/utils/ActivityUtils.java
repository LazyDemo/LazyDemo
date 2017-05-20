package com.wb.lazydemo.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by lazydemo on 2017/05/20 0020.
 * email: lazydemo@163.com
 */

public class ActivityUtils {

    public static void addFragmentToActivity(@NonNull FragmentManager manager, @NonNull Fragment fragment,int frameId){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(frameId,fragment);
        transaction.commit();
    }

}
