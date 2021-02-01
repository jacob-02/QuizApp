package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.username)
        Username.text = username

        var correct = intent.getIntExtra(Constants.correctAnswers, 0)
        val total = intent.getIntExtra(Constants.totalQuestion, 0)
        correct = total - correct

        score.text = "Your Score is $correct / $total"

        finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}