package com.example.sensordeproximidad;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;


public class acelerometro extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int whip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final TextView sonido = (TextView) findViewById(R.id.tvSonido);
        if (sensor == null) finish();
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                if (x < -5 && whip == 0) {
                    whip++;
                    sonido.setText("Sonido" + whip);
                    getWindow().getDecorView().setBackgroundColor(Color.GRAY);

                } else {
                    if (x > 5 && whip == 1) {
                        whip++;
                        sonido.setText("Sonido" + whip);
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    }
                }
                if (whip == 2) {
                    whip = 0;
                    sound();
                    sonido.setText("Sonido " + whip);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };


        star();
    }

    private void sound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.latigo1);
        mediaPlayer.start();
    }

    private void star() {

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop() {
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        star();
        super.onResume();
    }
}