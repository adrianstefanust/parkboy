package net.parkboy.parkboy

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import net.parkboy.parkboy.util.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*
import java.util.concurrent.TimeUnit

interface ApiServiceInterface {

    @POST("signup")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResponse>

    companion object Factory {
        val retrofit: Retrofit by lazy {
            retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .registerTypeAdapter(Date::class.java, DateTypeDesetializer())
                            .setLenient().create()
                    )
                )
                .baseUrl(Constant.BASE_USER_URL)
                .client(
                    OkHttpClient.Builder()
                        .readTimeout(120, TimeUnit.SECONDS)
                        .connectTimeout(120, TimeUnit.SECONDS)
                        .build()
                )
                .build()
        }

        fun create(): ApiServiceInterface {
            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}