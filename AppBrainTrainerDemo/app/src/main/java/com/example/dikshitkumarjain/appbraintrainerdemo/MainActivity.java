package com.example.dikshitkumarjain.appbraintrainerdemo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers = new ArrayList<>();
    int correctAnswerlocation;
    TextView resultTextView;
    TextView markTextView;
    TextView sumTextView;
    TextView timerTextView;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button playAgainBtn;
    int score = 0;
    int numOfQuestion = 0;
    RelativeLayout gameLayout;

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(playAgainBtn);

    }

    public void selectAnswer(View view) {
        if(view.getTag().toString().equals(Integer.toString(correctAnswerlocation))) {
            score++;
            resultTextView.setText("Correct Answer!");
        }
        else {
            resultTextView.setText("Wrong Answer..");
        }
        numOfQuestion++;
        markTextView.setText(Integer.toString(score) + "/" + Integer.toString(numOfQuestion));
        generateQuestions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        markTextView = findViewById(R.id.markTextView);
        startButton = findViewById(R.id.startButton);
        sumTextView = findViewById(R.id.sumTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        gameLayout = findViewById(R.id.gameLayout);

    }

    public void playAgain(View view) {
        score = 0;
        numOfQuestion = 0;
        timerTextView.setText("30s");
        markTextView.setText("0/0");
        resultTextView.setText("");
        playAgainBtn.setVisibility(View.INVISIBLE);
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);

        generateQuestions();

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgainBtn.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Time Up..! Correct answers : " + score);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
            }
        }.start();
    }

    private void generateQuestions() {
        Random random = new Random();
        int a = random.nextInt(25);
        int b = random.nextInt(25);
        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        correctAnswerlocation = random.nextInt(4);
        answers.clear();
        int wrongAnswer;
        for (int i = 0; i < 4; i++) {
            if (i == correctAnswerlocation) {
                answers.add(a + b);
            }
            else {
                wrongAnswer = random.nextInt(49);
                while (wrongAnswer == a + b) {
                    wrongAnswer = random.nextInt(49);
                }
                answers.add(wrongAnswer);
            }
        }

        btn0.setText(Integer.toString(answers.get(0)));
        btn1.setText(Integer.toString(answers.get(1)));
        btn2.setText(Integer.toString(answers.get(2)));
        btn3.setText(Integer.toString(answers.get(3)));
    }
}
