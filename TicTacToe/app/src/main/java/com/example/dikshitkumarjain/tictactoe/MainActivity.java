package com.example.dikshitkumarjain.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // 0 = yellow , 1 = red
    int activePlayer = 0;
    boolean isGameActive = true;

    // Array which maintains state of board
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {

        ImageView image = (ImageView) view;

        int tappedCounter = Integer.parseInt(image.getTag().toString());

        if(gameState[tappedCounter] == 2 && isGameActive) {

            gameState[tappedCounter] = activePlayer;

            image.setTranslationY(-1000f);

            if(activePlayer == 0) {
                image.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            }
            else {
                image.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            image.animate().translationYBy(1000f).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    isGameActive = false;
                    String winner = "Red";
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow";
                    }
                    TextView winMsg = findViewById(R.id.winMsg);
                    winMsg.setText(winner + " has Won!");
                    LinearLayout layout = findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
                else {
                    boolean gameIsOver = true;
                    for(int counterState : gameState) {
                        if(counterState == 2) {
                            gameIsOver = false;
                        }
                        if(gameIsOver) {
                            TextView winMsg = findViewById(R.id.winMsg);
                            winMsg.setText("It's a Draw!!");
                            LinearLayout layout = findViewById(R.id.playAgainLayout);
                            layout.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        }
    }

    public void playAgain(View view) {
        isGameActive = true;
        LinearLayout layout = findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for (int i=0; i<gameState.length; i++) {

            gameState[i] = 2;

        }

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i=0; i<gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
