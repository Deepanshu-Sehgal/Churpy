package com.datricle.churpy.api

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder

class Spotify {
    companion object {
        private val client = OkHttpClient()

        // Asynchronous search helper. Caller provides a query and a callback which
        // receives the response body as a String (or null on failure).
        fun search(query: String, callback: (String?) -> Unit) {
            val encoded = URLEncoder.encode(query, "utf-8")
            val request = Request.Builder()
                .url("https://youtube-music1.p.rapidapi.com/v2/search?query=$encoded")
                .get()
                .addHeader("X-RapidAPI-Key", "61abcd55d9mshb049ab6aae0db0bp1fb6a8jsn1099f981e3ba")
                .addHeader("X-RapidAPI-Host", "youtube-music1.p.rapidapi.com")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    callback(null)
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        val body = it.body?.string()
                        callback(body)
                    }
                }
            })
        }
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
