package com.example.rock_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class RPSActivity extends AppCompatActivity {

    private static final String TAG = "RPSActivity";

    TextView rpsUserSelection, rpsCompSelection, rpsWonLostTieText, rpsScoreText;

    int userScore = 0, compScore = 0;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_r_p_s);

        rpsUserSelection = findViewById(R.id.rpsUserSelection);
        rpsCompSelection = findViewById(R.id.rpsCompSelection);
        rpsWonLostTieText = findViewById(R.id.rpsWonLostTieText);
        rpsScoreText = findViewById(R.id.rpsScoreText);

        rpsUserSelection.setText("");
        rpsCompSelection.setText("");
        rpsWonLostTieText.setText("");

        random = new Random();
    }

    public void resetButton(View view) {
        rpsUserSelection.setText("");
        rpsCompSelection.setText("");
        rpsWonLostTieText.setText("");
        userScore = 0;
        compScore = 0;
        setRpsScoreText(userScore,compScore);
    }

    public void rpsButtonSelected(View view) {
        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, "rpsButtonSelected: " + userSelection);
        matchGame(userSelection);
    }

    private  void matchGame(int userSelection){
        int low = 1;
        int high = 3;
        int compSelection = random.nextInt(high) + low;

        if (userSelection == compSelection){
            //Tie
            rpsWonLostTieText.setText("Tie!");
        }else if ((userSelection == 1 && compSelection == 3) || (userSelection == 3 && compSelection == 2) || (userSelection == 2 && compSelection == 1)){
            // User Wins
            userScore++;
            rpsWonLostTieText.setText("You Won!");
        } else {
            // Comp Wins
            compScore++;
            rpsWonLostTieText.setText("You Lost!");
        }

        switch (userSelection){
            case 1:
                rpsUserSelection.setText("Rock");
                break;
            case 2:
                rpsUserSelection.setText("Paper");
                break;
            case 3:
                rpsUserSelection.setText("Scissor");
                break;
        }

        switch (compSelection){
            case 1:
                rpsCompSelection.setText("Rock");
                break;
            case 2:
                rpsCompSelection.setText("Paper");
                break;
            case 3:
                rpsCompSelection.setText("Scissor");
                break;
        }

        setRpsScoreText(userScore, compScore);
    }

    private void setRpsScoreText(int userScore, int compScore){
        rpsScoreText.setText(String.valueOf(userScore) + " : " + String.valueOf(compScore));
    }


}