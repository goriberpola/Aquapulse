package com.example.aquapulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import android.widget.TextView;

public class page3 extends AppCompatActivity {

    private NumberPicker weightNumberPicker;

    private Button weight_next;
    private Button weight_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        weight_next = (Button) findViewById(R.id.next);
        weight_back = (Button) findViewById(R.id.back);

        weight_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedWeight = weightNumberPicker.getValue();
                int calculatedValue = performCalculation(selectedWeight);

                sendwaterdata(calculatedValue);

                //openpage3();



            }

        });




        weight_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backpage2();

            }
        });

        weightNumberPicker = findViewById(R.id.weightNumberPicker);
        weightNumberPicker.setMinValue(1);
        weightNumberPicker.setMaxValue(300);
        weightNumberPicker.setValue(50);

    }

    public void sendwaterdata(int calculatedValue) {

       Intent intent = new Intent(this, waterintake.class);

         intent.putExtra("calculatedValue", calculatedValue);
       startActivity(intent);
    }
    public void openpage3()
    {

        Intent intent = new Intent(this, waterintake.class);
        startActivity(intent);
    }

    public void backpage2()
    {
        Intent intent = new Intent(this,page2.class);
        startActivity(intent);
    }

    public int performCalculation(int selectedWeight) {
        return (int) (selectedWeight *33.57);

    }





}