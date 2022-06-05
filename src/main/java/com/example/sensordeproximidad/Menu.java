package com.example.sensordeproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

Button  Proximidad;
Button Acelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button bProximidad = (Button)findViewById(R.id.bProximidad);
        bProximidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, proximidad2.class);
                startActivity(i);
            }
        });
         Button baacelerometro = (Button) findViewById(R.id.bAceleometro);
        baacelerometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent A= new Intent(Menu.this,acelerometro.class);
                startActivity(A);
            }
        });


    }

        }

