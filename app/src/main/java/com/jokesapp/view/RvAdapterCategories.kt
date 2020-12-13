package com.jokesapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jokesapp.R
import com.jokesapp.model.Category
import kotlinx.android.synthetic.main.adapter_item_layout.view.*


class RvAdapterCategories (private val result: ArrayList<Category>) : RecyclerView.Adapter<RvAdapterCategories.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(result.get(position))
        //holder.name.text = resultList.get(position).display_title
        //holder.rating.text = resultList.get(position).mpaa_rating
    }

    fun update(results: List<Category>) {
        result.clear()
        result.addAll(results)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val category = itemView.tvValue

        fun bind(result: Category) {
            category.text = result.category

            /*Picasso.with(itemView.context)
                .load(result.icon_url)
                .into(iconUrl); */

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