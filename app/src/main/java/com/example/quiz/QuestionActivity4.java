package com.example.quiz;

import static com.example.quiz.R.id.DispName;

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

public class QuestionActivity4 extends AppCompatActivity {


    String[] questions = {

            "Who invented Java Programming?",
            "Which statement is true about Java?",
            "Which component is used to compile, debug and execute the java programs?",
            "Which one of the following is not a Java feature??",
            "Which of these cannot be used for a variable name in Java?"

    };
    String[] answer = {

            "James Gosling",
            "Java is a platform-independent programming language",
            "JDK",
            "Use of pointers",
            "keyword"

    };
    String[] opt = {

            "Guido van Rossum", "James Gosling","Dennis Ritchie","Bjarne Stroustrup",

            "Java is a sequence-dependent programming language", "Java is a code dependent programming language", "Java is a platform-dependent programming language", "Java is a platform-independent programming language",

            "JRE", "JIT","JDK", "JVM",

            "Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible",

            "identifier & keyword","identifier", "keyword", "none of the mentioned"

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
        setContentView(R.layout.activity_question4);


        final TextView score = findViewById(R.id.textview4);


        questionnumber = findViewById(DispName);
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
                    Toast.makeText(QuestionActivity4.this, "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String  ansText = uans.getText().toString();


                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity4.this, "Correct :)", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(QuestionActivity4.this, "Oops ! Try again :(", Toast.LENGTH_SHORT).show();
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
                        Intent in =new Intent(QuestionActivity4.this,ResultActivity4.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }

            }
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),ResultActivity4.class);
            startActivity(intent1);
        });

    }
}
