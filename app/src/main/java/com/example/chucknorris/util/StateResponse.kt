package com.example.chucknorris.util

data class StateResponse<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): StateResponse<T> {
            return StateResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): StateResponse<T> {
            return StateResponse(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?=null): StateResponse<T> {
            return StateResponse(Status.LOADING, data, null)
        }
        fun <T> hideLoading(data: T?=null): StateResponse<T> {
            return StateResponse(Status.HIDE_LOADING, data, null)
        }
    }

}

