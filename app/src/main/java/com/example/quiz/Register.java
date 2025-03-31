package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mFullname, mEmail, mPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar progressBar;
    String UserId;

    FirebaseAuth fauth;
    FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mFullname = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerbtn);
        mLoginBtn = findViewById(R.id.createText);
        progressBar = findViewById(R.id.progressbar);

        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        if (fauth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        mLoginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        });


        mRegisterBtn.setOnClickListener(view -> {


            final String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            final String fullname = mFullname.getText().toString();
            final String phone = mPhone.getText().toString();

            if (TextUtils.isEmpty(email)) {

                mEmail.setError("Email is required");
                return;
            }
            if (TextUtils.isEmpty(password)) {

                mPassword.setError("Password is required");
                return;
            }
            if (password.length() < 6) {

                mPassword.setError("Password must be>=6 characters");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);


            fauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    FirebaseUser fuser = fauth.getCurrentUser();
                    assert fuser != null;
                    fuser.sendEmailVerification().addOnSuccessListener(unused -> Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Log.d(TAG, "OnFailure: Email not send" + e.getMessage()));


                    Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                    UserId = fauth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("Users").document(UserId);
                    Map<String, Object> User = new HashMap<>();
                    User.put("fName", fullname);
                    User.put("email", email);
                    User.put("phone", phone);
                    documentReference.set(User).addOnSuccessListener(unused -> Log.d(TAG, "onSuccess:User profile is created for" + UserId)).addOnFailureListener(e -> Log.d(TAG, "Onfailure:" + e));
                    startActivity(new Intent((getApplicationContext()), MainActivity.class));

                } else {
                    Toast.makeText(Register.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }


            });


        });
    }
}


