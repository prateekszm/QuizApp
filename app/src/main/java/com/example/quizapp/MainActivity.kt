package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val actionBar=supportActionBar
//        actionBar?.hide()
        //window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val btnStart:Button=findViewById(R.id.btnStart)
        val etEditText:EditText=findViewById(R.id.etEditText)
        btnStart.setOnClickListener{
            if(etEditText.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }else{
                val intent:Intent=Intent(this,QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME,etEditText.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}