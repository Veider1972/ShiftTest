package ru.veider.shifttest.data.repo.remote

import ru.veider.shifttest.data.repo.remote.dto.CardDto
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.veider.shifttest.domain.data.Resource
import java.io.IOException

class WebSource {

    private val webAPI =
            Retrofit.Builder().baseUrl("https://lookup.binlist.net").addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())
            )
                .client(createOkHttpClient(WeatherInterceptor())).build().create(WebApi::class.java)

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return okHttpClient.build()
    }

    inner class WeatherInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            Log.d("TAG", chain.request().toString())
            return chain.proceed(chain.request())
        }
    }

    suspend fun getCardInfo(number: Long): Resource<CardDto> =
            try {
                Resource.Success(webAPI.getCardData(number))
            } catch (e: Exception) {
                Resource.Error(e)
            }
}