package com.example.drawablevalueaniamtion;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button imageStart, imageStop, changeRed, changeBlue, changeGreen;
    TextView showTextViewAnimation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTextViewAnimation = findViewById(R.id.showTextView);
        imageView = findViewById(R.id.showImageView);

        imageStart = findViewById(R.id.imageStartButton);
        imageStop = findViewById(R.id.imageStopButton);

        changeRed = findViewById(R.id.changeRedButton);
        changeBlue = findViewById(R.id.changeBlueButton);
        changeGreen = findViewById(R.id.changeGreenButton);

        Resources res = getResources();
//        AnimationDrawable  animDrawable = (AnimationDrawable) res.getDrawable(R.drawable.image_list);
        AnimationDrawable animDrawable = new AnimationDrawable();
        animDrawable.setOneShot(true);

        animDrawable.addFrame(res.getDrawable(R.drawable.item01), 500);
        animDrawable.addFrame(res.getDrawable(R.drawable.item02), 500);
        animDrawable.addFrame(res.getDrawable(R.drawable.item03), 500);
        animDrawable.addFrame(res.getDrawable(R.drawable.item04), 500);
        animDrawable.addFrame(res.getDrawable(R.drawable.item05), 500);

        imageView.setImageDrawable(animDrawable);


        imageStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animDrawable.start();
            }
        });

        imageStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animDrawable.stop();
            }
        });

        changeRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator colorAnim = ObjectAnimator.ofInt(showTextViewAnimation, "textColor",
                        Color.BLACK, Color.RED);
                colorAnim.setDuration(600);
                colorAnim.setEvaluator(new android.animation.ArgbEvaluator());
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();
            }
        });

        changeBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator colorAnim = ObjectAnimator.ofInt(showTextViewAnimation, "textColor",
                        Color.BLACK, Color.BLUE);
                colorAnim.setDuration(600);
                colorAnim.setEvaluator(new android.animation.ArgbEvaluator());
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();
            }
        });

        changeGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator colorAnim = ObjectAnimator.ofInt(showTextViewAnimation, "textColor",
                        Color.BLACK, Color.GREEN);
                colorAnim.setDuration(600);
                colorAnim.setEvaluator(new android.animation.ArgbEvaluator());
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();
            }
        });



    }
}