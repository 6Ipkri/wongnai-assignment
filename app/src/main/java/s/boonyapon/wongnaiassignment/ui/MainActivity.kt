package s.boonyapon.wongnaiassignment.ui

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import s.boonyapon.wongnaiassignment.R
import s.boonyapon.wongnaiassignment.api.ApiService
import s.boonyapon.wongnaiassignment.custom.CoinsAdapter
import s.boonyapon.wongnaiassignment.model.*

class MainActivity : AppCompatActivity() {
    var visibleItemCount = 0
    var pastVisibleItemCount = 0
    var totalItemCount = 0
    var loaded = false
    var offset = 0
    var list:ArrayList<Coins> = ArrayList()
    lateinit var adapter:CoinsAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        btcList.layoutManager = layoutManager
        btcList.setHasFixedSize(true)
        pullRefresh()
        getPublicCoinsData(offset)


    }
    @SuppressLint("CheckResult")
    private fun getPublicCoinsData(offset : Int) {
        val observable =  ApiService.service().getCoins(offset,10)
        observable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { pbCoins ->
                loaded = true
                setCoinsAdapter(pbCoins.data.coins)
            }
    }

    private fun pullRefresh(){

        swipe_refresh_layout.setOnRefreshListener {
                list.clear()
                offset = 0
                getPublicCoinsData(offset)
                adapter.notifyDataSetChanged()
                swipe_refresh_layout.isRefreshing = false
        }
        swipe_refresh_layout.setColorSchemeColors(Color.parseColor("#008744"),Color.parseColor("#0057e7"),Color.parseColor("#d62d20"))

    }

    private fun setCoinsAdapter(coins:ArrayList<Coins>?){
        if(list.size == 0){
            list = coins!!
            adapter = CoinsAdapter(list)
            btcList.adapter = adapter
        }else{
            val currentPosition = (btcList.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            list.addAll(coins!!)
            adapter.notifyDataSetChanged()
            btcList.scrollToPosition(currentPosition)
        }
        btcList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if(dy > 0){
                        visibleItemCount = layoutManager.childCount
                        totalItemCount = layoutManager.itemCount
                        pastVisibleItemCount = (btcList.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                        if(loaded){
                            if((visibleItemCount + pastVisibleItemCount) >= totalItemCount){
                                loaded = false
                                offset++
                                getPublicCoinsData(offset)
                            }
                        }
                    }
            }
        })

    }

}