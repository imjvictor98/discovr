package br.com.cvj.discovr.util.ext

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.pickUpUber(
    destinationLatitude: Double = 15.8351429,
    destinationLongitude: Double = -47.9234168,
    onError: ((error: Error) -> Unit)? = null
) {
    try {
        val uberUrl = "https://m.uber.com/ul/?action=setPickup&pickup=my_location&dropoff[latitude]=$destinationLatitude&dropoff[longitude]=$destinationLongitude"
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(uberUrl)
        }
        startActivity(intent)
    } catch (e: Error) {
        onError?.invoke(e)
    }
}
