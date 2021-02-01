package com.example.quizapp

object Constants
{
    const val username = "username"
    const val totalQuestion = "totalquestions"
    const val correctAnswers = "correctanswers"

    fun getQuestions(): ArrayList<MyQuestions>
    {
        val questionList = ArrayList<MyQuestions>()

        val q1 = MyQuestions(1,"Which country is this?", R.drawable.germany, "France", "Israel", "Belgium", "Germany",4)
        questionList.add(q1)

        val q2 = MyQuestions(2,"Which country is this?", R.drawable.china, "Russia", "China", "United States Of America", "Australia",2)
        questionList.add(q2)

        val q3 = MyQuestions(3,"Which country is this?", R.drawable.egypt, "Pakistan", "South Africa", "Egypt", "Germany",3)
        questionList.add(q3)

        val q4 = MyQuestions(4,"Which country is this?", R.drawable.france, "Philippines", "Austria", "France", "Bangladesh",3)
        questionList.add(q4)

        val q5 = MyQuestions(5,"Which country is this?", R.drawable.india, "India", "Iran", "Brazil", "New Guinea",1)
        questionList.add(q5)

        val q6 = MyQuestions(6,"Which country is this?", R.drawable.mexico, "Vietnam", "Mexico", "Argentina", "Singapore",2)
        questionList.add(q6)

        val q7 = MyQuestions(7,"Which country is this?", R.drawable.russia, "Russia", "New Zealand", "Canada", "China",1)
        questionList.add(q7)

        val q8 = MyQuestions(8,"Which country is this?", R.drawable.singapore, "Malaysia", "Indonesia", "Maldives", "Singapore",4)
        questionList.add(q8)

        val q9 = MyQuestions(9,"Which country is this?", R.drawable.uk, "Scotland", "Poland", "Chile", "United Kingdom",4)
        questionList.add(q9)

        val q10 = MyQuestions(10,"Which country is this?", R.drawable.usa, "France", "Japan", "United States Of America", "Finland",3)
        questionList.add(q10)

        return questionList
    }
}