package com.wb.lazydemo.main;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.wb.lazydemo.R;
import com.wb.lazydemo.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lazydemo on 2017/05/20 0020.
 * email: lazydemo@163.com
 */

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener{
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null){
            mainFragment = MainFragment.newInstance("","");
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),mainFragment,R.id.contentFrame);
        }
        //create the presenter
        presenter = new MainPresenter(mainFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
