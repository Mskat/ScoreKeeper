package com.example.mskatz.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    String choiceD = null;
    String choiceS = null;
    int scoreS = 0;
    int scoreD = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chooseRockD(View v) {
        choiceD = "rock";
    }

    public void choosePaperD(View v) {
        choiceD = "paper";
    }

    public void chooseScissorsD(View v) {
        choiceD = "scissors";
    }

    public void chooseRockS(View v) {
        choiceS = "rock";
    }

    public void choosePaperS(View v) {
        choiceS = "paper";
    }

    public void chooseScissorsS(View v) {
        choiceS = "scissors";
    }

    public void check(View v) {
        String spidermanWin = "Point to Spider-Man!";
        String deadpoolWin = "Point to Deadpool!";

        if (choiceS == null || choiceD == null) {
            displayInfo("Your move...");
        } else if (choiceD.equals(choiceS)) {
            displayInfo("Draw!");
        } else if (choiceD.equals("rock")) {
            if (choiceS.equals("paper")) {
                addScoreS(scoreS);
                displayInfo(spidermanWin);
            } else if (choiceS.equals("scissors")) {
                addScoreD(scoreD);
                displayInfo(deadpoolWin);
            }
        } else if (choiceD.equals("paper")) {
            if (choiceS.equals("scissors")) {
                addScoreS(scoreS);
                displayInfo(spidermanWin);
            } else if (choiceS.equals("rock")) {
                addScoreD(scoreD);
                displayInfo(deadpoolWin);
            }
        } else if (choiceD.equals("scissors")) {
            if (choiceS.equals("rock")) {
                addScoreS(scoreS);
                displayInfo(spidermanWin);
            } else {
                addScoreD(scoreD);
                displayInfo(deadpoolWin);
            }
        }
        choiceD = null;
        choiceS = null;
    }

    public void addScoreD(int score) {
        scoreD = scoreD + 1;
        displayScoreD(scoreD);
    }

    public void addScoreS(int score) {
        scoreS = scoreS + 1;
        displayScoreS(scoreS);
    }

    public void reset(View v) {
        scoreS = 0;
        scoreD = 0;
        choiceD = null;
        choiceS = null;
        displayScoreD(scoreD);
        displayScoreS(scoreS);
        displayInfo("Let's start!");
    }

    public void displayScoreD(int score) {
        TextView scoreView = findViewById(R.id.score_Deadpool);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreS(int score) {
        TextView scoreView = findViewById(R.id.score_SpiderMan);
        scoreView.setText(String.valueOf(score));
    }

    public void displayInfo(String info) {
        TextView infoView = findViewById(R.id.info);
        infoView.setText(info);
    }
}
