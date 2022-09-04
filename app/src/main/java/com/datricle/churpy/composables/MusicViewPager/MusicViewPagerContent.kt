package com.datricle.churpy.composables.MusicViewPager

data class MusicViewPagerContent(
    val song_name: String,
    val singer_name: String,
)

fun createItems() = listOf(
    MusicViewPagerContent(song_name = "Summer High", singer_name = "AP Dhillon"),
    MusicViewPagerContent(song_name = "Summer High", singer_name = "AP Dhillon"),
    MusicViewPagerContent(song_name = "Summer High", singer_name = "AP Dhillon"),
    MusicViewPagerContent(song_name = "Summer High", singer_name = "AP Dhillon"),
    MusicViewPagerContent(song_name = "Summer High", singer_name = "AP Dhillon"),
    MusicViewPagerContent(song_name = "Summer High", singer_name = "AP Dhillon"),

    )
