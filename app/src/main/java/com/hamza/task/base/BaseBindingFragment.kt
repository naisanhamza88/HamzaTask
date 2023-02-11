package com.hamza.task.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.hamza.task.util.Utility
import com.hamza.task.view.LoadingView


abstract class BaseBindingFragment<VM : BaseViewModel, DB : ViewDataBinding>(private val mViewModelClass: Class<VM>) :
    BaseFragment() {

    companion object {
        @JvmStatic
        lateinit var appActivity: BaseActivity
    }

    lateinit var utility: Utility


    lateinit var viewModel: VM
    open lateinit var binding: DB


    @LayoutRes
    abstract fun getLayoutRes(): Int

    private lateinit var loadingDialog: LoadingView

    private fun getViewM(): VM = ViewModelProvider(this)[mViewModelClass]



    fun init(inflater: LayoutInflater, container: ViewGroup) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)

    }

    open fun init() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (activity != null) {
            appActivity = activity as BaseActivity
            utility = Utility(appActivity)
            loadingDialog = LoadingView(appActivity)
            viewModel = getViewM()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init(inflater, container!!)
        super.onCreateView(inflater, container, savedInstanceState)
        init()

        return binding.root
    }


}