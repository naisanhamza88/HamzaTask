package com.hamza.task.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.hamza.task.R


/**
 * Created by Hamza Abdullah on 11/01/2018.
 */
class LoadingView(a: AppCompatActivity?) : Dialog(a!!) {
    private val dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.loadin_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mProgressBar: ProgressBar = findViewById(R.id.progress)
        mProgressBar.progress
    }

    init {
        dialog = this
    }
}