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

public class QuestionActivity extends AppCompatActivity {


    String[] questions = {

            "Who is the father of C language?",
            "Which of the following is not a valid C variable name?",
            "All keywords in C are in ____________",
            "What is short int in C programming?",
            "Which keyword is used to prevent any changes in the variable within a C program?"

    };
    String[] answer = {

            "Dennis Ritchie",
            "int $main;",
            "LowerCase letters",
            "Short is the qualifier and int is the basic data type",
            "const"

    };
    String[] opt = {

            "Steve Jobs", "James Gosling", "Dennis Ritchie", "Rasmus Lerdorf",

            "int number;", "float rate;", "int variable_count;", "int $main;",

            "LowerCase letters", "UpperCase letters", "CamelCase letters", " None of the mentioned",

            "The basic data type of C", "Qualifier", "Short is the qualifier and int is the basic data type", "All of the mentioned",

            "immutable", "immutable", "const", "volatile"
    };


    int flag = 0;


    public static int marks=0,correct=0,wrong=0;


    TextView tv;
    Button submitbutton,quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private TextView questionnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        final TextView score = findViewById(R.id.textview4);
        this.findViewById(R.id.DispName);


        questionnumber = findViewById(R.id.DispName);
        submitbutton = findViewById(R.id.button3);
        quitbutton= findViewById(R.id.buttonquit);
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
            public void onClick(View view) {

                if (radio_g.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(QuestionActivity.this, "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String  ansText = uans.getText().toString();


                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity.this, "Correct :)", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(QuestionActivity.this, "Oops ! Try again :(", Toast.LENGTH_SHORT).show();
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
                        Intent in =new Intent(QuestionActivity.this,ResultActivity.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }

            }
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),ResultActivity.class);
            startActivity(intent1);
        });

    }
}