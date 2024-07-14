package com.mona15dev.mercadolibretest.list.viewmodel

import com.mona15dev.domain.product.list.usecase.GetProductByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.mona15dev.domain.product.list.model.Product
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductByNameUseCase: GetProductByNameUseCase
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val messageLiveData = MutableLiveData<String>()
    val productsByNameListLiveData = MutableLiveData<List<Product>>()

    fun onSearchByName(queryNameOfProduct: String) {
        if (!queryNameOfProduct.isNullOrEmpty() && queryNameOfProduct.isNotBlank()) {
            searchProductsByName(queryNameOfProduct)
        }
        return
    }

    private fun searchProductsByName(queryNameOfProduct: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            try {
                val products = getProductByNameUseCase.invoke(queryNameOfProduct)
                productsByNameListLiveData.postValue(products)
                isLoading.postValue(false)
            } catch (e: Exception) {
                isLoading.postValue(false)
                messageLiveData.value = e.message.toString()
            }
        }
    }
}