package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity(), View.OnClickListener{

    private var userCurrent = 1
    private var userquestionsList: ArrayList<MyQuestions>? = null
    private var userSelectedoption = 0
    private var no_correct_options = 0
    var userusername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        userusername = intent.getStringExtra(Constants.username)

        defaultView()

        userquestionsList = Constants.getQuestions()

        setQuestion()

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        submit.setOnClickListener(this)
    }

    private fun setQuestion()
    {
        val question = userquestionsList!![userCurrent - 1]

        defaultView()

        if(userCurrent == userquestionsList!!.size)
            submit.text = "FINISH"
        else
            submit.text = "SUBMIT"

        progression.progress = userCurrent
        progress.text = "$userCurrent" + "/" + progression.max

        theQuestion.text = question!!.questions

        images.setImageResource(question.img)

        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
    }

    private fun defaultView()
    {
        val options = ArrayList<TextView>()

        options.add(0,option1)
        options.add(1,option2)
        options.add(2,option3)
        options.add(3,option4)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#FFFFFFFF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    private fun selectedOption(textView: TextView, selectedOption: Int)
    {
        defaultView()
        userSelectedoption = selectedOption

        textView.setTextColor(Color.parseColor("#FFFFFFFF"))
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)

    }

    private fun answerOption(answer: Int, drawableView: Int)
    {
        when(answer)
        {
            1 -> {
                option1.typeface = Typeface.DEFAULT_BOLD
                option1.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                option2.typeface = Typeface.DEFAULT_BOLD
                option2.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                option3.typeface = Typeface.DEFAULT_BOLD
                option3.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                option4.typeface = Typeface.DEFAULT_BOLD
                option4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    override fun onClick(v: View?)
    {
        when(v?.id)
        {
            R.id.option1 -> {
                selectedOption(option1, 1)
            }

            R.id.option2 -> {
                selectedOption(option2, 2)
            }

            R.id.option3 -> {
                selectedOption(option3, 3)
            }

            R.id.option4 -> {
                selectedOption(option4, 4)
            }

            R.id.submit -> {
                if (userSelectedoption == 0)
                {
                    userCurrent++

                when {
                    userCurrent <= userquestionsList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                                val intent = Intent(this, Result::class.java)
                                intent.putExtra(Constants.username, userusername)
                                intent.putExtra(Constants.correctAnswers, no_correct_options)
                                intent.putExtra(Constants.totalQuestion, userquestionsList!!.size)
                                startActivity(intent)
                        }
                    }

                }

                else {
                    val question = userquestionsList?.get(userCurrent - 1)

                    if (question!!.correct != userSelectedoption) {
                        answerOption(userSelectedoption, R.drawable.wrong_option_bg)
                        no_correct_options++
                    }

                    answerOption(question.correct, R.drawable.correct_option_bg)

                    if (userCurrent == userquestionsList!!.size)
                        submit.text = "FINISH"
                    else
                        submit.text = "NEXT QUESTION"

                    userSelectedoption = 0
                }
            }
        }
    }
}