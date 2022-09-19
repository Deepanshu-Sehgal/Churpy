package com.datricle.churpy.api

import okhttp3.OkHttpClient
import okhttp3.Request

class Spotify{


    companion object{
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://youtube-music1.p.rapidapi.com/v2/search?query=diljit%20dosanj")
            .get()
            .addHeader("X-RapidAPI-Key", "61abcd55d9mshb049ab6aae0db0bp1fb6a8jsn1099f981e3ba")
            .addHeader("X-RapidAPI-Host", "youtube-music1.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
    }


}

/*
class RetrofitClient2(context: Context) : OkHttpClient() {

    private var mContext:Context = context
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
            client.addInterceptor(logging)
            client.interceptors().add(AddCookiesInterceptor(mContext))

            val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(Constants.URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client.build())
                    .build()
            }
            return retrofit
        }
}*/
