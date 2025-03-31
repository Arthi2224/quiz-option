package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ResultActivity3 extends AppCompatActivity {

    TextView tv,tv2,tv3;
    Button btnRestart;
    CircularProgressBar circularProgressBar;
    TextView ResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result3);



        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);


        btnRestart = findViewById(R.id.btnRestart);
        ResultText =  findViewById(R.id.resulttext);


        circularProgressBar = findViewById(R.id.circularprogressbar);
        circularProgressBar.setProgress(QuestionActivity3.correct);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answer:").append(QuestionActivity3.correct).append("\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong answer:").append(QuestionActivity3.wrong).append("\n");


        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score:").append(QuestionActivity3.correct).append("\n");


        StringBuffer sb4 = new StringBuffer();
        sb4.append(QuestionActivity3.correct).append("/").append("5");


        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        tv3.setText(sb3);
        ResultText.setText(sb4);


        QuestionActivity3.correct=0;
        QuestionActivity3.wrong=0;


        btnRestart.setOnClickListener(view -> {

            Intent intent = new Intent(ResultActivity3.this,MainActivity.class);
            startActivity(intent);

        });

    }
}