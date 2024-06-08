package com.lemien.thirdapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    var tvName : TextView?= null
    var name = ""

    var tvDateOfBirth : TextView? = null
    var dateOfBirth = ""

    var tvnumber : TextView? = null
    var number = ""

    var backButton : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        intent?.extras?.let {extras->
            //getting
             name = extras.getString("name")?:""
             dateOfBirth = extras.getString("dateOfBirth")?: ""
            number = extras.getString("number")?: ""
            println("name:  $name dateOfBirth: $dateOfBirth number: $number")
        }
        tvName = findViewById(R.id.enterYourName)
        tvName?.setText(name)

        tvDateOfBirth = findViewById(R.id.enterYourBirthDate)
        tvDateOfBirth?.setText(dateOfBirth)

        tvnumber = findViewById(R.id.enterYourNumber)
        tvnumber?.setText(number)

        backButton = findViewById(R.id.backButton)
        backButton?.setOnClickListener { var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}




    }
}
