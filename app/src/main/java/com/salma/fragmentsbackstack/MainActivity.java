package com.salma.fragmentsbackstack;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addFragmentOne;
    Button addFragmentTwo;
    Button addFragmentThree;
    Button replaceFragment;
    Button removeFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragmentOne = findViewById(R.id.btnAddOne);
        addFragmentTwo = findViewById(R.id.btnAddTwo);
        addFragmentThree = findViewById(R.id.btnAddThree);
        replaceFragment = findViewById(R.id.btnReplace);
        removeFragment = findViewById(R.id.btnRemove);
        fragmentManager = getSupportFragmentManager();

        addFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentOne fragmentOne = new FragmentOne();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, fragmentOne, "myFirstFragment");
                fragmentTransaction.addToBackStack("firstFragment");
                fragmentTransaction.commit();
            }
        });
        addFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, fragmentTwo, "mySecondFragment");
                fragmentTransaction.addToBackStack("secondFragment");
                fragmentTransaction.commit();
            }
        });
        addFragmentThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentThree fragmentThree = new FragmentThree();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, fragmentThree, "myThirdFragment");
                fragmentTransaction.addToBackStack("thirdFragment");
                fragmentTransaction.commit();
            }
        });

        replaceFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentFour fragmentFour = new FragmentFour();
                fragmentManager.popBackStack();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragmentFour, "myForthFragment");
                fragmentTransaction.addToBackStack("forthFragment");
                fragmentTransaction.commit();
            }
        });
        removeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.popBackStack();

            }
        });

    }
}
