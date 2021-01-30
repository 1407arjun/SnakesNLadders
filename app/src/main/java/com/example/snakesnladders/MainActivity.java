package com.example.snakesnladders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int position = 0;
    int[] ladderArray = {4,13,33,42,50,62,74};
    int[] snakeArray = {27,40,43,54,66,76,89,99};
    int[] ladder = {25,46,49,63,69,81,92};
    int[] snake = {5,3,18,31,45,58,53,41};
    String myid1;
    String myid2;
    int i;

    public void diceRoll(View view){
        //while (true) {
            boolean temp = true;
            TextView diceNum = (TextView) findViewById(R.id.diceNum);
            Random r = new Random();
            int number = r.nextInt(6) + 1;
            diceNum.setText(Integer.toString(number));
            myid1 = ("coin" + position);
            position += number;
            if (position < 100) {
                ImageView coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
                coinOld.animate().alpha(0f).setDuration(1000);
                myid2 = ("coin" + position);
                ImageView coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));
                coinNew.animate().alpha(1f).setDuration(1000);
                for (i = 0; i < 7; i++) {
                    if (ladderArray[i] == position) {
                        myid1 = ("coin" + position);
                        coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
                        coinOld.animate().alpha(0f).setDuration(1000);
                        position = ladder[i];
                        myid2 = ("coin" + position);
                        coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));
                        coinNew.animate().alpha(1f).setDuration(1000);
                        temp = false;
                        break;
                    }
                }
                if (temp) {
                    for (i = 0; i < 8; i++) {
                        if (snakeArray[i] == position) {
                            myid1 = ("coin" + position);
                            coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
                            coinOld.animate().alpha(0f).setDuration(1000);
                            position = snake[i];
                            myid2 = ("coin" + position);
                            coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));
                            coinNew.animate().alpha(1f).setDuration(1000);
                            break;
                        }
                    }
                }
            } else if (position == 100){
                ImageView coinOld = (ImageView) findViewById(getResources().getIdentifier(myid1, "id", getPackageName()));
                coinOld.animate().alpha(0f).setDuration(1000);
                myid2 = ("coin" + position);
                ImageView coinNew = (ImageView) findViewById(getResources().getIdentifier(myid2, "id", getPackageName()));
                coinNew.animate().alpha(1f).setDuration(1000);
                TextView display = (TextView) findViewById(R.id.display);
                display.setText("Player has won");
                //break;
            }else{
                position -= number;
            }
        //}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}