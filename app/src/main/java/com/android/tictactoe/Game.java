package com.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity {

    ImageView x0y0, x0y1, x0y2, x1y0, x1y1, x1y2, x2y0, x2y1, x2y2;
    char turn = 'o';
    char[][] mat = new char[3][3];
    List<Character> turnsList = new ArrayList<>();
    int turnCount = 0;
    TextView result,restart;

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
                if (mat[0][0] == ' ') {
                    mat[0][0] = turn;
                    if (turn == 'x') {
                        x0y0.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x0y0.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x0y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[0][1] == ' ') {
                    mat[0][1] = turn;
                    if (turn == 'x') {
                        x0y1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x0y1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x0y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[0][2] == ' ') {
                    mat[0][2] = turn;
                    if (turn == 'x') {
                        x0y2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x0y2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x1y0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[1][0] == ' ') {
                    mat[1][0] = turn;
                    if (turn == 'x') {
                        x1y0.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x1y0.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x1y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[1][1] == ' ') {
                    mat[1][1] = turn;
                    if (turn == 'x') {
                        x1y1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x1y1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x1y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[1][2] == ' ') {
                    mat[1][2] = turn;
                    if (turn == 'x') {
                        x1y2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x1y2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x2y0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[2][0] == ' ') {
                    mat[2][0] = turn;
                    if (turn == 'x') {
                        x2y0.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x2y0.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x2y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[2][1] == ' ') {
                    mat[2][1] = turn;
                    if (turn == 'x') {
                        x2y1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x2y1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });

        x2y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat[2][2] == ' ') {
                    mat[2][2] = turn;
                    if (turn == 'x') {
                        x2y2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.x_vector));
                        turn = 'o';
                    } else {
                        x2y2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.o_vector));
                        turn = 'x';
                    }
                    checkWinner();
                }
            }
        });
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
        for (int i = 0; i < 3; i++) {
            char a, b, c;
            a = mat[i][0];
            b = mat[i][1];
            c = mat[i][2];

            boolean res = isWinner(a,b,c);
            if(res)
                return;

            a = mat[0][i];
            b = mat[1][i];
            c = mat[2][i];

            res = isWinner(a,b,c);
            if(res)
                return;
        }

        char a, b, c;

        a = mat[0][0];
        b = mat[1][1];
        c = mat[2][2];

        boolean res = isWinner(a,b,c);
        if(res)
            return;

        a = mat[2][0];
        b = mat[1][1];
        c = mat[0][2];

        res = isWinner(a,b,c);
        if(res)
            return;

        if(turnCount == 9){
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