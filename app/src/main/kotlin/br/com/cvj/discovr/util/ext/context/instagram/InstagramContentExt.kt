package br.com.cvj.discovr.util.ext.context.instagram

import android.content.Context
import android.content.Intent
import android.net.Uri
import br.com.cvj.discovr.util.ext.context.types.ContextTypesExtAppActions

data class InstagramParams(val username: String, val onError: ((e: Error) -> Unit)? = null)
class InstagramActions(private val context: Context) : ContextTypesExtAppActions<InstagramParams>() {
    override fun openApp(params: InstagramParams) {
        val instagramUrl = "https://www.instagram.com/${params.username}"
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(instagramUrl)
        }

        try {
            context.startActivity(intent)
        } catch (e: Error) {
            params.onError?.invoke(e) ?: run {
                Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl)).apply {
                    context.startActivity(this)
                }
            }
        }
    }

    fun openAccount(username: String) {
        openApp(InstagramParams(username))
    }
}

val Context.instagramActions
    get() = InstagramActions(this)
