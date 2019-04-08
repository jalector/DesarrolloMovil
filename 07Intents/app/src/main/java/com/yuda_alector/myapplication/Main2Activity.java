package com.yuda_alector.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle alumnoBundle = getIntent().getExtras();

        Alumno alumno = null;

        if (alumnoBundle != null){
            alumno = (Alumno) alumnoBundle.getSerializable("alumno");
        }


        String datos = alumno.getApellido() + " " + alumno.getNombre();
        Toast.makeText(this, datos, Toast.LENGTH_LONG).show();
    }

    public void activity1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
