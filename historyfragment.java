package com.example.aquapulse.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aquapulse.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link historyfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class historyfragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historyfragment, container, false);
    }
}