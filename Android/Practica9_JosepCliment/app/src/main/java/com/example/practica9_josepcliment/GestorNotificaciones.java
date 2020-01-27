package com.example.practica9_josepcliment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class GestorNotificaciones {
    public static final String ID_CANAL_PRIMARIO = "com.simarro.pruebanotificaciones.canal_primario";
    public static final String ID_CANAL_SECUNDARIO = "com.simarro.pruebanotificaciones.canal_secundario";
    public static final String NOMBRE_CANAL_PRIMARIO = "CANAL PRIMARIO";
    public static final String NOMBRE_CANAL_SECUNDARIO = "CANAL SECUNDARIO";

    private Context mContext;

    public GestorNotificaciones(Context mContext) {
        this.mContext = mContext;
        crearCanales();
    }

    private void crearCanales() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            NotificationManager mManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel canalPrimario;
            canalPrimario = new NotificationChannel(ID_CANAL_PRIMARIO, NOMBRE_CANAL_PRIMARIO, NotificationManager.IMPORTANCE_HIGH);
            canalPrimario.enableLights(true);
            canalPrimario.enableVibration(true);
            canalPrimario.setLightColor(Color.GREEN);
            canalPrimario.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            mManager.createNotificationChannel(canalPrimario);


            NotificationChannel canalSecundario;
            canalSecundario = new NotificationChannel(ID_CANAL_SECUNDARIO, NOMBRE_CANAL_SECUNDARIO, NotificationManager.IMPORTANCE_HIGH);
            canalSecundario.enableLights(true);
            canalSecundario.enableVibration(true);
            canalSecundario.setLightColor(Color.GREEN);
            canalSecundario.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            mManager.createNotificationChannel(canalSecundario);

        }
    }

    public NotificationCompat.Builder getNotificacionPrimaria(String titulo, String cuerpo){
        NotificationCompat.Builder mBuilder= null;

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            mBuilder = new NotificationCompat.Builder(mContext, ID_CANAL_PRIMARIO);
        }else{
            mBuilder = new NotificationCompat.Builder(mContext, null);
        }

        mBuilder.setContentTitle(titulo)
                .setContentText(cuerpo)
                .setSmallIcon(R.drawable.stan)
                .setLargeIcon((((BitmapDrawable)mContext.getDrawable(R.drawable.stan)).getBitmap()))
                .setAutoCancel(true);
        return mBuilder;

    }


    public NotificationCompat.Builder getNotificacionSecundaria(String titulo, String cuerpo){
        NotificationCompat.Builder mBuilder= null;

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            mBuilder = new NotificationCompat.Builder(mContext, ID_CANAL_SECUNDARIO);
        }else{
            mBuilder = new NotificationCompat.Builder(mContext, null);
        }

        mBuilder.setContentTitle(titulo)
                .setContentText(cuerpo)
                .setSmallIcon(R.drawable.stan)
                .setLargeIcon((((BitmapDrawable)mContext.getDrawable(R.drawable.stan)).getBitmap()))
                .setAutoCancel(true);
        return mBuilder;

    }
}
