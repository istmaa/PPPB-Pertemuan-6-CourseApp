package com.example.courseapp

import java.io.Serializable

data class Materi(
    val number: String,
    val title: String,
    val description: String,
    val overview: String,
    val concepts: List<String>,
    val practice: String,
    val summary: String,
    val imageResId: Int
) : Serializable
