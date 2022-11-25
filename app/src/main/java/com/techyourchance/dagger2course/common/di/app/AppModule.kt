package com.techyourchance.dagger2course.common.di.app

import android.app.Application
import com.techyourchance.dagger2course.common.di.RetrofitQuestions
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named

@Module
class AppModule(private val application: Application) {

    @Provides
    fun providesApplication(): Application = application

    companion object {
        @AppScope
        @Provides
        @RetrofitQuestions
        fun providesRetrofit(urlProvider: UrlProvider): Retrofit {
            return Retrofit.Builder()
                .baseUrl(urlProvider.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @AppScope
        @Provides
        @Named("retrofit2")
        fun providesRetrofit2(urlProvider: UrlProvider): Retrofit {
            return Retrofit.Builder()
                .baseUrl(urlProvider.getBaseUrl2())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @AppScope
        @Provides
        fun providesUrlProvider(): UrlProvider = UrlProvider()

        @AppScope
        @Provides
        fun providesStackoverflowApi(
            @RetrofitQuestions
            retrofit: Retrofit
        ): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)
    }
}
