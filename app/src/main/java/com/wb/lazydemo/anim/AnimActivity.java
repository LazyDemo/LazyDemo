package com.wb.lazydemo.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.wb.lazydemo.R;

public class AnimActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        doObject();
//        doValue();
        doSet(imageView);
    }


    private void initView() {
        imageView = (ImageView) this.findViewById(R.id.animTest);


    }

    private void doObject() {
        ObjectAnimator.ofFloat(imageView,"translationY",0f,500f)
                .setDuration(1500)
                .start();
    }

    private void doValue() {
        final ValueAnimator animator = ValueAnimator.ofFloat(0f,1f);
        animator.setTarget(imageView);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float current = (float) animation.getAnimatedValue();
//                Log.d("anim", "current value is " + current);
                imageView.setTranslationY(current*500);
            }
        });
        animator.start();
    }

    private void doSet(View view){
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", 500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);animSet.setDuration(5000);
        animSet.start();

    }

}
