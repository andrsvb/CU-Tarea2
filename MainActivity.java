package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    TextView x,y,z;
    String textoX, textoY, textoZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (TextView)findViewById(R.id.textView);
        y = (TextView)findViewById(R.id.textView2);
        z = (TextView)findViewById(R.id.textView3);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        textoX = "Aceleracion del eje x: " + event.values[0] + " m/s^2";
        textoY = "Aceleracion del eje y: " + event.values[1] + " m/s^2";
        textoZ = "Aceleracion del eje z: " + event.values[2] + " m/s^2";

        x.setText(textoX);
        y.setText(textoY);
        z.setText(textoZ);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
