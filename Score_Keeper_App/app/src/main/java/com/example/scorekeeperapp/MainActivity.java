package com.example.scorekeeperapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int score_team_A = 0;
    private int score_team_B = 0;

    private TextView team_A_text_view;
    private TextView team_B_text_view;

    // Variables to keep track of the matches won by Team A and Team B
    private TextView result_text_view;
    private int result_team_A = 0;
    private int result_team_B = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team_A_text_view = findViewById(R.id.team_A_text_view);
        Button three_points_A = findViewById(R.id.three_points_A);
        Button two_points_A = findViewById(R.id.two_points_A);
        Button free_throw_A = findViewById(R.id.free_throw_A);

        team_B_text_view = findViewById(R.id.team_B_text_view);
        Button three_points_B = findViewById(R.id.three_points_B);
        Button two_points_B = findViewById(R.id.two_points_B);
        Button free_throw_B = findViewById(R.id.free_throw_B);

        Button reset_button = findViewById(R.id.reset_button);
        Button submit_button = findViewById(R.id.submit_button);
        result_text_view = findViewById(R.id.result_text_view);
        result_text_view.setText(getResources().getString(R.string.final_result, result_team_A, result_team_B));

        three_points_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_points_A(3);
                team_A_text_view.setText(String.valueOf(score_team_A));
            }
        });

        two_points_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_points_A(2);
                team_A_text_view.setText(String.valueOf(score_team_A));
            }
        });

        free_throw_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_points_A(1);
                team_A_text_view.setText(String.valueOf(score_team_A));
            }
        });

        three_points_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_points_B(3);
                team_B_text_view.setText(String.valueOf(score_team_B));
            }
        });

        two_points_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_points_B(2);
                team_B_text_view.setText(String.valueOf(score_team_B));
            }
        });

        free_throw_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_points_B(1);
                team_B_text_view.setText(String.valueOf(score_team_B));
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_match();

                result_team_A = 0;
                result_team_B = 0;
                String result = getResources().getString(R.string.final_result, result_team_A, result_team_B);
                result_text_view.setText(result);
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score_team_A > score_team_B) {
                    result_team_A++;
                }
                if (score_team_B > score_team_A) {
                    result_team_B++;
                }

                String result = getResources().getString(R.string.final_result, result_team_A, result_team_B);
                result_text_view.setText(result);

                reset_match();
            }
        });

    }

    private void set_points_A(int point) {
        score_team_A += point;
    }

    private void set_points_B(int point) {
        score_team_B += point;
    }

    private void reset_match() {
        score_team_A = 0;
        score_team_B = 0;
        team_A_text_view.setText(String.valueOf(score_team_A));
        team_B_text_view.setText(String.valueOf(score_team_B));
    }

}