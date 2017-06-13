package com.wb.lazydemo.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.PendingIntent;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
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
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", 500f, 100f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).with(moveIn);animSet.setDuration(2000);

        //default interpolator
//        animSet.setInterpolator(new AccelerateInterpolator()); //加速
//        animSet.setInterpolator(new AccelerateDecelerateInterpolator());//中间快
//        animSet.setInterpolator(new AnticipateOvershootInterpolator());//前后甩
//        animSet.setInterpolator(new AnticipateInterpolator());//前甩
//        animSet.setInterpolator(new BounceInterpolator());//弹动
//        animSet.setInterpolator(new CycleInterpolator(this,));
//        animSet.setInterpolator(new DecelerateInterpolator());//减速
//        animSet.setInterpolator(new LinearInterpolator());//线性
//        animSet.setInterpolator(new LinearOutSlowInInterpolator());
//        animSet.setInterpolator(new OvershootInterpolator());//后甩

        animSet.start();
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }

}
