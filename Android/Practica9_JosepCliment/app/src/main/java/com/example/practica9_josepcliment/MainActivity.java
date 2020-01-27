package com.example.practica9_josepcliment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    NotificationCompat.Builder mBuilder;
    Button boton1;
    Button boton2;
    GestorNotificaciones gestorNotificaciones;
    public static final int ID_NOTIFICACION = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.b1);
        boton2 = (Button) findViewById(R.id.b2);

        gestorNotificaciones= new GestorNotificaciones(this);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mBuilder = gestorNotificaciones.getNotificacionPrimaria("Primaria", "Lechugueta no sap ni copiar");
                NotificationManagerCompat ncm = NotificationManagerCompat.from(getApplicationContext());
                ncm.notify(ID_NOTIFICACION, mBuilder.build());

            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mBuilder = gestorNotificaciones.getNotificacionSecundaria("Secundaria", "Lechugueta es un inutil");
                NotificationManagerCompat ncm = NotificationManagerCompat.from(getApplicationContext());
                ncm.notify(ID_NOTIFICACION, mBuilder.build());
            }
        });


    }


}
