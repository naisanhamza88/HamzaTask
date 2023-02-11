package com.hamza.task.network


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hamza.task.injection.component.DaggerViewModelInjector
import com.hamza.task.injection.component.ViewModelInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RequestHandler(
    val activity: AppCompatActivity
) {

    private val injector: ViewModelInjector = DaggerViewModelInjector.create()

    @Inject
    lateinit var apiAccount: ApiAccount
    private lateinit var subscription: Disposable

    init {
        injector.inject(this)
    }

    fun fetchData(callback: RequestCallback) {
        if (isNetworkConnected()) {
            subscription =
                apiAccount.fetchData("Amman", "38d72d3fb0msh014269b5d02d59fp15e07ajsn19922508e411","weatherapi-com.p.rapidapi.com")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {}
                    .doOnTerminate {}
                    .subscribe({ response ->
                        response?.let {
                            response.football.isNotEmpty().let {
                                callback.onSuccess(response.football, "football")
                            }
                        }
                    }, { throwable ->
                        throwable?.let {
                            if (it.message != null) {
                                Log.e("Error", it.message!!)
                                callback.onFailure()
                            }
                        }
                    })
        } else {
            callback.onNoConnection()
        }
    }


    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            //for other device how are able to connect with Ethernet
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            //for check internet over Bluetooth
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

}