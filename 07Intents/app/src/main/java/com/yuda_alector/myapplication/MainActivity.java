package com.yuda_alector.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Alumno alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.alumno = new Alumno("Juda", "Alector");
    }

    public void go(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("alumno", alumno);
        startActivity(intent);
    }
}
