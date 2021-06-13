package com.example.quizapp

object Constants {
    const val USER_NAME:String="User_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CORRECT_ANSWER:String="correct_answer"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        //Question 1
        val que1=Question(
            1,
            "What country does this flag belong to?",
            R.drawable.nepal,
            "Nepal",
            "China",
            "Bangladesh",
            "Maldives",
            1
        )
        //Question 2
        val que2=Question(
            2,
            "What country does this flag belong to?",
            R.drawable.india,
            "Modi",
            "India",
            "Indian Ocean",
            "Bangladesh",
            2
        )
        //Question 3
        val que3=Question(
            3,
            "What country does this flag belong to?",
            R.drawable.china,
            "China",
            "India",
            "America",
            "Bangladesh",
            1
        )
        //Question 4
        val que4=Question(
            4,
            "What country does this flag belong to?",
            R.drawable.bangaladesh,
            "India",
            "China",
            "Bangladesh",
            "Pakistan",
            3
        )
        //Question 5
        val que5=Question(
            5,
            "What country does this flag belong to?",
            R.drawable.canada,
            "India",
            "China",
            "Canada",
            "South Korea",
            3
        )
        //Question 6
        val que6=Question(
            6,
            "What country does this flag belong to?",
            R.drawable.south_korea,
            "Bangladesh",
            "India",
            "China",
            "South Korea",
            4
        )
        //Question 7
        val que7=Question(
            7,
            "What country does this flag belong to?",
            R.drawable.russia,
            "Belgium",
            "Bahamas",
            "Barbados",
            "Russia",
            4
        )
        //Question 8
        val que8=Question(
            8,
            "What country does this flag belong to?",
            R.drawable.pakistan,
            "SwitzerLand",
            "Pakistan",
            "Japan",
            "America",
            2
        )
        //Question 9
        val que9=Question(
            9,
            "What terrorist does this flag belong to?",
            R.drawable.isis,
            "Ansar al-Islam",
            "al-Qaeda",
            "Lashkar-e-Taiba",
            "Islamic State of Iraq and the Levant",
            4
        )
        //Question 10
        val que10=Question(
            10,
            "What terrorist does this flag belong to?",
            R.drawable.taliban,
            "Hizb ut-Tahrir",
            "Taliban",
            "Communist Party of India",
            "Combat 18",
            2
        )
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)
        return questionList
    }
}