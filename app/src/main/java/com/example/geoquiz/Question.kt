package com.example.geoquiz

import androidx.annotation.StringRes

// ключевое слово data указывает что класс предназначен для хранения данных
data class Question(@StringRes val textResId: Int, val answer: Boolean)