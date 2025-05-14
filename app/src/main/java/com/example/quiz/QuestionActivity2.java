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
public class QuestionActivity2 extends AppCompatActivity {


    String[] questions = {

            "Which of the following is the correct syntax of including a user defined header files in C++?",
            "Which of the following is used for comments in C++?",
            "Which of the following extension is used for user-defined header file in c++?",
            "Which of the following is a correct identifier in C++?",
            "Which of the following is not a type of Constructor in C++?"

    };
    String[] answer = {

            "#include “userdefined”",
            "both // comment or /* comment */",
            "h",
            "VAR_1234",
            "Friend constructor"

    };
    String[] opt = {

            "#include [userdefined]"," #include “userdefined”","#include <userdefined.h>","#include <userdefined>",


            "/* comment */","// comment */","// comment", "both // comment or /* comment */",


            "hg", "pp","h","hp",


            "VAR_1234", "$var_name", "7VARNAME", "7var_name",


            "Default constructor", "Parameterized constructor", "Copy constructor", "Friend constructor"

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
        setContentView(R.layout.activity_question2);


        final TextView score = findViewById(R.id.textview4);


        questionnumber = findViewById(R.id.DispName);
        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);
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
                    Toast.makeText(QuestionActivity2.this, "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String  ansText = uans.getText().toString();


                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity2.this, "Correct :)", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(QuestionActivity2.this, "Oops ! Try again :(", Toast.LENGTH_SHORT).show();
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
                        Intent in =new Intent(QuestionActivity2.this,ResultActivity2.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }

            }
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),ResultActivity2.class);
            startActivity(intent1);
        });

    }
}