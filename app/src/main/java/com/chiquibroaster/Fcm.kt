package com.chiquibroaster

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*

class Fcm: FirebaseMessagingService() {
    override fun onNewToken(s: String) {
        super.onNewToken(s)

        Log.e("token", "mi token es: $s")

    }



    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.from

        if (remoteMessage.data.isNotEmpty()) {

            val titulo = remoteMessage.data["titulo"].toString()
            val detalle = remoteMessage.data["detalle"].toString()

            mayorqueoreo(titulo, detalle)

        }

    }

    private fun mayorqueoreo(titulo: String, detalle: String) {

        val id = "mensaje"

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(this, id)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val nc = NotificationChannel(id, "nuevo", NotificationManager.IMPORTANCE_HIGH)
            nc.setShowBadge(true)
            nm.createNotificationChannel(nc)
        }
        builder.setAutoCancel(true)
            .setWhen(System.currentTimeMillis())
            .setContentTitle(titulo)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText(detalle)
            .setContentIntent(clickNoti())
            .setContentInfo("nuevo")
        val random = Random()
        val idNotify = random.nextInt(8000)

        nm.notify(idNotify, builder.build())
    }

    private fun clickNoti(): PendingIntent {
        val nf = Intent(applicationContext, AuthActivity::class.java)
        nf.putExtra("color", "rojo")
        nf.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_SINGLE_TOP
        return PendingIntent.getActivity(this, 0, nf, 0)
    }
}



