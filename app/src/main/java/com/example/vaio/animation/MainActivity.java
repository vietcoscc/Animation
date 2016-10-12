package com.example.vaio.animation;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ImageView imgvFirstCard;
    private ImageView imgvSecondCard;
    private ImageView imgvThirstCard;
    private TextView txtvWaveOne;
    private TextView txtvWaveTwo;
    private TextView txtvWaveThree;
    private TextView txtvCountDown;

    private AnimationSet animSetWaveOneTxt;
    private AnimationSet animSetWaveOneThirstCard;
    private AnimationSet animSetWaveOneSecondCard;
    private AnimationSet animSetWaveOneFisrtCard;

    private AnimationSet animSetWaveTwoTxt;
    private AnimationSet animSetWaveTwoThirstCard;
    private AnimationSet animSetWaveTwoSecondCard;
    private AnimationSet animSetWaveTwoFisrtCard;

    private AnimationSet animSetWaveThreeTxt;
    private AnimationSet animSetWaveThreeThirstCard;
    private AnimationSet animSetWaveThreeSecondCard;
    private AnimationSet animSetWaveThreeFisrtCard;

    private AnimationSet getAnimSetWaveFourFirstCard;
    private AnimationSet getAnimSetWaveFourSecondCard;
    private AnimationSet getAnimSetWaveFourThirstCard;
    private int count = 5;
    private boolean checkSecondCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        txtvWaveOne = (TextView) findViewById(R.id.wave_one_txt);
        txtvWaveTwo = (TextView) findViewById(R.id.wave_two_txt);
        txtvWaveThree = (TextView) findViewById(R.id.wave_three_txt);


        imgvFirstCard = (ImageView) findViewById(R.id.first_card);
        imgvSecondCard = (ImageView) findViewById(R.id.second_card);
        imgvThirstCard = (ImageView) findViewById(R.id.thirst_card);

        animSetWaveOneTxt = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_one_txt);
        animSetWaveOneThirstCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_one_thirst);
        animSetWaveOneSecondCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_one_second);
        animSetWaveOneFisrtCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_one_first);

        animSetWaveTwoTxt = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_two_txt);
        animSetWaveTwoThirstCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_two_thirst);
        animSetWaveTwoSecondCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_two_second);
        animSetWaveTwoFisrtCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_two_first);

        animSetWaveThreeTxt = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_two_txt);
        animSetWaveThreeThirstCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_three_thirst);
        animSetWaveThreeSecondCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_three_second);
        animSetWaveThreeFisrtCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_three_first);

        getAnimSetWaveFourFirstCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_four_fisrt);
        getAnimSetWaveFourSecondCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_four_second);
        getAnimSetWaveFourThirstCard = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.wave_four_thirst);

        txtvCountDown = (TextView) findViewById(R.id.count_down);
        txtvWaveOne.startAnimation(animSetWaveOneTxt);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Lovingyou.ttf");

        txtvWaveOne.setTypeface(typeface);
        txtvWaveTwo.setTypeface(typeface);
        txtvWaveThree.setTypeface(typeface);
        txtvCountDown.setTypeface(typeface);

        imgvThirstCard.startAnimation(animSetWaveOneThirstCard);
        imgvFirstCard.startAnimation(animSetWaveOneFisrtCard);
        imgvSecondCard.startAnimation(animSetWaveOneSecondCard);

        animSetWaveOneTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txtvWaveOne.setVisibility(View.GONE);
                txtvWaveTwo.setVisibility(View.VISIBLE);
                txtvWaveTwo.setText("Bạn đã sẵn sàng đón nhận những điều sắp xảy đến với bản thân mình ?");
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 1000, 0, 0);
                txtvWaveTwo.setLayoutParams(params);
                imgvFirstCard.startAnimation(animSetWaveTwoFisrtCard);
                imgvSecondCard.startAnimation(animSetWaveTwoSecondCard);
                imgvThirstCard.startAnimation(animSetWaveTwoThirstCard);
                txtvWaveTwo.startAnimation(animSetWaveTwoTxt);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animSetWaveTwoTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txtvWaveTwo.setVisibility(View.GONE);
                txtvWaveThree.setVisibility(View.VISIBLE);
                imgvFirstCard.startAnimation(animSetWaveThreeFisrtCard);
                imgvSecondCard.startAnimation(animSetWaveThreeSecondCard);
                imgvThirstCard.startAnimation(animSetWaveThreeThirstCard);

                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        txtvCountDown.post(new Runnable() {
                            @Override
                            public void run() {
                                if (count > 0) {
                                    count--;
                                }
                                txtvCountDown.setText(Integer.toString(count));
                                if (count == 0 && checkSecondCard == false) {
                                    checkSecondCard = true;
                                    imgvSecondCard.startAnimation(getAnimSetWaveFourSecondCard);
                                    imgvFirstCard.startAnimation(getAnimSetWaveFourFirstCard);
                                    imgvThirstCard.startAnimation(getAnimSetWaveFourThirstCard);

                                    imgvFirstCard.setImageResource(R.drawable.card2);
                                    imgvSecondCard.setImageResource(R.drawable.card3);
                                    imgvThirstCard.setImageResource(R.drawable.card4);
                                }
                            }
                        });
                    }
                };
                Timer timer = new Timer();
                timer.schedule(timerTask, 0, 1000);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

}
