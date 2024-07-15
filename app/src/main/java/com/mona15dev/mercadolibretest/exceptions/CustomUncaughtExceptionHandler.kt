package com.mona15dev.mercadolibretest.exceptions

import android.util.Log
import com.mona15dev.domain.product.exceptions.DataException

class CustomUncaughtExceptionHandler : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, throwable: Throwable) {

        when (throwable) {
            is DataException.NetworkException -> {
            }

            else -> {
                Log.e("TAG", "Uncaught exception: ${throwable.message}")
            }
        }
    }
}