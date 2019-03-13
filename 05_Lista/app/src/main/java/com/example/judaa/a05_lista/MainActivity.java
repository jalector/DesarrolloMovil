package com.example.judaa.a05_lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    Button buscar, nuevo;
    List<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new ArrayList<String>();

        this.screen = (TextView) findViewById(R.id.screen);
        this.buscar = (Button) findViewById(R.id.buscar);
        this.nuevo = (Button) findViewById(R.id.nuevo);


    }

    void actualizarDatosEnPantal(){

    }



}
