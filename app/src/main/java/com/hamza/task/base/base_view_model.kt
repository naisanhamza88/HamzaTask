package com.hamza.task.base

import androidx.lifecycle.ViewModel
import com.hamza.task.base.BaseBindingFragment.Companion.appActivity
import com.hamza.task.database.DataBaseHelper
import com.hamza.task.database.FootballDataBase
import com.hamza.task.injection.component.DaggerViewModelInjector
import com.hamza.task.injection.component.ViewModelInjector
import com.hamza.task.network.ApiAccount
import com.hamza.task.network.RequestCallback
import com.hamza.task.network.RequestHandler
import com.hamza.task.util.Utility
import com.hamza.task.view.LoadingView
import com.hamza.task.viewModel.FootballViewModel
import javax.inject.Inject

open class BaseViewModel : ViewModel(), RequestCallback {
    private val injector: ViewModelInjector = DaggerViewModelInjector.create()

    @Inject
    lateinit var apiAccount: ApiAccount

    val requestHandler = RequestHandler(appActivity)

    var dataBaseHelper: FootballDataBase


    var loadingDialog = LoadingView(appActivity)

    var utility: Utility

    init {
        inject()
        utility = Utility(appActivity)
        dataBaseHelper = DataBaseHelper.init(appActivity).roomDatabase

    }

    private fun inject() {
        when (this) {
            is FootballViewModel -> injector.inject(this)
        }
    }


    override fun onSuccess(response: List<BaseEntity>, service: String) {
        loadingDialog.dismiss()
    }

    override fun onFailure() {
        loadingDialog.dismiss()
        utility.generalErrorToast()
    }

    override fun onNoConnection() {
        loadingDialog.dismiss()
        utility.errorInConnection()
    }

    override fun onError(responseMessage: String?, code: Int) {
        loadingDialog.dismiss()
        responseMessage?.let { utility.showToast(it) }
    }
}