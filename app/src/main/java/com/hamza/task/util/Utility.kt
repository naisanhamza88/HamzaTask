package com.hamza.task.util

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hamza.task.R

class Utility(val activity: AppCompatActivity) {


    fun showToast(caption: String) {
        Toast.makeText(activity, caption, Toast.LENGTH_SHORT).show()
    }

    fun errorInConnection() {
        Toast.makeText(
            activity,
            activity.resources.getString(R.string.internetConnection),
            Toast.LENGTH_SHORT
        ).show()

    }
    fun generalErrorToast() {
        Toast.makeText(
            activity,
            activity.resources.getString(R.string.GeneralError),
            Toast.LENGTH_SHORT
        ).show()
    }

}