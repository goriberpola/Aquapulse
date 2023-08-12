package com.example.aquapulse.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aquapulse.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment extends Fragment  {

    private int progress = 0;
    private ProgressBar progressBar;
    private TextView textViewProgress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_homefragment, container, false);

        progressBar = rootView.findViewById(R.id.progress_bar);
        textViewProgress = rootView.findViewById(R.id.text_view_progress);
        Button buttonIncrement = rootView.findViewById(R.id.button_dec);
        Button buttonDecrement = rootView.findViewById(R.id.button_inc);

        updateProgressBar();

        buttonIncrement.setOnClickListener(v -> {
            if (progress <= 90) {
                progress += 10;
                updateProgressBar();
            }
        });

        buttonDecrement.setOnClickListener(v -> {
            if (progress >= 10) {
                progress -= 10;
                updateProgressBar();
            }
        });

        return rootView;
    }

    @SuppressLint("SetTextI18n")
    private void updateProgressBar() {
        progressBar.setProgress(progress);
        textViewProgress.setText(progress + "%");
    }
}





