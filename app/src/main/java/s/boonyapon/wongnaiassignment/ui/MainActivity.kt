package s.boonyapon.wongnaiassignment.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sum_long_card.view.*
import s.boonyapon.wongnaiassignment.R
import s.boonyapon.wongnaiassignment.api.ApiService
import s.boonyapon.wongnaiassignment.custom.Constant
import s.boonyapon.wongnaiassignment.model.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPublicCoinsData()

    }
    @SuppressLint("CheckResult")
    private fun getPublicCoinsData() {
        val observable =  ApiService.service().getCoins()
        observable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { pbCoins ->
                createCoinsList(pbCoins.data)
            }
    }

    private fun createCoinsList(data: Data){
        val coins = data.coins
        coins.forEachIndexed { index,coin ->
            val position = index + 1
            var card:View = if (index != 0 && position % 5 == 0) {
                shortCardUI(coin)
            }else{
                longCardUI(coin)
            }
            btcList.addView(card)

        }

    }

    private fun longCardUI(coin : Coins) : View {
        val card = LayoutInflater.from(this).inflate(R.layout.sum_long_card, null)
        val iconUrl = coin.iconUrl
        val btcName = coin.name
        val btcDescription = coin.description

        card.nameView.text = btcName
        card.describeView.text = btcDescription
        card.iconView.loadSvg(iconUrl)

        return card
    }

    private fun shortCardUI(coin : Coins) : View {
        val card = LayoutInflater.from(this).inflate(R.layout.sum_short_card, null)
        val iconUrl = coin.iconUrl
        val btcName = coin.name
        val btcId = coin.id
        card.nameView.text = btcName
        card.iconView.loadSvg(iconUrl)

        return card
    }

    private fun ImageView.loadSvg(url: String?) {
        GlideToVectorYou
            .init()
            .with(this.context)
            .load(Uri.parse(url), this)
    }


}