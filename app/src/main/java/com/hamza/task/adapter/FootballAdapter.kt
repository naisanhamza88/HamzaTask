package com.hamza.task.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hamza.task.R
import com.hamza.task.base.BaseActivity
import com.hamza.task.model.EventData

class FootballAdapter(private val activity: BaseActivity) :
    RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {

    private val mDataSet: ArrayList<EventData> = ArrayList()

    fun updateList(list: List<EventData>) {
        mDataSet.clear()
        mDataSet.addAll(list)
        notifyItemRangeChanged(0,list.size)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FootballViewHolder {

        val mView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.football_item, viewGroup, false)
        return FootballViewHolder(activity, mView)
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bind(mDataSet[position])
    }


    class FootballViewHolder(
        private val activity: BaseActivity,
        vView: View
    ) :
        RecyclerView.ViewHolder(vView) {
        private val country: TextView = vView.findViewById(R.id.country)
        private val tournament: TextView = vView.findViewById(R.id.tournament)
        private val match: TextView = vView.findViewById(R.id.match)
        private val date: TextView = vView.findViewById(R.id.date_time)
        private val stadium: TextView = vView.findViewById(R.id.stadium)
        private val share: ImageView = vView.findViewById(R.id.share)

        fun bind(data: EventData) {
            try {
                country.text = data.country
                tournament.text = data.tournament
                match.text = data.match
                date.text = data.start
                stadium.text = data.stadium

                share.setOnClickListener {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "data.match \nOn stadium ${data.stadium} At ${data.start}")

                    val facebookIntent = Intent(Intent.ACTION_SEND)
                    facebookIntent.type = "text/plain"
                    facebookIntent.putExtra(Intent.EXTRA_TEXT, "data.match \nOn stadium ${data.stadium} At ${data.start}")
                    facebookIntent.setPackage("com.facebook.katana")

                    if (facebookIntent.resolveActivity(activity.packageManager) != null) {
                        activity.startActivity(facebookIntent)
                    } else {
                        activity.startActivity(shareIntent)
                    }
                }

            } catch (e: Exception) {
                Log.e("ErrorBidingData", e.message!!)
            }
        }

    }
}