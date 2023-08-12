package com.example.aquapulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.aquapulse.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bedtime extends AppCompatActivity {


    private Button bedtime_next;
    private Button bedtime_back;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedtime);







        //setting number picker for min




            bedtime_next = (Button) findViewById(R.id.next);
            bedtime_back = (Button) findViewById(R.id.back);

            bedtime_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openpage3();

                }
            });

            bedtime_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backpage2();

                }
            });

        }

        public void openpage3()
        {
            Intent intent = new Intent(this, page3.class);


            startActivity(intent);
        }

        public void backpage2()
        {
            Intent intent = new Intent(this, page4.class);
            startActivity(intent);
        }


}