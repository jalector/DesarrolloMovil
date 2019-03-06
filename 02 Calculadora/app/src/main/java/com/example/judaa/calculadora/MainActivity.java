package com.example.judaa.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView screen;

    Button  equals,
            plus,
            min,
            times,
            divide,
            sqrt,
            pow,
            cancel,
            ce,
            dot,
            zero,
            one,
            two,
            three,
            four,
            five,
            six,
            seven,
            eight,
            nine;

    Operation operations;
    String lastValue;

    final int MIN_SCREEN_VALUE = 10;
    final int MAX_SCREEN_VALUE = 15;

    final byte FUN_PLUS = 1;
    final byte FUN_MIN  = 2;
    final byte FUN_DIV  = 3;
    final byte FUN_TIM  = 4;
    final byte FUN_POW  = 5;
    final byte FUN_SQRT = 6;

    byte currentFunction;
    DecimalFormat format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lastValue = "0";
        this.currentFunction = -1;

        this.getView();
        this.setEvents();

        screen.setTextSize(40);
        format = new DecimalFormat("#0.00");
    }

    private void getView(){
        this.screen =  ( TextView ) this.findViewById( R.id.screen );
        this.equals =  (Button) this.findViewById( R.id.equals );
        this.zero   =  (Button) findViewById( R.id.zero );
        this.one    =  (Button) findViewById( R.id.one );
        this.two    =  (Button) findViewById( R.id.two );
        this.three  =  (Button) findViewById( R.id.three );
        this.four   =  (Button) findViewById( R.id.four );
        this.five   =  (Button) findViewById( R.id.five );
        this.six    =  (Button) findViewById( R.id.six );
        this.seven  =  (Button) findViewById( R.id.seven );
        this.eight  =  (Button) findViewById( R.id.eight );
        this.nine   =  (Button) findViewById( R.id.nine );


        this.plus = this.findViewById( R.id.plus );
        this.min = this.findViewById( R.id.min );
        this.times = this.findViewById( R.id.times );
        this.divide = this.findViewById( R.id.divide );
        this.sqrt = this.findViewById( R.id.sqrt );
        this.pow = this.findViewById( R.id.pow );
        this.cancel = this.findViewById( R.id.cancel );
        this.ce = this.findViewById( R.id.ce );
        this.dot = this.findViewById( R.id.dot );

        operations = new Operation( );
    }

    private double executeOperator(double a, double b){
        double result = 0;
        switch (this.currentFunction){
            case (FUN_PLUS):
                result = a + b;
                break;
            case (FUN_MIN):
                result = a - b;
                break;
            case (FUN_DIV):
                if(b == 0){
                    Toast.makeText(getApplicationContext(), "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                }else {
                    result = a / b;
                }
                break;
            case (FUN_TIM):
                result = a * b;
                break;
        }

        return result;
    }

    private void executeFunction(byte fun){
        if (currentFunction == -1){
            lastValue = screen.getText().toString();
            screen.setText("0.0");
            currentFunction = fun;
        } else {
            screen.setText(format.format(
                    executeOperator(
                            Double.parseDouble(lastValue),
                            Double.parseDouble(screen.getText().toString())
                    )
            ));


        }
    }
/*
    equals,
    plus,
    min,
    times,
    divide,
    sqrt,
    pow,
    */
    private void setEvents() {
        this.pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                double value = Double.parseDouble(screen.getText().toString());
                screen.setText(format.format(Math.pow(value, 2)));
            }
        });

        this.sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                double value = Double.parseDouble(screen.getText().toString());
                if(value > 0){
                    screen.setText(format.format(Math.sqrt( value )));
                } else {
                    Toast.makeText(getApplicationContext(), "Número invalido", Toast.LENGTH_SHORT);
                }
            }
        });

        this.divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                executeFunction(FUN_DIV);
            }
        });

        this.times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                executeFunction(FUN_TIM);
            }
        });

        this.min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                executeFunction(FUN_MIN);
            }
        });

        this.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                executeFunction(FUN_PLUS);
            }
        });

        this.equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                screen.setText(Double.toString(
                        executeOperator(
                                Double.parseDouble(lastValue),
                                Double.parseDouble(screen.getText().toString())
                        )
                ));
                currentFunction = -1;
            }
        });

        this.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "0" );
            }
        });

        this.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "1" );
            }
        });

        this.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "2" );
            }
        });

        this.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "3" );
            }
        });

        this.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "4" );
            }
        });

        this.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "5" );
            }
        });

        this.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "6" );
            }
        });

        this.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "7" );
            }
        });

        this.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "8" );
            }
        });

        this.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "9" );
            }
        });

        this.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenValue( "." );
            }
        });

        this.ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayed = screen.getText().toString();
                if(displayed.length() > 1){
                    if(displayed.length() <= MIN_SCREEN_VALUE ){
                        screen.setTextSize(40);
                    }
                    screen.setText(displayed.substring(0, displayed.length()-1));
                } else {
                    screen.setText("0.0");
                    Toast.makeText(getApplicationContext(),"No exageres", Toast.LENGTH_SHORT).show();
                }
            }
        });


        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                screen.setText("0.0");
                lastValue = "0";
            }
        });


    }

    public void setScreenValue(String value){
        String displayed = screen.getText().toString();
        int valueLenght = displayed.length();

        displayed = (displayed.equals("0.0"))? "": displayed;

        if(valueLenght > MIN_SCREEN_VALUE){
            this.screen.setTextSize( 35 );
            if(valueLenght >= MAX_SCREEN_VALUE) {
                displayed = displayed.substring(1, 25);
            }
        }

        this.screen.setText( displayed + value );
    }

}
