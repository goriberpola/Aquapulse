package com.example.aquapulse;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.aquapulse.fragments.historyfragment;
import com.example.aquapulse.fragments.fragment;
import com.example.aquapulse.fragments.settingfragment;

public class home_pageadapter  extends FragmentStateAdapter {
    public home_pageadapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new fragment();
            case 1:
                return new historyfragment();
            case 2:
                return new settingfragment();
            default:
                return new fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
