package com.example.perfectweather

import com.example.perfectweather.Model.ModelWeather
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "037e5d621130cbc603002a4721a1fa54"// поставь потом свой API который с сайта https://openweathermap.org/current - это сайт давал препод

//http://api.weatherstack.com/current?access_key=037e5d621130cbc603002a4721a1fa54&query=London

//api.openweathermap.org/data/2.5/weather?lang=ru&q=Бронницы&appid=cab132c14b316849c8721f3eeb1b4129

//то. что снизу находится- тупо не хочет чиниться ничем. Поэтому можешь сносить всё под чистую

interface APIWeatherService {
    @GET("weather?&appid=$API_KEY")
    fun getCurrentWeather(
        @Query("q") request: String,
        @Query("lang") language: String = "ru"
    ):Callback<ModelWeather>

    companion object {
        operator fun invoke(): Retrofit? {
            return Retrofit.Builder()
                .baseUrl("api.openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build()

        }
    }
}


