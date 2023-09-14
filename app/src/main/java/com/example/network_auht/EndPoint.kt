package com.example.network_auht

import retrofit2.Response
import retrofit2.http.GET

interface EndPoint {
    @GET("/questions")
    suspend fun getQuiz(): Response<QuizData>
}