package com.example.aquapulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class waterintake extends AppCompatActivity {

    private Button water_next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterintake);

        TextView calculatedTextView = findViewById(R.id.calculatedTextView);
         int calculatedValue = getIntent().getIntExtra("calculatedValue", 0);
        calculatedTextView.setText(String.valueOf(calculatedValue));

        water_next = (Button) findViewById(R.id.next);

        water_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpage3();

            }
        });

    }

    public void openpage3()
    {
        Intent intent = new Intent(this, right_time.class);
        startActivity(intent);
    }
}