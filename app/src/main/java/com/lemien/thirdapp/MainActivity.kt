package com.lemien.thirdapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android .widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    var name: EditText? = null
    var number: EditText? = null
    var dateOfBirth: EditText? = null
    var college: EditText?= null
    var yes: RadioButton?= null
    var no: RadioButton?= null
    var check: Button?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = findViewById(R.id.enterYourName)
        number = findViewById(R.id.enterYourNumber)
        college = findViewById(R.id.college)
        dateOfBirth = findViewById(R.id.enterYourBirthDate)
        yes = findViewById(R.id.yes)
        no = findViewById(R.id.no)
        check = findViewById(R.id.button)

        check?.setOnClickListener {
            if(name?.text.toString().trim().isNullOrEmpty()){
                name?.error = "Enter your name"
            }else if(number?.text.toString().trim().isNullOrEmpty()){
                number?.error = "Enter your number"
            } else if((number?.text?.trim()?.length?:0) <10){
                number?.error = "Number should be valid and should be of 10 digits"
            } else if(dateOfBirth?.text?.toString()?.trim().isNullOrEmpty()){
                dateOfBirth?.error = "Enter your date of birth"
            }else {
                var a = 10
                var intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("name", name?.text?.toString()?.trim())
                intent.putExtra("number", number?.text?.toString()?.trim())
                intent.putExtra("dateOfBirth", dateOfBirth?.text?.trim()?.toString()?.toInt())
                startActivity(intent)


            }
        }
        yes?.setOnClickListener {
    Toast.makeText(this,"No is clicked", Toast.LENGTH_SHORT).show()
}
        no?.setOnCheckedChangeListener { buttonView, isChecked ->
    if(isChecked){
        college?.visibility = View.VISIBLE
    }else{
        college?.visibility = View.INVISIBLE
    }
}
}
}

