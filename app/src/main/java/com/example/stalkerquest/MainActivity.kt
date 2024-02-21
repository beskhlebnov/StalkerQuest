package com.example.stalkerquest

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.stalkerquest.Models.Question

class MainActivity : AppCompatActivity() {
    private lateinit var quest_img: ImageView
    private lateinit var quest_text: TextView
    private lateinit var number_quest: TextView
    private lateinit var button_one: Button
    private lateinit var button_two: Button
    private lateinit var button_three: Button
    private lateinit var button_four: Button
    private lateinit var button_next: ImageButton
    private lateinit var button_previous: ImageButton

    private val mQuestionBank = listOf(
        Question(R.string.quest_one, R.string.quest_1_answer_true, R.string.quest_1_answer_1, R.string.quest_1_answer_2, R.string.quest_1_answer_3, R.drawable.saharov),
        Question(R.string.quest_two, R.string.quest_2_answer_true, R.string.quest_2_answer_1, R.string.quest_2_answer_2, R.string.quest_2_answer_3, R.drawable.compass),
        Question(R.string.quest_three, R.string.quest_3_answer_true, R.string.quest_3_answer_1, R.string.quest_3_answer_2, R.string.quest_3_answer_3, R.drawable.merki_nashivka))

    private var mCurrentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quest_img = findViewById(R.id.quest_img)
        quest_text = findViewById(R.id.text_quest)
        number_quest = findViewById(R.id.number_quest)

        button_next = findViewById(R.id.button_next)
        button_previous = findViewById(R.id.button_previous)

        button_one = findViewById(R.id.button1)
        button_two = findViewById(R.id.button2)
        button_three = findViewById(R.id.button3)
        button_four = findViewById(R.id.button4)

        button_next.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            setQuestion()
        }
        button_previous.setOnClickListener {
            if (mCurrentIndex!=0){
            mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.size
            setQuestion()}
        }
        setQuestion()
    }
    private fun setQuestion(){
        number_quest.setText("Вопрос №${mCurrentIndex+1}")
        val button_list = listOf<Button>(button_one,button_two,button_three, button_four).toMutableList()
        val quest = mQuestionBank[mCurrentIndex]
        quest_img.setImageResource(quest.imgRestId)
        quest_text.setText(quest.textResId)

        val first = button_list.random()
        first.setText(quest.answerResId)
        first.setOnClickListener { Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show() }
        button_list.remove(first)

        val second = button_list.random()
        second.setText(quest.firstFailAnswerResId)
        second.setOnClickListener { Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show() }
        button_list.remove(second)

        val thrid = button_list.random()
        thrid.setText(quest.secondFailAnswerResId)
        thrid.setOnClickListener { Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show() }
        button_list.remove(thrid)

        val four = button_list.random()
        four.setText(quest.thridFailAnswerResId)
        four.setOnClickListener { Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show() }
        button_list.remove(four)
    }
}