package com.datricle.churpy.composables.BottomNavigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import com.datricle.churpy.R

sealed class BottomNavItems(
    @StringRes val name: Int,
    val route: String,
    val icon: Int,
) {
    object Music : BottomNavItems(
        name = R.string.music,
        route = Screen.Music.route,
        icon = R.drawable.ic_outline_audio_file_24,
    )

    object ForYou : BottomNavItems(
        name = R.string.for_you,
        route = Screen.ForYou.route,
        icon = R.drawable.ic_headphones,
    )

    object Me : BottomNavItems(
        name = R.string.me,
        route = Screen.Me.route,
        icon = R.drawable.ic_me,
    )
}
