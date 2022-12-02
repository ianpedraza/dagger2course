package com.techyourchance.dagger2course.common.di.app

import com.techyourchance.dagger2course.common.di.RetrofitQuestions
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    companion object {
        @AppScoped
        @Provides
        @RetrofitQuestions
        fun providesRetrofit(urlProvider: UrlProvider): Retrofit {
            return Retrofit.Builder()
                .baseUrl(urlProvider.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @AppScoped
        @Provides
        @Named("retrofit2")
        fun providesRetrofit2(urlProvider: UrlProvider): Retrofit {
            return Retrofit.Builder()
                .baseUrl(urlProvider.getBaseUrl2())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @AppScoped
        @Provides
        fun providesUrlProvider(): UrlProvider = UrlProvider()

        @AppScoped
        @Provides
        fun providesStackoverflowApi(
            @RetrofitQuestions
            retrofit: Retrofit
        ): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)
    }
}
