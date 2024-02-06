package br.com.cvj.discovr.util.ext.context.uber

import android.content.Context
import android.content.Intent
import android.net.Uri
import br.com.cvj.discovr.util.ext.context.types.ContextTypesExtAppActions

data class UberParams(val latitude: Double, val longitude: Double, val onError: ((e: Error) -> Unit)? = null)

class UberActions(private val context: Context) : ContextTypesExtAppActions<UberParams>() {
    private val onRedirectToPlayStoreDeepLink = {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=com.ubercab")
        ).apply {
            context.startActivity(this)
        }
    }
    override fun openApp(params: UberParams) {
        try {
            val uberUrl =
                "https://m.uber.com/ul/?action=setPickup&pickup=my_location&dropoff[latitude]=${params.latitude}&dropoff[longitude]=${params.longitude}"
            Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uberUrl)
                context.startActivity(this)
            }
        } catch (e: Error) {
            params.onError?.invoke(e) ?: run {
                onRedirectToPlayStoreDeepLink()
            }
        }
    }

    fun pickUpUber(latitude: Double = -23.5505199, longitude: Double = -46.6333094, onError: ((e: Error) -> Unit)? = null) {
        openApp(UberParams(latitude, longitude, onError))
    }
}

val Context.uberActions
    get() = UberActions(this)
