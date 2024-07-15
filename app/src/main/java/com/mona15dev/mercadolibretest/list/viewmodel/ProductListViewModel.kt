package com.mona15dev.mercadolibretest.list.viewmodel

import com.mona15dev.domain.product.list.usecase.GetProductByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.mona15dev.domain.product.list.model.Product
import kotlinx.coroutines.launch
import javax.inject.Inject

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductByNameUseCase: GetProductByNameUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _isLoading = savedStateHandle.getLiveData(StateProductList.IS_LOADING.toString(), false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _messageErrorLiveData = savedStateHandle.getLiveData<String?>(StateProductList.ERROR_MESSAGE.toString())
    val messageErrorLiveData: LiveData<String?> get() = _messageErrorLiveData

    private val _productsByNameListLiveData = savedStateHandle.getLiveData(StateProductList.PRODUCTS_STATE.toString(), emptyList<Product>())
    val productsByNameListLiveData: LiveData<List<Product>> get() = _productsByNameListLiveData

    fun onSearchByName(queryNameOfProduct: String) {
        if (queryNameOfProduct.isNotBlank()) {
            searchProductsByName(queryNameOfProduct)
        }
    }

    private fun searchProductsByName(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val products = getProductByNameUseCase.invoke(query)
                _productsByNameListLiveData.value = products
            } catch (e: Exception) {
                //Temporal, manejo de errores
                _messageErrorLiveData.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}