package com.example.quizapp


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ConditionVariable
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*


class QuizQuestions : AppCompatActivity(),View.OnClickListener {

    private val TAG="Question size"

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswer:Int=0
    private var mUserName:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mQuestionList=Constants.getQuestions()



        setQuestion()
        tvOption1.setOnClickListener(this)
        tvOption2.setOnClickListener(this)
        tvOption3.setOnClickListener(this)
        tvOption4.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }
    private fun setQuestion(){

        val question= mQuestionList!![mCurrentPosition-1]
        setDefaultOptionsView()

        if (mCurrentPosition==mQuestionList!!.size){
            btnSubmit.text="Finish"
        }else{
            btnSubmit.text="SUBMIT"
        }

        pbProgressbar.progress=mCurrentPosition
        tvProgress.text="$mCurrentPosition"+"/"+pbProgressbar.max

        tvQuestion.text=question!!.question
        iv_Image.setImageResource(question.image)
        tvOption1.text= question.optionOne
        tvOption2.text=question!!.optionTwo
        tvOption3.text=question!!.optionThree
        tvOption4.text=question!!.optionFour
    }

    private fun setDefaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0,tvOption1)
        options.add(1,tvOption2)
        options.add(2,tvOption3)
        options.add(3,tvOption4)

        for (option in options){
            option.setTextColor(Color.parseColor("#4e342e"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvOption1->{
                selectedOptionView(tvOption1,1)
            }
            R.id.tvOption2->{
                selectedOptionView(tvOption2,2)
            }
            R.id.tvOption3->{
                selectedOptionView(tvOption3,3)
            }
            R.id.tvOption4->{
                selectedOptionView(tvOption4,4)
            }
            R.id.btnSubmit->{
                if (mSelectedOptionPosition==0){
                    mCurrentPosition++


                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }else ->{
                           // Toast.makeText(this,"Quiz Completed",Toast.LENGTH_SHORT).show()
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTION,mQuestionList!!.size)
                        startActivity(intent)
                        }
                    }
                }else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition==mQuestionList!!.size){
                        btnSubmit.text="Finish"
                    }else{
                        btnSubmit.text="Go To Next Question"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvOption1.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOption2.background=ContextCompat.getDrawable(this,drawableView)

            }
            3->{
                tvOption3.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tvOption4.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNumber:Int){
        setDefaultOptionsView()
        mSelectedOptionPosition=selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }
}

