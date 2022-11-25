package com.techyourchance.dagger2course.common.di.app

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class AppModule(private val application: Application) {

    @Provides
    fun providesApplication(): Application = application

    companion object {
        @AppScope
        @Provides
        fun providesRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @AppScope
        @Provides
        fun providesStackoverflowApi(
            retrofit: Retrofit
        ): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)
    }
}
