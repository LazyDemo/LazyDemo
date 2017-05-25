package com.wb.lazydemo.lottery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wb.lazydemo.R;


public class LotteryActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView lotteryStart;
    private LotteryView lotteryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);
        initview();
    }

    private void initview() {
        lotteryStart = (ImageView) this.findViewById(R.id.lotteryStart);
        lotteryStart.setOnClickListener(this);
        lotteryView = (LotteryView) this.findViewById(R.id.lotteryView);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lotteryStart:
                if (!lotteryView.isStart()){
                    lotteryStart.setImageResource(R.mipmap.stop);
                    lotteryView.start(1);
                }else{
                    if (!lotteryView.isShouldEnd()){
                        lotteryStart.setImageResource(R.mipmap.start);
                        lotteryView.end();
                    }
                }
                break;
        }
    }
}
