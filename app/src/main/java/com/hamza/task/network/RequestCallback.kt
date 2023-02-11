package com.hamza.task.network

import com.hamza.task.base.BaseEntity


interface RequestCallback {
    fun onSuccess(response: List<BaseEntity>, service: String)
    fun onFailure()
    fun onNoConnection()
    fun onError(responseMessage: String?, code: Int)
}