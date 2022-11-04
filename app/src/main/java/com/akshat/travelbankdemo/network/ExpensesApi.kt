package com.akshat.travelbankdemo.network

import com.akshat.travelbankdemo.BuildConfig
import com.akshat.travelbankdemo.model.ExpenseResponse1Item
import com.akshat.travelbankdemo.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface ExpensesApi {

    @GET
    suspend fun getExpensesData(@Url url: String): Response<List<ExpenseResponse1Item>>

    companion object {

        operator fun invoke(): ExpensesApi {

            //For logging network requests.
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.base_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ExpensesApi::class.java)
        }
    }
}