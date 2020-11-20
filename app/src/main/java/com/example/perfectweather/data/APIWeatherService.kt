package com.example.perfectweather.data

import com.example.perfectweather.data.Responce.CurrentWeatherResponse
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "037e5d621130cbc603002a4721a1fa54"

//http://api.weatherstack.com/current?access_key=037e5d621130cbc603002a4721a1fa54&query=London

//то. что снизу находится- тупо не хочет чиниться ничем. Поэтому можешь сносить всё под чистую

interface    APIWeatherService {
    @GET("current")
    fun getCurrentWeather(
        @Query("query") request: String,
        @Query("lang") language: String = "en"
    ):  kotlinx.coroutines.Deferred<CurrentWeatherResponse>
    companion object{
        operator fun invoke(
            CorotineCallAdapterFactory: CallAdapter.Factory,
            GsonConverterFactory: Any
        ): Retrofit.Builder? {
            val requestInterceptor = okhttp3.Interceptor{ chain ->
                val url = chain.request()
                    .url
                .newBuilder()
                .addQueryParameter("key", API_KEY)
                .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CorotineCallAdapterFactory)
                .addConverterFactory(GsonConverterFactory.create())
        }
    }
}


