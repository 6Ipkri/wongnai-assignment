package s.boonyapon.wongnaiassignment.api


import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*
import s.boonyapon.wongnaiassignment.model.PublicCrypto


interface CoinrankingService {
    @GET("coins")
    fun getCoins(@Query("offset") offset: Int , @Query("limit") limit: Int) : Observable<PublicCrypto>

}