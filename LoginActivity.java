package com.example.aquapulse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText signInEmailEditText, signInPasswordEditText;
    private TextView signUpTextView;
    private Button signInButton;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();


        signInEmailEditText =findViewById(R.id.login_email);

        signInPasswordEditText =findViewById(R.id.login_password);

        signInButton=findViewById(R.id.login_button);

        signUpTextView=findViewById(R.id.signupRedirectText);

        progressBar =findViewById(R.id.progressbarId);


        signUpTextView.setOnClickListener(this);
        signInButton.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login_button) {
            userLogin();
        } else if (id == R.id.signupRedirectText) {
            Intent intent = new Intent(getApplicationContext(), signupActivity.class);
            startActivity(intent);
        }
    }

    private void userLogin() {
        String email = signInEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty())
        {
            signInEmailEditText.setError("Enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }
        //if @ sign not used
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signInEmailEditText.setError("Enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(email.isEmpty())
        {
            signInPasswordEditText.setError("Enter a password");
            signInPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signInPasswordEditText.setError("Minimum length of a password");
            signInPasswordEditText.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if(task.isSuccessful())
                {
                    finish();  //sign in page jate bar bar na ashe
                    Intent intent = new Intent(getApplicationContext(), home.class); //login succesfull hole kun activity te jaccche ta lekhe deya
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// jokhoni profile page e jacchi tkhn top er shb clear hoye jabe

                    startActivity(intent);


                }
                else {
                    Toast.makeText(getApplicationContext(),"login unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}