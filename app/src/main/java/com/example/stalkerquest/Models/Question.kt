package com.example.stalkerquest.Models

data class Question (val textResId: Int,
                     val answerResId: Int,
                     val firstFailAnswerResId: Int,
                     val secondFailAnswerResId: Int,
                     val thridFailAnswerResId: Int,
                     val imgRestId: Int)
