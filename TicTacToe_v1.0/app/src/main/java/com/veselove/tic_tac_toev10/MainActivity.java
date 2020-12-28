package com.veselove.tic_tac_toev10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.veselove.tic_tac_toev10.Player.player1;
import static com.veselove.tic_tac_toev10.Player.player2;

public class MainActivity extends AppCompatActivity {

    int count = 1;

    private Button button_00;
    private Button button_01;
    private Button button_02;
    private Button button_10;
    private Button button_11;
    private Button button_12;
    private Button button_20;
    private Button button_21;
    private Button button_22;
    private Button button_restart;
    private TextView firstPlayerName;
    private TextView secondPlayerName;
    private TextView firstPlayerScores;
    private TextView secondPlayerScores;
    private TextView victoryTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle playersName = getIntent().getExtras();
        player1.setName(playersName.get("NAME1").toString());
        player2.setName(playersName.get("NAME2").toString());

        button_00 = findViewById(R.id.button00);
        button_01 = findViewById(R.id.button01);
        button_02 = findViewById(R.id.button02);
        button_10 = findViewById(R.id.button10);
        button_11 = findViewById(R.id.button11);
        button_12 = findViewById(R.id.button12);
        button_20 = findViewById(R.id.button20);
        button_21 = findViewById(R.id.button21);
        button_22 = findViewById(R.id.button22);
        button_restart = findViewById(R.id.button_restart);
        firstPlayerName = findViewById(R.id.textViewPlayerName1);
        secondPlayerName = findViewById(R.id.textViewPlayerName2);
        firstPlayerScores = findViewById(R.id.textViewPoints1);
        secondPlayerScores = findViewById(R.id.textViewPoints2);
        victoryTextView = findViewById(R.id.victoryTextView);

        firstPlayerName.setText(player1.getName());
        secondPlayerName.setText(player2.getName());

    }
    public void onClick(View view){
        if (count % 2 == 1) {
            firstPlayerName.setTextColor(Color.GREEN);
            firstPlayerName.setTypeface(Typeface.DEFAULT_BOLD);
            secondPlayerName.setTextColor(Color.GRAY);
            secondPlayerName.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            boolean winning = Logic.playerMoveHandler(count % 2, view.getTag().toString());
            Button button = (Button) view;
            button.setText("O");
            button.setOnClickListener(null);
            if (winning) {
                winMode(player1);
            }
            if (count == 9 && !winning) {
                drawMode();
            }
        }

        else {
            secondPlayerName.setTextColor(Color.GREEN);
            secondPlayerName.setTypeface(Typeface.DEFAULT_BOLD);
            firstPlayerName.setTextColor(Color.GRAY);
            firstPlayerName.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            boolean winning = Logic.playerMoveHandler(count % 2, view.getTag().toString());
            Button button = (Button) view;
            button.setText("X");
            button.setOnClickListener(null);
            if (winning) {
                winMode(player2);
            }
            if (count == 9 && !winning) {
                drawMode();
            }
        }
        count++;
    }

    public void winMode(Player player) {
        victoryTextView.setText(player.getName() + " win!");
        player.addPoint();
        if (player == player1) {
            firstPlayerScores.setText(player.getPointsCounter()  + "");
        }
        if (player == player2) {
            secondPlayerScores.setText(player.getPointsCounter()  + "");
        }
        disablePlayingField();
        button_restart.setVisibility(View.VISIBLE);
    }

    public void drawMode(){
        victoryTextView.setText(getString(R.string.draw));
        disablePlayingField();
        button_restart.setVisibility(View.VISIBLE);
    }

    public void restartGame(View view){
        victoryTextView.setText(getString(R.string.empty_text));
        enablePlayingField();
        Logic.clearField();
        clealFieldView();
        count = 1;
        button_restart.setVisibility(View.INVISIBLE);
    }

    public void disablePlayingField(){
        button_00.setOnClickListener(null);
        button_01.setOnClickListener(null);
        button_02.setOnClickListener(null);
        button_10.setOnClickListener(null);
        button_11.setOnClickListener(null);
        button_12.setOnClickListener(null);
        button_20.setOnClickListener(null);
        button_21.setOnClickListener(null);
        button_22.setOnClickListener(null);
    }

    public void enablePlayingField(){
        button_00.setOnClickListener(this::onClick);
        button_01.setOnClickListener(this::onClick);
        button_02.setOnClickListener(this::onClick);
        button_10.setOnClickListener(this::onClick);
        button_11.setOnClickListener(this::onClick);
        button_12.setOnClickListener(this::onClick);
        button_20.setOnClickListener(this::onClick);
        button_21.setOnClickListener(this::onClick);
        button_22.setOnClickListener(this::onClick);
    }

    public void clealFieldView(){
        button_00.setText(getResources().getString(R.string.empty_text));
        button_01.setText(getResources().getString(R.string.empty_text));
        button_02.setText(getResources().getString(R.string.empty_text));
        button_10.setText(getResources().getString(R.string.empty_text));
        button_11.setText(getResources().getString(R.string.empty_text));
        button_12.setText(getResources().getString(R.string.empty_text));
        button_20.setText(getResources().getString(R.string.empty_text));
        button_21.setText(getResources().getString(R.string.empty_text));
        button_22.setText(getResources().getString(R.string.empty_text));
    }

}







//private static final String TAG = "aaa";    //logging
//        Log.d(TAG, player1.getName() + "ssssssssssssssssssssss");             //logging
//        Log.d(TAG, player2.getName() + "ssssssssssssssssssssss");             //logging
