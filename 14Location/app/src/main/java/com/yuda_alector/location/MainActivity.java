package com.yuda_alector.location;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;

    private TextView tv_latitude;
    private TextView tv_longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv_latitude = this.findViewById(R.id.latitude);
        this.tv_longitude = this.findViewById(R.id.longitude);

        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    public void getLocation (View view){
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            this.fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {

                    if (location != null) {
                        tv_latitude.setText(Double.toString(location.getLatitude()));
                        tv_longitude.setText(Double.toString(location.getLongitude()));

                        Toast.makeText(getApplicationContext(), location.getLatitude() + " --- " + location.getLatitude() , Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "No tenemos ubicación ", Toast.LENGTH_LONG).show();
                        tv_latitude.setText("Nel");
                        tv_longitude.setText("No hay");
                    }
                }
            });
        }
    }

}
