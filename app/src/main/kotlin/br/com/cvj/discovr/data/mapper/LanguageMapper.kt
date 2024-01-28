package br.com.cvj.discovr.data.mapper

import br.com.cvj.discovr.util.AppLanguage
import java.util.Locale

fun Locale.toAppLanguage(): AppLanguage {
    // removes country code and variants if present
    val localeLanguageOnly = Locale.forLanguageTag(this.language)

    return AppLanguage.fromLocale(localeLanguageOnly)
}
