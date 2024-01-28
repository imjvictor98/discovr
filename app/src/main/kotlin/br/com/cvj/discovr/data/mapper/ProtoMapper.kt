package br.com.cvj.discovr.data.mapper

import br.com.cvj.discovr.ProtoUserPreferences.ProtoAppTheme
import br.com.cvj.discovr.util.AppTheme

fun AppTheme.toProto(): ProtoAppTheme = when (this) {
    AppTheme.FollowSystem -> ProtoAppTheme.FOLLOW_SYSTEM
    AppTheme.Light -> ProtoAppTheme.LIGHT
    AppTheme.Dark -> ProtoAppTheme.DARK
}

fun ProtoAppTheme.toLocal(): AppTheme = when (this) {
    ProtoAppTheme.LIGHT -> AppTheme.Light
    ProtoAppTheme.DARK -> AppTheme.Dark
    ProtoAppTheme.UNRECOGNIZED, ProtoAppTheme.FOLLOW_SYSTEM -> AppTheme.FollowSystem
}
