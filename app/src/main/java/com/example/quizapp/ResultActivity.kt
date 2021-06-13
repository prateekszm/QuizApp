package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName=intent.getStringExtra(Constants.USER_NAME)
        tvName.text=userName

        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAnswer=intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        Score.text="Your score is $correctAnswer out of $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))

        }
    }
}