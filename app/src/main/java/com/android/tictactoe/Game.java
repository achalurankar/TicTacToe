package com.android.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity {

    ImageView x0y0, x0y1, x0y2, x1y0, x1y1, x1y2, x2y0, x2y1, x2y2;
    char turn = 'o';
    char[][] mat = new char[3][3];
    List<Character> turnsList = new ArrayList<>();
    int turnCount = 0;
    TextView result, restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        x0y0 = findViewById(R.id.x0_y0);
        x0y1 = findViewById(R.id.x0_y1);
        x0y2 = findViewById(R.id.x0_y2);
        x1y0 = findViewById(R.id.x1_y0);
        x1y1 = findViewById(R.id.x1_y1);
        x1y2 = findViewById(R.id.x1_y2);
        x2y0 = findViewById(R.id.x2_y0);
        x2y1 = findViewById(R.id.x2_y1);
        x2y2 = findViewById(R.id.x2_y2);

        result = findViewById(R.id.Result);
        restart = findViewById(R.id.Restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        turnsList.add('x');
        turnsList.add('o');
        initializeSpacesToMat();

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        x0y0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(0, 0, x0y0);
            }
        });

        x0y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(0, 1, x0y1);
            }
        });

        x0y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(0, 2, x0y2);
            }
        });

        x1y0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(1, 0, x1y0);
            }
        });

        x1y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(1, 1, x1y1);
            }
        });

        x1y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(1, 2, x1y2);
            }
        });

        x2y0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(2, 0, x2y0);
            }
        });

        x2y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(2, 1, x2y1);
            }
        });

        x2y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.this.onClick(2, 2, x2y2);
            }
        });
    }

    private void onClick(int i, int j, ImageView block) {
        if (mat[i][j] == ' ') {
            mat[i][j] = turn;
            if (turn == 'x') {
                block.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                turn = 'o';
            } else {
                block.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                turn = 'x';
            }
            checkWinner();
        }
    }

    private void initializeSpacesToMat() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = ' ';
            }
        }
    }

    private void checkWinner() {
        turnCount++;
        char a, b, c;
        for (int i = 0; i < 3; i++) {
            a = mat[i][0];
            b = mat[i][1];
            c = mat[i][2];

            boolean res = isWinner(a, b, c);
            if (res)
                return;

            a = mat[0][i];
            b = mat[1][i];
            c = mat[2][i];

            res = isWinner(a, b, c);
            if (res)
                return;
        }

        a = mat[0][0];
        b = mat[1][1];
        c = mat[2][2];

        boolean res = isWinner(a, b, c);
        if (res)
            return;

        a = mat[2][0];
        b = mat[1][1];
        c = mat[0][2];

        res = isWinner(a, b, c);
        if (res)
            return;

        if (turnCount == 9) {
            restart.setVisibility(View.VISIBLE);
            result.setText("Draw");
        }
    }

    private boolean isWinner(char a, char b, char c) {
        if (turnsList.contains(a) && turnsList.contains(b) && turnsList.contains(c)) {
            if (a == b && a == c) {
                restart.setVisibility(View.VISIBLE);
                result.setText("Winner " + String.valueOf(a).toUpperCase());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}