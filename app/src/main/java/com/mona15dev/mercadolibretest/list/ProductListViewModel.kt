package com.mona15dev.mercadolibretest.list

import com.mona15dev.domain.product.list.usecase.GetProductByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductByNameUseCase: GetProductByNameUseCase
) : ViewModel() {

    private val _loading = MutableLiveData(false)
    private val _snackBar = MutableLiveData<String?>()
    val snackbar: LiveData<String?>
        get() = _snackBar

    fun onSearchViewClicked() {
        searchProductsByName("Motorola")
    }

    private fun searchProductsByName(queryNameOfProduct: String) {
        launchProducts {
            getProductByNameUseCase.getProductsByName(queryNameOfProduct)
        }
    }

    private fun launchProducts(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _loading.value = true
                block()
            } catch (error: Exception) {
                //Temporal hacer flujo  de errores bien hecho
                _snackBar.value = error.message
            } finally {
                _loading.value = false
            }
        }
    }
}