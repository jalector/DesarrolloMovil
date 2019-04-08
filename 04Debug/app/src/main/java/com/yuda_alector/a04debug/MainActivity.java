package com.yuda_alector.a04debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.factorial(5);
    }

    public double factorial(double x){
        if(x == 0){
            return  1;
        } else {
            return factorial(x-1) * x;
        }
    }
}
