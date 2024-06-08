package com.lemien.thirdapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    var name: EditText? = null
    var enterCollege: EditText? = null
    var check: Button? = null
    var move: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        name = findViewById(R.id.enterYourName)
        enterCollege = findViewById(R.id.enterCollege)
        check = findViewById(R.id.check)
        move = findViewById(R.id.move)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        check?.setOnClickListener {
            if (name?.text?.trim().isNullOrEmpty()) {
                name?.error = "Enter the name"
            } else if (enterCollege?.text.isNullOrEmpty()) {
                enterCollege?.error = "Enter the college name"
            } else {
                Toast.makeText(this, "Button is pressed ${name?.text}", Toast.LENGTH_SHORT).show()




            }
        }
        move?.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
