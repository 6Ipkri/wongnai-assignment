package s.boonyapon.wongnaiassignment.custom

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.sum_long_card.view.*
import s.boonyapon.wongnaiassignment.R
import s.boonyapon.wongnaiassignment.model.Coins
import java.lang.Exception

/**
 * Custom recycle view adapter
 *
 */
class CoinsAdapter(private val items: ArrayList<Coins>): RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    // select layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when((viewType + 1) % 5 == 0){
            true -> ViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.sum_short_card, parent, false)
            )
            false -> ViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.sum_long_card, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    // set data in layout
    class ViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {
        fun bind(coin: Coins) {
            itemView.apply {
               try {
                   itemView.iconView.loadSvg(coin.iconUrl)
                   itemView.nameView.text = coin.name
                   itemView.describeView.text = coin.description

               }catch (e:Exception){}
            }
        }
        // load image url
        private fun ImageView.loadSvg(url: String?) {
            GlideToVectorYou
                .init()
                .with(this.context)
                .load(Uri.parse(url), this)
        }
    }

}