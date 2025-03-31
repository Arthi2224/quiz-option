package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity3 extends AppCompatActivity {


    String[] questions = {

            "Who developed Python Programming Language?",
            "Which type of Programming does Python support?",
            "Is Python case sensitive when dealing with identifiers?",
            "Which of the following is the correct extension of the Python file?",
            "Is Python code compiled or interpreted?"

    };
    String[] answer = {

            "Guido van Rossum",
            "all of the mentioned",
            "yes",
            ".py",
            "Python code is both compiled and interpreted"

    };
    String[] opt = {

            "Wick van Rossum","Rasmus Lerdorf", "Guido van Rossum", "Niene Stom",

            "object-oriented programming", "structured programming", "functional programming", "all of the mentioned",

            "no", "yes", "machine dependent", "none of the mentioned",

            ".python", ".pl", ".py", ".p",

            "Python code is both compiled and interpreted", "Python code is neither compiled nor interpreted", "Python code is only compiled", "Python code is only interpreted"

    };


    int flag = 0;


    public static int marks=0,correct=0,wrong=0;


    TextView tv;
    Button submitbutton,quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private TextView questionnumber;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);


        final TextView score = findViewById(R.id.textview4);
        getIntent();


        questionnumber = findViewById(R.id.DispName);
        submitbutton = findViewById(R.id.button3);
        submitbutton = findViewById(R.id.buttonquit);
        tv = findViewById(R.id.tvque);



        radio_g = findViewById(R.id.answergrp);
        rb1 = findViewById(R.id.radiobutton);
        rb2 = findViewById(R.id.radiobutton2);
        rb3 = findViewById(R.id.radiobutton3);
        rb4 = findViewById(R.id.radiobutton4);


        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if (radio_g.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(QuestionActivity3.this, "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String  ansText = uans.getText().toString();


                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity3.this, "Correct :)", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(QuestionActivity3.this, "Oops ! Try again :(", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(score!=null)
                {
                    score.setText(""+correct);

                    if(flag<questions.length)
                    {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag*4]);
                        rb2.setText(opt[flag*4 + 1]);
                        rb3.setText(opt[flag*4 + 2]);
                        rb4.setText(opt[flag*4 + 3]);
                        questionnumber.setText(flag+"/"+questions.length+"Question");
                    }
                    else{
                        marks=correct;
                        Intent in =new Intent(QuestionActivity3.this,ResultActivity3.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }


            }
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),ResultActivity3.class);
            startActivity(intent1);
        });

    }
}