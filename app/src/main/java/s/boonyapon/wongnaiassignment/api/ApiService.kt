package s.boonyapon.wongnaiassignment.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import s.boonyapon.wongnaiassignment.custom.Constant

/**
 * Create service for call Coinranking API by retrofit2
 * and create custom service
 */


object ApiService {
    fun service() = Retrofit.Builder()
        .baseUrl(Constant.API_BASE_PATH)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(CoinrankingService::class.java)!!
}