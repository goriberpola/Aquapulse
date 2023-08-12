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

import com.example.aquapulse.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;



    FirebaseDatabase db;

    DatabaseReference reference;

    private EditText signUpEmailEditText, signUpPasswordEditText,nameEditText,userNameEditText;
    private TextView signInTextView;
    private Button signUpButton;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_signup);


        //storing name,username,email into the database




        mAuth= FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbarId);

        nameEditText =findViewById(R.id.signup_name);

        signUpEmailEditText =findViewById(R.id.signup_email);

        userNameEditText =findViewById(R.id.signup_username);

        signUpPasswordEditText =findViewById(R.id.signup_password);

        signUpButton=findViewById(R.id.signup_button);

        signInTextView=findViewById(R.id.loginRedirectText);

        signInTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.signup_button) {

            userRegister();

        } else if (id == R.id.loginRedirectText) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }

    private void userRegister() {
        String name = nameEditText.getText().toString().trim();

        String email = signUpEmailEditText.getText().toString().trim();

        String username = userNameEditText.getText().toString().trim();

        String password = signUpPasswordEditText.getText().toString().trim();
        //checking the validity of the username
        Users users=new Users(username,name,email);
        db = FirebaseDatabase.getInstance();
        reference =db.getReference("Users");


       if(name.isEmpty())
        {
            nameEditText.setError("Enter an name");
            nameEditText.requestFocus();
            return;
        }
        //checking the validity of the email
        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        //if @ sign not used
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        //checking the validity of the username
        if(username.isEmpty())
        {
            userNameEditText.setError("Enter an username");
            userNameEditText.requestFocus();
            return;
        }
        //checking the validity of the password
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signUpPasswordEditText.setError("Minimum length of a password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class); //login succesfull hole kun activity te jaccche ta lekhe deya
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// jokhoni profile page e jacchi tkhn top er shb clear hoye jabe

                    startActivity(intent);
                } else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(),"user is already registered",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }


                }

            }
        });
        reference.child(username).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(),"Successfully updated",Toast.LENGTH_SHORT).show();

            }
        });


    }
}