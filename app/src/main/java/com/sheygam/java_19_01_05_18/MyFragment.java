package com.sheygam.java_19_01_05_18;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class MyFragment extends Fragment {

    public MyFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_fragment,container,false);
        Random rnd = new Random();
        int r = rnd.nextInt(256);
        int g = rnd.nextInt(256);
        int b = rnd.nextInt(256);
        int color = Color.rgb(r,g,b);
        view.setBackgroundColor(color);

        view.setScaleX(MainActivity.SCALE);
        view.setScaleY(MainActivity.SCALE);
        MainActivity.SCALE -= 0.1;
        return view;
    }
}
