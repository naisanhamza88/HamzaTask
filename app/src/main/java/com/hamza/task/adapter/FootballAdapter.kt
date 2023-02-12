package com.hamza.task.adapter

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.share.model.ShareHashtag
import com.facebook.share.model.SharePhoto
import com.facebook.share.model.SharePhotoContent
import com.facebook.share.widget.ShareDialog
import com.hamza.task.R
import com.hamza.task.base.BaseActivity
import com.hamza.task.model.EventData

class FootballAdapter(private val activity: BaseActivity) :
    RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {

    private val mDataSet: ArrayList<EventData> = ArrayList()

    fun updateList(list: List<EventData>) {
        mDataSet.clear()
        mDataSet.addAll(list)
        notifyItemRangeChanged(0, list.size)
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

                    val resources = activity.resources

                    val imageId = R.drawable.calendar // the ID of the image you want to share
                    val bitmap = BitmapFactory.decodeResource(resources, imageId)

                    val sharePhoto = SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .build()
                    val shareHashtag = ShareHashtag.Builder()
                        .setHashtag("${data.match} start at ${data.start} on stadium ${data.stadium}")
                        .build()
                    val sharePhotoContent = SharePhotoContent.Builder()
                        .addPhoto(sharePhoto)
                        .setShareHashtag(shareHashtag)
                        .build()

                    ShareDialog.show(activity, sharePhotoContent)
                }

            } catch (e: Exception) {
                Log.e("ErrorBidingData", e.message!!)
            }
        }
    }
}