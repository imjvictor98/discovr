package br.com.cvj.discovr.util

import androidx.annotation.StringRes
import br.com.cvj.discovr.R

enum class AppTheme(
    @StringRes val translationId: Int
) {
    FollowSystem(R.string.system_default),
    Light(R.string.light_theme),
    Dark(R.string.dark_theme);

    companion object {
        fun default(): AppTheme {
            return FollowSystem
        }
    }
}
