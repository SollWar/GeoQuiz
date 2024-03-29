package com.example.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView

private const val EXTRA_ANSWER_SHOWN = "com.example.geoquiz.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true"


class CheatActivity : AppCompatActivity() {

    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button

    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        showAnswerButton.setOnClickListener {

            val answerText = when {
                answerIsTrue ->  R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            setAnswerShownResult(true)
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object { // Данные которые ожидает получить activity, создаёт intent с данными необходимыми для activity
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent { // Что-то типо конструктора intent
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue) // В тело можно добавлять дополнительные данные
            }
        }
    }
}