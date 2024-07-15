package com.mona15dev.mercadolibretest.exceptions

import android.util.Log
import com.mona15dev.domain.product.exceptions.DataException

class UnconfiguredExceptionHandler : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, throwable: Throwable) {

        when (throwable) {
            is DataException.NetworkException -> {
                Log.e("CustomUncaughtExceptionHandler", "Error en con API REST: ${throwable.message}")
            }

            else -> {
                Log.e("CustomUncaughtExceptionHandler", "Error desconocido: ${throwable.message}")
            }
        }
    }
}