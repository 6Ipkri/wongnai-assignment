package s.boonyapon.wongnaiassignment.api


import io.reactivex.Observable
import retrofit2.http.*
import s.boonyapon.wongnaiassignment.model.PublicCrypto

/**
 * API Declaration
 * call api with http GET method
 */

interface CoinrankingService {
    @GET("coins")
    fun getCoins(@Query("offset") offset: Int , @Query("limit") limit: Int) : Observable<PublicCrypto>

    @GET("coins")
    fun coinsSearch(@Query("ids") ids: String? ,@Query("slugs") slugs: String? ,@Query("symbols") symbols: String? ,@Query("prefix") prefix: String?) : Observable<PublicCrypto>

}