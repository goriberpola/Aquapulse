package com.example.aquapulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page2 extends AppCompatActivity {

    private Button genderpagebutton_next;
    private Button genderpagebutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        genderpagebutton_next = (Button) findViewById(R.id.next);
        genderpagebutton_back = (Button) findViewById(R.id.back);

        genderpagebutton_next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openwakeuptime();

        }
    });

        genderpagebutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backpage2();

            }
        });

}

    public void openwakeuptime()
    {
        Intent intent = new Intent(this, page4.class);
        startActivity(intent);
    }

    public void backpage2()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}