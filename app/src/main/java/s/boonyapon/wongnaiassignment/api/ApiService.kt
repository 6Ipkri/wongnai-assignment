package s.boonyapon.wongnaiassignment.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import s.boonyapon.wongnaiassignment.custom.Constant


object ApiService {
    private val TAG = "--ApiService"

    fun service() = Retrofit.Builder()
        .baseUrl(Constant.API_BASE_PATH)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(CoinrankingService::class.java)!!
}