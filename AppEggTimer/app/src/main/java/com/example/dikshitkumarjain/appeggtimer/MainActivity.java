package com.example.dikshitkumarjain.appeggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerTextView;
    Button controllerButton;
    CountDownTimer countDownTimer;
    Boolean isCounterActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(60);

        timerTextView = findViewById(R.id.timerTextView);
        controllerButton = findViewById(R.id.timerButton);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setTimer(int i) {
        int minutes = i / 60;
        int sec = i - minutes * 60;
        String minInString = (minutes <=9) ? "0" + Integer.toString(minutes) : Integer.toString(minutes);
        String secInString = (sec <=9) ? "0" + Integer.toString(sec) : Integer.toString(sec);
        timerTextView.setText(minInString + ":" + secInString);
    }

    public void setControllerButton(View view) {
        if(isCounterActive == false) {
            isCounterActive = true;
            timerSeekBar.setEnabled(false);
            controllerButton.setText("Stop");
            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    setTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    resetTimer();
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start();

                }
            }.start();
        }
        else {
            resetTimer();
        }
    }

    private void resetTimer() {
        timerSeekBar.setProgress(60);
        timerSeekBar.setEnabled(true);
        timerTextView.setText("01:00");
        controllerButton.setText("Go!");
        countDownTimer.cancel();
        isCounterActive = false;
    }
}
