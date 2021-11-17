package com.jonesclass.wong.tictacsmack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Random rNumber = new Random();
    int muskWins = 0;
    int bezosWins = 0;
    boolean twoPlayers;
    String teamChoice;
    boolean elonTurn = true;
    ImageButton[][] imageButtons = new ImageButton[3][3];
    TextView messageTextView;
    private static final String TAG = "MainActivityTag";
    boolean firstClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        messageTextView = findViewById(R.id.textView_message);
        int rNumber = (int)Math.floor(Math.random()*(1-0+1));
        Log.d(TAG, "Random: " + rNumber);
        if (rNumber == 1 && firstClick == false) {
            messageTextView.setText("Team Musk Please Take Your Turn");
            firstClick = true;
            elonTurn = true;
        } else if (rNumber == 0 && firstClick == false){
            messageTextView.setText("Team Bezos Please Take Your Turn");
            firstClick = true;
            elonTurn = false;
        }

        imageButtons[0][0] = findViewById(R.id.imageButton_00);
        imageButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(0, 0);
            }
        });

        imageButtons[0][1] = findViewById(R.id.imageButton_01);
        imageButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(0, 1);
            }
        });

        imageButtons[0][2] = findViewById(R.id.imageButton_02);
        imageButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(0, 2);
            }
        });

        imageButtons[1][0] = findViewById(R.id.imageButton_10);
        imageButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(1, 0);
            }
        });

        imageButtons[1][1] = findViewById(R.id.imageButton_11);
        imageButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(1, 1);
            }
        });

        imageButtons[1][2] = findViewById(R.id.imageButton_12);
        imageButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(1, 2);
            }
        });

        imageButtons[2][0] = findViewById(R.id.imageButton_20);
        imageButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(2, 0);
            }
        });

        imageButtons[2][1] = findViewById(R.id.imageButton_21);
        imageButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonClicked(2, 1);
            }
        });

        imageButtons[2][2] = findViewById(R.id.imageButton_22);
        imageButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(2, 2);
            }
        });

    } //end on create

    public void buttonClicked(int row, int column) {

        if (elonTurn == true) {
            imageButtons[row][column].setImageDrawable(getResources().getDrawable(R.drawable.musk));
            elonTurn = false;
        } else if (elonTurn == false) {
            imageButtons[row][column].setImageDrawable(getResources().getDrawable(R.drawable.bezos));
            elonTurn = true;
        }

        if (elonTurn == true) {
            messageTextView.setText("Team Musk Please Take Your Turn");
            firstClick = true;
        } else if (elonTurn == false){
            messageTextView.setText("Team Bezos Please Take Your Turn");
        }
    }

    public void checkWin() {

    }

    //add methods for ai and win

}