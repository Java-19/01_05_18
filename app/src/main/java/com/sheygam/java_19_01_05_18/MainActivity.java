package com.sheygam.java_19_01_05_18;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static float SCALE = 1.0F;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();

    }

    public void addFragment(View view) {
        if(count != 3) {
            transaction = manager.beginTransaction();
            transaction = transaction.add(R.id.fragment_container, new MyFragment());
            transaction.commit();
            count++;
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container,new MyFragment(),"MY_TAG")
                    .commit();
            count++;
        }
    }

    public void replaceFragment(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new MyFragment())
                .commit();
    }

    public void removeFragment(View view) {
        MyFragment fragment = (MyFragment) manager.findFragmentByTag("MY_TAG");
        if(fragment!= null){
            manager.beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }
}
