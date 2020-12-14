package com.jokesapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jokesapp.R
import com.jokesapp.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_item_layout.view.*

class RvAdapter(private val resultList: ArrayList<Result>) : RecyclerView.Adapter<RvAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(resultList.get(position))
    }

    fun update(results: List<Result>) {
        resultList.clear()
        resultList.addAll(results)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val value = itemView.tvValue
        private val url = itemView.tvUrl
        private val iconUrl = itemView.imgIconUrl

        fun bind(result: Result) {
            value.text = result.value
            url.text = result.url

            Picasso.with(itemView.context)
                .load(result.iconUrl)
                .into(iconUrl)

            /*itemView.setOnClickListener({
                val detailIntent = Intent(itemView.context, DetailActivity::class.java).putExtra("summary", result.summary_short)
                val imageViewPair = Pair<View, String>(iconUrl, itemView.resources.getString(R.string.transition_imagem))
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, imageViewPair)

                detailIntent.putExtra("url", result.icon_url)
                ContextCompat.startActivity(itemView.context, detailIntent, options.toBundle())
            })*/
        }

    }

}