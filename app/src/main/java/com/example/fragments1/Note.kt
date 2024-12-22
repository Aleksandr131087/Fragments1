package com.example.fragments1

data class Note(
    val id: Int,
    val text: String,
    var isChecked: Boolean,
    val timestamp: String
)