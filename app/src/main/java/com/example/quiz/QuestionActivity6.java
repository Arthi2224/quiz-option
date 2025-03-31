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

public class QuestionActivity6 extends AppCompatActivity {


    String[] questions = {

            "What is Kotlin?",
            " Which company developed Kotlin?",
            "What is the file extension of Kotlin files?",
            " Which of the following is a primary feature of Kotlin?",
            "Which of the following are primitive data types in Kotlin?"

    };
    String[] answer = {

            "A general-purpose programming language for JVM and Android",
            "JetBrains",
            ".kt",
            "Above mentioned",
            "Boolean, Byte, Short, Int, Float, Long, Double, Char"

    };
    String[] opt = {

           "A front-end scripting language”,“Amarkuplanguage","A general-purpose programming language for JVM and Android","A database query language",

           "JetBrains","Microsoft" ,"Google","Oracle",

            ".java", ".kot", ".kt", ".kotlin",

            "null safety","no semicolon","lambda expression","Above mentioned",

            "String, Array, Stack, Queue", "Boolean, Byte, Short, Int, Float, Long, Double, Char" ,
            "There are no Primitive data types in Kotlin only Non-Primitive data types",
            "boolean, byte, short, int, float, long, double, char"

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
        setContentView(R.layout.activity_question6);


        final TextView score = findViewById(R.id.textview4);


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
                    Toast.makeText(QuestionActivity6.this, "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String  ansText = uans.getText().toString();


                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity6.this, "Correct :)", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(QuestionActivity6.this, "Oops ! Try again :(", Toast.LENGTH_SHORT).show();
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
                        Intent in =new Intent(QuestionActivity6.this,ResultActivity6.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }

            }
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),ResultActivity6.class);
            startActivity(intent1);
        });

    }
}