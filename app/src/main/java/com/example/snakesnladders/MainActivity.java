package com.example.snakesnladders;

import androidx.appcompat.app.AppCompatActivity;

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

    //int position = 0;
    int[] ladderArray = {4,13,33,42,50,62,74};
    int[] snakeArray = {27,40,43,54,66,76,89,99};
    int[] ladder = {25,46,49,63,69,81,92};
    int[] snake = {5,3,18,31,45,58,53,41};
    String myid1;
    String myid2;
    int i;
    int p = 1;
    int n;
    int[] positions = {0,0,0,0};
    boolean gameActive = true;

    public void diceRoll(View view){
        //while (true) {
            TextView display = (TextView) findViewById(R.id.display);
            Button reset = (Button) findViewById(R.id.reset);
            reset.setEnabled(true);
            //ImageView coinOld = (ImageView) view;
            //ImageView coinNew = (ImageView) view;

            boolean temp = true;
            TextView diceNum = (TextView) findViewById(R.id.diceNum);
            Random r = new Random();
            int number = r.nextInt(6) + 1;
            diceNum.setText("It's " + number + " on the die!");
            if ((positions[p - 1] == 0 && (number == 1 || number == 6)) || positions[p - 1] != 0) {
                myid1 = ("coin" + positions[p - 1]);
                positions[p - 1] += number;
                if (positions[p - 1] < 100) {
                    ImageView coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
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
                    ImageView coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));
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
                            positions[p - 1] = ladder[i];
                            Toast.makeText(this, "Great! You climbed up a ladder", Toast.LENGTH_LONG).show();
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
                    ImageView coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
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
                    ImageView coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));
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
                    //break;
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
                ImageView currentCoin = (ImageView) findViewById(R.id.imageView);
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
                Button button = (Button) findViewById(R.id.dice);
                button.setEnabled(false);
            }
        //}
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
        Button reset = (Button) findViewById(R.id.reset);
        reset.setEnabled(false);
        TextView display = (TextView) findViewById(R.id.display);
        TextView dicenum = (TextView) findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");
        ImageView currentCoin = (ImageView) findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        display.setText("Player 1's turn");
    }

    public void menuCall(View view){
        LinearLayout bg = (LinearLayout) findViewById(R.id.bg);
        bg.animate().alpha(0f).setDuration(500);
        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.animate().translationYBy(2000f).setDuration(1000);
    }

    public void menuClose(View view){
        LinearLayout bg = (LinearLayout) findViewById(R.id.bg);
        bg.animate().alpha(1f).setDuration(1000);
        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.animate().translationYBy(-2000f).setDuration(500);
    }

    public void p2(View view){
        ImageView close = (ImageView) findViewById(R.id.menuCloseImageView);
        close.setVisibility(View.VISIBLE);
        n = 2;
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
        Button reset = (Button) findViewById(R.id.reset);
        reset.setEnabled(false);
        TextView display = (TextView) findViewById(R.id.display);
        TextView dicenum = (TextView) findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");
        ImageView currentCoin = (ImageView) findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        LinearLayout bg = (LinearLayout) findViewById(R.id.bg);
        bg.animate().alpha(1f).setDuration(1000);
        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.animate().translationYBy(-2000f).setDuration(500);
        display.setText("Player 1's turn");

    }

    public void p3(View view){
        ImageView close = (ImageView) findViewById(R.id.menuCloseImageView);
        close.setVisibility(View.VISIBLE);
        n = 3;
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
        Button reset = (Button) findViewById(R.id.reset);
        reset.setEnabled(false);
        TextView display = (TextView) findViewById(R.id.display);
        TextView dicenum = (TextView) findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");
        ImageView currentCoin = (ImageView) findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        LinearLayout bg = (LinearLayout) findViewById(R.id.bg);
        bg.animate().alpha(1f).setDuration(1000);
        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.animate().translationYBy(-2000f).setDuration(500);
        display.setText("Player 1's turn");
    }

    public void p4(View view){
        ImageView close = (ImageView) findViewById(R.id.menuCloseImageView);
        close.setVisibility(View.VISIBLE);
        n = 4;
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
        Button reset = (Button) findViewById(R.id.reset);
        reset.setEnabled(false);
        TextView display = (TextView) findViewById(R.id.display);
        TextView dicenum = (TextView) findViewById(R.id.diceNum);
        dicenum.setText("Let's Go!");
        ImageView currentCoin = (ImageView) findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        LinearLayout bg = (LinearLayout) findViewById(R.id.bg);
        bg.animate().alpha(1f).setDuration(1000);
        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.animate().translationYBy(-2000f).setDuration(500);
        display.setText("Player 1's turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView display = (TextView) findViewById(R.id.display);
        TextView dicenum = (TextView) findViewById(R.id.diceNum);
        ImageView close = (ImageView) findViewById(R.id.menuCloseImageView);
        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.animate().alpha(1f).setDuration(500);
        close.setVisibility(View.INVISIBLE);
        dicenum.setText("Let's Go!");
        ImageView currentCoin = (ImageView) findViewById(R.id.imageView);
        currentCoin.setImageResource(R.drawable.p1);
        display.setText("Player 1's turn");
        Button reset = (Button) findViewById(R.id.reset);
        reset.setEnabled(false);
    }
}