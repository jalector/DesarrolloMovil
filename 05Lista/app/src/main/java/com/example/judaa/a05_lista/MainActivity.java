package com.example.judaa.a05_lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private Button buscar, nuevo;
    private List<String> datos;

    private EditText nuevoElemento;
    private EditText criterioBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.datos = new ArrayList<String>();

        this.screen = (TextView) findViewById(R.id.screen);
        this.buscar = (Button) findViewById(R.id.buscar);
        this.nuevo = (Button) findViewById(R.id.nuevo);

        this.nuevoElemento = (EditText) findViewById(R.id.nuevoElemento);
        this.criterioBusqueda = (EditText) findViewById(R.id.criterioBusqueda);

        this.showElements(this.datos);

    }

    private void showElements(List<String> datos){
        String screenValue = "No exiten datos para mostrar";

        if(this.datos.size() > 0){
            for (int i = 0, e = datos.size(); i < e; i++) {
                screenValue += this.datos.get(i) + "/n";
            }
        }

        this.screen.setText(screenValue);
    }


    public void addNewElement(View view){
        String newElement = this.nuevoElemento.getText().toString().trim();
        if(newElement.length() > 0){
            this.datos.add(newElement);
            this.showElements(this.datos);
            this.nuevoElemento.setText("");
        }else{
            Toast.makeText(this, "El campo no puede estar vacio", Toast.LENGTH_SHORT).show();
        }
    }

    public void searchElement(View view){
        String searchedElement = this.criterioBusqueda.getText().toString().trim();
        if(searchedElement.length() > 0){
            List<String> mached = new ArrayList<String>();
            for (int i = 0, e = datos.size(); i < e; i++) {
                String dato = this.datos.get(i);
                if(dato.contains(searchedElement)){
                    mached.add(dato);
                }
            }
            this.criterioBusqueda.setText("");
            this.showElements(mached);
        } else {
            this.showElements(this.datos);
        }
    }


}
