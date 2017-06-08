package com.wulee.text2speach;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.liangmayong.text2speech.OnText2SpeechListener;
import com.liangmayong.text2speech.Text2Speech;

import static android.R.attr.animation;

public class MainActivity extends AppCompatActivity {

    private TextView tvContent;
    private ImageView ivPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvContent = (TextView)findViewById(R.id.tv);
        ivPlay = (ImageView)findViewById(R.id.iv_play_msg_content);

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text2Speech.speech(MainActivity.this,tvContent.getText().toString(),true);
            }
        });

        final ScaleAnimation scaleanimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scaleanimation.setDuration(500);
        scaleanimation.setRepeatCount(ValueAnimator.INFINITE);
        scaleanimation.setRepeatMode(ValueAnimator.INFINITE);
        scaleanimation.setInterpolator(new AccelerateInterpolator());

        Text2Speech.setOnText2SpeechListener(new OnText2SpeechListener() {
            @Override
            public void onCompletion() {
                Log.i("speak","onCompletion");
                scaleanimation.cancel();
            }
            @Override
            public void onPrepared() {
                Log.i("speak","onPrepared");
                ivPlay.startAnimation(scaleanimation);
            }
            @Override
            public void onError(Exception e, String s) {
                Log.i("speak","onError");
                scaleanimation.cancel();
            }
            @Override
            public void onStart() {
                Log.i("speak","onStart");
            }
            @Override
            public void onLoadProgress(int i, int i1) {
                Log.i("speak","onLoadProgress");
            }
            @Override
            public void onPlayProgress(int i, int i1) {
                Log.i("speak","onPlayProgress---->"+ i);
            }
        });
    }
}
