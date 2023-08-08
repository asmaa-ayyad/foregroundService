package com.example.foregroundser.serv

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.finalproject.logindb.Login
import com.example.foregroundser.R
import com.example.foregroundser.app.MyApp.Companion.CHANNEL_ID
import com.example.foregroundser.login.Companion.msg

class MyService   : Service() {



    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("asmaa", "onCreate")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("asmaa", "onStartCommand")

        val i = Intent(this, Login::class.java)

        val pendingIntent = PendingIntent.getActivity(this,
            0, i , PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notificationCompat = NotificationCompat.Builder(this, CHANNEL_ID)
        notificationCompat.setContentTitle(getString(R.string.app_name))

    if(msg=="true"){

        notificationCompat.setContentText("is valid!")
   }else  if(msg=="false")   {

    notificationCompat.setContentText("is not valid!")}


        notificationCompat.setContentIntent(pendingIntent)
        notificationCompat.setSmallIcon(R.drawable.ic_baseline_perm_identity_24)
//
        Thread.sleep(7000)
        startForeground(1, notificationCompat.build())


        return START_NOT_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.e("asmaa", "onDestroy")

    }
}