package com.example.network_auht

import okhttp3.Interceptor
import okhttp3.Response

class AuhtInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originaRuquest = chain.request()
        val newRequest = originaRuquest.newBuilder()
            .addHeader("X-RapidAPI-Key", "63e15c4651msh9b0287251901dd4p13f599jsn35d17ac0716d")
            .addHeader("X-RapidAPI-Host", "quiz26.p.rapidapi.com")
            .build()
        return chain.proceed(newRequest)

    }

}