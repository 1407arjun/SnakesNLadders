package com.example.snakesnladders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] ladderArray = {4,13,33,42,50,62,74};
    int[] snakeArray = {27,40,43,54,66,76,89,99};
    int[] ladder = {25,46,49,63,69,81,92};
    int[] snake = {5,3,18,31,45,58,53,41};
    int[] positions = {0,0,0,0};

    String myid1, myid2;
    int n, i, p = 1;
    boolean gameActive = true;

    public void diceRoll(View view){
        TextView display = findViewById(R.id.display);
        TextView diceNum = findViewById(R.id.diceNum);
        Button reset = findViewById(R.id.reset);
        reset.setEnabled(true);
        boolean temp = true;

        Random r = new Random();
        int number = r.nextInt(6) + 1;

        if (number == 6) {
            diceNum.setText("It's " + number + " on the die! - Play Again!");
        }else{
            diceNum.setText("It's " + number + " on the die!");
        }

        if ((positions[p - 1] == 0 && (number == 1 || number == 6)) || positions[p - 1] != 0) {
            myid1 = ("coin" + positions[p - 1]);
            positions[p - 1] += number;

            if (positions[p - 1] < 100) {
                ImageView coinOld = findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));

                if (p == 1) {
                    coinOld.setImageResource(R.drawable.p1);
                } else if (p == 2) {
                    coinOld.setImageResource(R.drawable.p2);
                } else if (p == 3) {
                    coinOld.setImageResource(R.drawable.p3);
                } else {
                    coinOld.setImageResource(R.drawable.p4);
                }

                coinOld.animate().alpha(0f).setDuration(1000);
                myid2 = ("coin" + positions[p - 1]);
                ImageView coinNew = findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));

                if (p == 1) {
                    coinNew.setImageResource(R.drawable.p1);
                } else if (p == 2) {
                    coinNew.setImageResource(R.drawable.p2);
                } else if (p == 3) {
                    coinNew.setImageResource(R.drawable.p3);
                } else {
                    coinNew.setImageResource(R.drawable.p4);
                }

                coinNew.animate().alpha(1f).setDuration(1000);

                for (i = 0; i < 7; i++) {

                    if (ladderArray[i] == positions[p - 1]) {
                        myid1 = ("coin" + positions[p - 1]);
                        coinOld = findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));

                        if (p == 1) {
                            coinOld.setImageResource(R.drawable.p1);
                        } else if (p == 2) {
                            coinOld.setImageResource(R.drawable.p2);
                        } else if (p == 3) {
                            coinOld.setImageResource(R.drawable.p3);
                        } else {
                            coinOld.setImageResource(R.drawable.p4);
                        }

                        coinOld.animate().alpha(0f).setDuration(1000);
                        positions[p - 1] = ladder[i];
                        Toast.makeText(this, "Great! You climbed up a ladder", Toast.LENGTH_LONG).show();
                        myid2 = ("coin" + positions[p - 1]);
                        coinNew = findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));

                        if (p == 1) {
                            coinNew.setImageResource(R.drawable.p1);
                        } else if (p == 2) {
                            coinNew.setImageResource(R.drawable.p2);
                        } else if (p == 3) {
                            coinNew.setImageResource(R.drawable.p3);
                        } else {
                            coinNew.setImageResource(R.drawable.p4);
                        }

                        coinNew.animate().alpha(1f).setDuration(1000);
                        temp = false;
                        break;
                    }
                }

                if (temp) {
                    for (i = 0; i < 8; i++) {

                        if (snakeArray[i] == positions[p - 1]) {
                            myid1 = ("coin" + positions[p - 1]);
                            coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));

                            if (p == 1) {
                                coinOld.setImageResource(R.drawable.p1);
                            } else if (p == 2) {
                                coinOld.setImageResource(R.drawable.p2);
                            } else if (p == 3) {
                                coinOld.setImageResource(R.drawable.p3);
                            } else {
                                coinOld.setImageResource(R.drawable.p4);
                            }

                            coinOld.animate().alpha(0f).setDuration(1000);
                            positions[p - 1] = snake[i];
                            Toast.makeText(this, "Ouch! A snake bit you", Toast.LENGTH_LONG).show();
                            myid2 = ("coin" + positions[p - 1]);
                            coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));

                            if (p == 1) {
                                coinNew.setImageResource(R.drawable.p1);
                            } else if (p == 2) {
                                coinNew.setImageResource(R.drawable.p2);
                            } else if (p == 3) {
                                coinNew.setImageResource(R.drawable.p3);
                            } else {
                                coinNew.setImageResource(R.drawable.p4);
                            }

                            coinNew.animate().alpha(1f).setDuration(1000);
                            break;
                        }
                    }
                }

            } else if (positions[p - 1] == 100) {
                ImageView coinOld = findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
                if (p == 1) {
                    coinOld.setImageResource(R.drawable.p1);
                } else if (p == 2) {
                    coinOld.setImageResource(R.drawable.p2);
                } else if (p == 3) {
                    coinOld.setImageResource(R.drawable.p3);
                } else {
                    coinOld.setImageResource(R.drawable.p4);
                }

                coinOld.animate().alpha(0f).setDuration(1000);
                myid2 = ("coin" + positions[p - 1]);
                ImageView coinNew = findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));

                if (p == 1) {
                    coinNew.setImageResource(R.drawable.p1);
                } else if (p == 2) {
                    coinNew.setImageResource(R.drawable.p2);
                } else if (p == 3) {
                    coinNew.setImageResource(R.drawable.p3);
                } else {
                    coinNew.setImageResource(R.drawable.p4);
                }

                coinNew.animate().alpha(1f).setDuration(1000);
                display.setText("Player " + p + " has won");
                gameActive = false;

            } else {
                positions[p - 1] -= number;
            }

            for (i = 0; i < n; i++) {
                if (i != (p - 1) && positions[i] == positions[p - 1] && positions[i] != 0) {
                    positions[i] = 0;
                    Toast.makeText(this, "Bad Luck! Player " + p + " took your position", Toast.LENGTH_LONG).show();
                }
            }
        }

        if (gameActive) {
            if (number != 6) {
                if (p == n) {
                    p = 1;
                } else if (p < n) {
                    p++;
                }
            }

            ImageView currentCoin = findViewById(R.id.imageView);

            if (p == 1) {
                currentCoin.setImageResource(R.drawable.p1);
            } else if (p == 2) {
                currentCoin.setImageResource(R.drawable.p2);
            } else if (p == 3) {
                currentCoin.setImageResource(R.drawable.p3);
            } else {
                currentCoin.setImageResource(R.drawable.p4);
            }
            display.setText("Player " + p + "'s turn");

        }else{
            Button button = findViewById(R.id.dice);
            button.setEnabled(false);
            reset.setText("Play Again");
        }
    }

    public void resetGame(View view){
        int i;
        p = 1;
        String myid;
        gameActive = true;

        for (i=0;i<n;i++) {
            myid = ("coin" + positions[i]);
            ImageView coinOn = (ImageView) findViewById(getResources().getIdentifier(myid, "id", getPackageName()));
            coinOn.animate().alpha(0f).setDuration(1000);
            positions[i] = 0;
        }

        Button reset = findViewById(R.id.reset);
        reset.setEnabled(false);
        reset.setText("Reset");

        Button button = findViewById(R.id.dice);
        button.setEnabled(true);

        TextView display = findViewById(R.id.display);
        TextView dicenum = findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");

        ImageView currentCoin = findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        display.setText("Player 1's turn");
    }

    public void menuCall(View view){
        LinearLayout bg = findViewById(R.id.linearLayout);
        GridLayout grid = findViewById(R.id.gridLayout);
        LinearLayout menu = findViewById(R.id.menu);

        grid.animate().alpha(0f).setDuration(500);
        bg.animate().alpha(0f).setDuration(500);
        menu.animate().translationYBy(2000f).setDuration(1000);
    }

    public void menuClose(View view){
        LinearLayout bg = findViewById(R.id.linearLayout);
        GridLayout grid = findViewById(R.id.gridLayout);
        LinearLayout menu = findViewById(R.id.menu);

        grid.animate().alpha(1f).setDuration(1000);
        bg.animate().alpha(1f).setDuration(1000);
        menu.animate().translationYBy(-2000f).setDuration(500);
    }

    public void p2(View view){
        ImageView close = findViewById(R.id.menuCloseImageView);
        close.setVisibility(View.VISIBLE);

        int i;
        n = 2;
        p = 1;
        String myid;
        gameActive = true;

        for (i=0;i<n;i++) {
            myid = ("coin" + positions[i]);
            ImageView coinOn = findViewById(getResources().getIdentifier(myid, "id", getPackageName()));
            coinOn.animate().alpha(0f).setDuration(1000);
            positions[i] = 0;
        }

        Button reset = findViewById(R.id.reset);
        reset.setEnabled(false);

        TextView display = findViewById(R.id.display);
        TextView dicenum = findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");

        ImageView currentCoin = findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        LinearLayout bg = findViewById(R.id.linearLayout);
        GridLayout grid = findViewById(R.id.gridLayout);
        LinearLayout menu = findViewById(R.id.menu);

        grid.animate().alpha(1f).setDuration(1000);
        bg.animate().alpha(1f).setDuration(1000);
        menu.animate().translationYBy(-2000f).setDuration(500);
        display.setText("Player 1's turn");

    }

    public void p3(View view){
        ImageView close = findViewById(R.id.menuCloseImageView);
        close.setVisibility(View.VISIBLE);
        int i;
        n = 3;
        p = 1;
        String myid;
        gameActive = true;

        for (i=0;i<n;i++) {
            myid = ("coin" + positions[i]);
            ImageView coinOn = findViewById(getResources().getIdentifier(myid, "id", getPackageName()));
            coinOn.animate().alpha(0f).setDuration(1000);
            positions[i] = 0;
        }

        Button reset = findViewById(R.id.reset);
        reset.setEnabled(false);

        TextView display = findViewById(R.id.display);
        TextView dicenum = findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");

        ImageView currentCoin = findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        LinearLayout bg = findViewById(R.id.linearLayout);
        GridLayout grid = findViewById(R.id.gridLayout);
        LinearLayout menu = findViewById(R.id.menu);

        grid.animate().alpha(1f).setDuration(1000);
        bg.animate().alpha(1f).setDuration(1000);
        menu.animate().translationYBy(-2000f).setDuration(500);
        display.setText("Player 1's turn");
    }

    public void p4(View view){
        ImageView close = findViewById(R.id.menuCloseImageView);
        close.setVisibility(View.VISIBLE);
        int i;
        n = 4;
        p = 1;
        String myid;
        gameActive = true;

        for (i=0;i<n;i++) {
            myid = ("coin" + positions[i]);
            ImageView coinOn = findViewById(getResources().getIdentifier(myid, "id", getPackageName()));
            coinOn.animate().alpha(0f).setDuration(1000);
            positions[i] = 0;
        }

        Button reset = findViewById(R.id.reset);
        reset.setEnabled(false);

        TextView display = findViewById(R.id.display);
        TextView dicenum = findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");

        ImageView currentCoin = findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        LinearLayout bg = findViewById(R.id.linearLayout);
        GridLayout grid = findViewById(R.id.gridLayout);
        LinearLayout menu = findViewById(R.id.menu);

        grid.animate().alpha(1f).setDuration(1000);
        bg.animate().alpha(1f).setDuration(1000);
        menu.animate().translationYBy(-2000f).setDuration(500);
        display.setText("Player 1's turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView display = findViewById(R.id.display);
        TextView dicenum = findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");

        ImageView close = findViewById(R.id.menuCloseImageView);
        LinearLayout menu = findViewById(R.id.menu);
        menu.animate().alpha(1f).setDuration(500);
        close.setVisibility(View.INVISIBLE);

        ImageView currentCoin = findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        display.setText("Player 1's turn");

        Button reset = findViewById(R.id.reset);
        reset.setEnabled(false);
    }
}