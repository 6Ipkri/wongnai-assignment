package s.boonyapon.wongnaiassignment.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import s.boonyapon.wongnaiassignment.R
import s.boonyapon.wongnaiassignment.api.ApiService


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPublicCoinsData()

    }

    @SuppressLint("CheckResult")
    private fun getPublicCoinsData() {
        val observable = ApiService.service().getCoins()
        observable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { pbCoins ->

            }
    }

}