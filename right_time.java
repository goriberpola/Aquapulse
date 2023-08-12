package com.example.aquapulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class right_time extends AppCompatActivity {

    private Button water_time_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_time);

        water_time_next = (Button) findViewById(R.id.next);
        water_time_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpage3();

            }
        });

    }

    public void openpage3()
    {
        Intent intent = new Intent(this, monitor.class);
        startActivity(intent);
    }

}