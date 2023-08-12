package com.example.aquapulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page4 extends AppCompatActivity {

    private Button wake_next;
    private Button wake_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        wake_next = (Button) findViewById(R.id.next);
        wake_back = (Button) findViewById(R.id.back);

        wake_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpage3();

            }
        });

        wake_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backpage2();

            }
        });

    }

    public void openpage3()
    {
        Intent intent = new Intent(this, bedtime.class);
        startActivity(intent);
    }

    public void backpage2()
    {
        Intent intent = new Intent(this,page3.class);
        startActivity(intent);
    }

}