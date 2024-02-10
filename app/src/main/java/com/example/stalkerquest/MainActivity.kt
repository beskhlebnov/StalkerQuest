package com.example.stalkerquest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var button_one: Button
    private lateinit var button_two: Button
    private lateinit var button_three: Button
    private lateinit var button_four: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_one = findViewById(R.id.button1)
        button_one.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, R.string.correct,Toast.LENGTH_SHORT).show()
        })

        button_two = findViewById(R.id.button2)
        button_two.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, R.string.incorrect,Toast.LENGTH_SHORT).show()
        })

        button_three = findViewById(R.id.button3)
        button_three.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, R.string.incorrect,Toast.LENGTH_SHORT).show()
        })

        button_four = findViewById(R.id.button4)
        button_four.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, R.string.incorrect,Toast.LENGTH_SHORT).show()
        })

    }
}