package com.example.mskatz.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Stores an information about Deadpool's choice
    String choiceD = "";
    //Stores an information about Spider-Man's choice
    String choiceS = "";
    //general Spider-Man's score
    int scoreS = 0;
    //general Deadpool's score
    int scoreD = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Chooses rock in a rock-paper-scissors game for Deadpool
    public void chooseRockD(View v) {
        choiceD = "rock";
    }

    //Chooses paper in a rock-paper-scissors game for Deadpool
    public void choosePaperD(View v) {
        choiceD = "paper";
    }

    //Chooses scissors in a rock-paper-scissors game for Deadpool
    public void chooseScissorsD(View v) {
        choiceD = "scissors";
    }

    //Chooses rock in a rock-paper-scissors game for Spider-Man
    public void chooseRockS(View v) {
        choiceS = "rock";
    }

    //Chooses paper in a rock-paper-scissors game for Spider-Man
    public void choosePaperS(View v) {
        choiceS = "paper";
    }

    //Chooses scissors in a rock-paper-scissors game for Spider-Man
    public void chooseScissorsS(View v) {
        choiceS = "scissors";
    }

    //Checks who won in a rock-paper-scissors game
    public void checkWhoWin(View v) {

        String spiderManWin = "Point to Spider-Man";
        String deadpoolWin = "Point to Deadpool";

        if (choiceS.equals("") || choiceD.equals("")) {
            displayInfo("Your move...");
        } else if (choiceD.equals(choiceS)) {
            displayInfo("Draw");
        } else if (choiceD.equals("rock")) {
            if (choiceS.equals("paper")) {
                addScoreS(scoreS);
                displayInfo(spiderManWin);
            } else if (choiceS.equals("scissors")) {
                addScoreD(scoreD);
                displayInfo(deadpoolWin);
            }
        } else if (choiceD.equals("paper")) {
            if (choiceS.equals("scissors")) {
                addScoreS(scoreS);
                displayInfo(spiderManWin);
            } else if (choiceS.equals("rock")) {
                addScoreD(scoreD);
                displayInfo(deadpoolWin);
            }
        } else if (choiceD.equals("scissors")) {
            if (choiceS.equals("rock")) {
                addScoreS(scoreS);
                displayInfo(spiderManWin);
            } else {
                addScoreD(scoreD);
                displayInfo(deadpoolWin);
            }
        }
        choiceD = "";
        choiceS = "";
    }

    //Adds one point to general Deadpool's score
    public void addScoreD(int score) {
        scoreD = scoreD + 1;
        displayScoreD(scoreD);
    }

    //Adds one point to general Spider-Man's score
    public void addScoreS(int score) {
        scoreS = scoreS + 1;
        displayScoreS(scoreS);
    }

    //Resets the score to 0 for two teams
    public void resetScore(View v) {
        scoreS = 0;
        scoreD = 0;
        choiceD = "";
        choiceS = "";
        displayScoreD(scoreD);
        displayScoreS(scoreS);
        displayInfo("Let's start...");
    }

    //Displays Deadpool's score
    public void displayScoreD(int score) {
        TextView scoreView = findViewById(R.id.score_Deadpool);
        scoreView.setText(String.valueOf(score));
    }

    //Displays Spider-Man's score
    public void displayScoreS(int score) {
        TextView scoreView = findViewById(R.id.score_SpiderMan);
        scoreView.setText(String.valueOf(score));
    }

    //Displays messages during the game
    public void displayInfo(String info) {
        TextView infoView = findViewById(R.id.info);
        infoView.setText(info);
    }

    /**
     * This method is called right before we change orientation and preserves the score value
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreS", scoreS);
        outState.putInt("scoreD", scoreD);
    }

    /**
     * This method is called after we change orientation and displaying the score values which are saved before change orientation
     */
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        scoreS = saveInstanceState.getInt("scoreS");
        scoreD = saveInstanceState.getInt("scoreD");
        displayScoreS(scoreS);
        displayScoreD(scoreD);
    }
}
