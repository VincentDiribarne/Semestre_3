package com.example.td3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.List;

public class CapteurManager implements SensorEventListener {
    public MainActivity context;
    public SensorManager sensorManager;
    public Sensor lightSensor;
    public Sensor acceSensor;
    public AlertDialog alertDialog;

    public CapteurManager(MainActivity pContext) {
        context = pContext;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        acceSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    public void afficheCapteur(int type) {
        List<Sensor> sensors = sensorManager.getSensorList(type);
        for (Sensor s : sensors) {
            Log.i("capteur", s.getName());
        }
    }

    public void verification(Sensor diffSensor, int type) {
        if (!sensorManager.getSensorList(type).isEmpty()) {
            diffSensor = sensorManager.getDefaultSensor(type);
        } else {
            AlertDialog();
        }
    }

    public void AlertDialog() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Attention");
        alertDialog.setMessage("Vous ne possedez pas les capteurs disponibles pour utiliser cette application");

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> context.bureau());
        alertDialog.show();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lux = event.values[0];
            context.lumiereTextView.setText("Lumiere : " + lux);
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float newX = context.imageViewBille.getX() - event.values[0] * 5;
            float newY = context.imageViewBille.getY() + event.values[1] * 5;
            float width = context.layout.getWidth();
            float height = context.layout.getHeight();

            float heightBoule = context.imageViewBille.getHeight();
            float widthBoule = context.imageViewBille.getWidth();

            while (newX <= 0) {
                newX = newX + 25;
            }

            while (newY <= 0) {
                newY = newY +25;
            }

            while (newY >= height - heightBoule) {
                newY = newY -25;
            }

            while (newX >= width - widthBoule) {
                newX = newX -25;
            }

            context.imageViewBille.setX(newX);
            context.imageViewBille.setY(newY);

            Log.e("position", "posX=" + context.imageViewBille.getX() + "poxY=" + context.imageViewBille.getY());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void start() {
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, acceSensor, SensorManager.SENSOR_DELAY_GAME);
        afficheCapteur(Sensor.TYPE_LIGHT);
        afficheCapteur(Sensor.TYPE_ACCELEROMETER);
    }

    public void stop() {
        sensorManager.unregisterListener(this, lightSensor);
        sensorManager.unregisterListener(this, acceSensor);
        afficheCapteur(Sensor.TYPE_LIGHT);
        afficheCapteur(Sensor.TYPE_ACCELEROMETER);
    }
}
