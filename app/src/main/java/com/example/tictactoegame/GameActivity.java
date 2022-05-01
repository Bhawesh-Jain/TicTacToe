package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    private boolean game_active = true;
    private int active_player = 0, counter = 0, winner = 5;

    int[] gameState = {4, 4, 4, 4, 4, 4, 4, 4, 4};

    public void playerTap(View v) {
        ImageView clicked_ImageView = (ImageView) v;
        int tapped_image = Integer.parseInt(v.getTag().toString());

        if (game_active) {

            if (gameState[tapped_image] == 4) {
                counter++;

                gameState[tapped_image] = active_player;

                if (active_player == 0) {
                    active_player = 1;
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText("O's Turn");
                    clicked_ImageView.setImageResource(R.drawable.x_letter);
                }
                else {
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText("X's Turn");
                    clicked_ImageView.setImageResource(R.drawable.o_letter);
                    active_player = 0;
                }
            }
            else {
                Toast.makeText(this, "Box Already Full", Toast.LENGTH_SHORT).show();
            }

            boolean hasWon=false;

            if (gameState[0] == gameState[1] && gameState[1] == gameState[2] && gameState[2] != 4){
                hasWon = true;
                winner = gameState[2];
            }
            if (gameState[3] == gameState[4] && gameState[4] == gameState[5] && gameState[5] != 4){
                hasWon = true;
                winner = gameState[3];
            }
            if (gameState[6] == gameState[7] && gameState[7] == gameState[8] && gameState[8] != 4){
                hasWon = true;
                winner = gameState[6];
            }
            if (gameState[0] == gameState[3] && gameState[3] == gameState[6] && gameState[6] != 4){
                hasWon = true;
                winner = gameState[0];
            }
            if (gameState[1] == gameState[4] && gameState[4] == gameState[7] && gameState[7] != 4){
                hasWon = true;
                winner = gameState[1];
            }
            if (gameState[2] == gameState[5] && gameState[5] == gameState[8] && gameState[8] != 4){
                hasWon = true;
                winner = gameState[2];
            }
            if (gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[8] != 4){
                hasWon = true;
                winner = gameState[0];
            }
            if (gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[6] != 4){
                hasWon = true;
                winner = gameState[2];
            }

            if (counter == 9) {
                game_active = false;
                if (!hasWon){
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText("It's A Draw");
                }
            }

            if (hasWon){
                game_active = false;
                TextView status = (TextView) findViewById(R.id.status);
                if (winner == 0){
                    status.setText("Player X Won");
                }
                else {
                    status.setText("Player O Won");
                }
            }

        }

        else {
            Toast.makeText(this, "Tap on Restart To Continue", Toast.LENGTH_SHORT).show();
        }

    }


    public void gameReset(View view) {
        game_active = true;
        active_player = 0;
        counter = 0;
        Arrays.fill(gameState, 4);
        ((ImageView) findViewById(R.id.img_box_1)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_2)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_3)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_4)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_5)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_6)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_7)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_8)).setImageResource(R.drawable.empty_box);
        ((ImageView) findViewById(R.id.img_box_9)).setImageResource(R.drawable.empty_box);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


    }
}

