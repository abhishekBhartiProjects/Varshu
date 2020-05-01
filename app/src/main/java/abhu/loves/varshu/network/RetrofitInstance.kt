package abhu.loves.varshu.network

import abhu.loves.varshu.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    private fun create(baseUrl: String) {

        if(!::okHttpClient.isInitialized){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }


        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Synchronized
    private fun createSpreadsheetInstance() {
        create(BuildConfig.SPREADSHEET_API_ENDPOINT)
    }


    fun getInstance(): Retrofit {
        if(!::retrofit.isInitialized){
            createSpreadsheetInstance()
        }

        return retrofit
    }
}