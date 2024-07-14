package com.mona15dev.mercadolibretest.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.domain.product.detail.usecase.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val messageErrorLiveData = MutableLiveData<String>()
    val productDetailLiveData = MutableLiveData<ProductDetail>()

    fun consultProductDetail(productId: String) {
        //Temporal revisar si tiene coherencia o si se puede optimizar (desacoplar)
        if (!productId.isNullOrEmpty() && productId.isNotBlank()) {
            getProductDetail(productId)
        }
        return
    }
    
    private fun getProductDetail(productId: String) {
        //Temporal manejo de errores, quitar tantos try catch
        viewModelScope.launch {
            isLoading.postValue(true)
            try {
                val productDetail = getProductDetailUseCase.invoke(productId)
                productDetailLiveData.postValue(productDetail)
                isLoading.postValue(false)
            } catch (e: Exception) {
                isLoading.postValue(false)
                messageErrorLiveData.value = e.message.toString()
            }
        }
    }
}