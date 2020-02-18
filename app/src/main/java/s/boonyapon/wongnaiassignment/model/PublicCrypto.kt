package s.boonyapon.wongnaiassignment.model

import com.google.gson.annotations.SerializedName

data class PublicCrypto(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: Data
)

data class Data(
    @SerializedName("stats") val stats: Stats,
    @SerializedName("base") val base: Base,
    @SerializedName("coins") val coins: ArrayList<Coins>
    )

data class Stats(
    @SerializedName("total") val total: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("order") val order: String,
    @SerializedName("base") val base: String,
    @SerializedName("totalMarkets") val totalMarkets: Int,
    @SerializedName("totalExchanges") val totalExchanges: Int,
    @SerializedName("totalMarketCap") val totalMarketCap: Double,
    @SerializedName("total24hVolume") val total24hVolume: Double
    )
data class Base(
    @SerializedName("symbol") val symbol: String,
    @SerializedName("sign") val sign: String
    )
data class Coins(
    @SerializedName("id") val id: Int,
    @SerializedName("uuid") val uuid: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("color") val color: String,
    @SerializedName("iconType") val iconType: String,
    @SerializedName("iconUrl") val iconUrl: String,
    @SerializedName("websiteUrl") val websiteUrl: String,
    @SerializedName("socials") val socials: Array<Social>,
    @SerializedName("links") val links: Array<Link>,
    @SerializedName("confirmedSupply") val confirmedSupply: Boolean,
    @SerializedName("numberOfMarkets") val numberOfMarkets: Int,
    @SerializedName("numberOfExchanges") val numberOfExchanges: Int,
    @SerializedName("type") val type: String,
    @SerializedName("volume") val volume: Long,
    @SerializedName("marketCap") val marketCap: Long,
    @SerializedName("price") val price: String,
    @SerializedName("circulatingSupply") val circulatingSupply: Double,
    @SerializedName("totalSupply") val totalSupply: Double,
    @SerializedName("approveSupply") val approveSupply: Int,
    @SerializedName("firstSeen") val firstSeen: Long,
    @SerializedName("change") val chane: Float,
    @SerializedName("rank") val rank: Int,
    @SerializedName("history") val history: Array<String>,
    @SerializedName("allTimeHigh") val allTimeHigh: AllTimeHigh,
    @SerializedName("penalty") val penalty: Boolean
    )
data class  Social(
    @SerializedName("name") val socials: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
    )
data class  Link(
    @SerializedName("name") val socials: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)
data class AllTimeHigh(
    @SerializedName("price") val price: String,
    @SerializedName("timestamp") val timestamp: Long


    )