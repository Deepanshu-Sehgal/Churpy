package com.datricle.churpy.api

import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URLEncoder
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Simple Spotify-like API helper using OkHttp.
 *
 * Note: This is a lightweight wrapper for the RapidAPI YouTube Music endpoint used
 * for demonstration. The function suspends and returns the raw response body as a
 * String, or null if the request failed.
 */
class Spotify {
    companion object {
        private val client = OkHttpClient()

        /**
         * Perform a search query against the demo API and return the response body.
         * This is a suspending function and should be called from a coroutine.
         *
         * @param query Search query text
         * @return Response body string on success, or null on failure
         */
        suspend fun search(query: String): String? = suspendCancellableCoroutine { cont ->
            val encoded = URLEncoder.encode(query, "utf-8")
            val request = Request.Builder()
                .url("https://youtube-music1.p.rapidapi.com/v2/search?query=$encoded")
                .get()
                .addHeader("X-RapidAPI-Key", "61abcd55d9mshb049ab6aae0db0bp1fb6a8jsn1099f981e3ba")
                .addHeader("X-RapidAPI-Host", "youtube-music1.p.rapidapi.com")
                .build()

            val call: Call = client.newCall(request)
            cont.invokeOnCancellation { call.cancel() }

            call.enqueue(object : okhttp3.Callback {
                override fun onFailure(call: Call, e: java.io.IOException) {
                    if (!cont.isCancelled) cont.resume(null)
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        val body = it.body?.string()
                        if (!cont.isCancelled) cont.resume(body)
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
