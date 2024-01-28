package br.com.cvj.discovr.util

import androidx.annotation.DrawableRes
import br.com.cvj.discovr.R
import java.util.Locale

enum class AppLanguage(
    val locale: Locale,
    @DrawableRes val flagId: Int
) {
    English(locale = Locale.ENGLISH, flagId = R.drawable.english_flag),
    Italian(locale = Locale.ITALIAN, flagId = R.drawable.italian_flag);

    companion object {
        fun fromLocale(locale: Locale): AppLanguage {
            return values().find { it.locale == locale } ?: default()
        }

        fun default(): AppLanguage {
            return English
        }
    }
}
