package com.mona15dev.mercadolibretest.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.domain.product.detail.usecase.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.SavedStateHandle

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val isLoading = savedStateHandle.getLiveData(StateProductDetail.IS_LOADING.toString(), false)
    val messageErrorLiveData = savedStateHandle.getLiveData<String?>(StateProductDetail.ERROR_MESSAGE.toString())
    val productDetailLiveData = savedStateHandle.getLiveData<ProductDetail?>(StateProductDetail.PRODUCT_DETAIL_STATE.toString())

    fun consultProductDetail(productId: String) {
        if (!productId.isNullOrEmpty() && productId.isNotBlank()) {
            getProductDetail(productId)
        }
    }

    private fun getProductDetail(productId: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val productDetail = getProductDetailUseCase.invoke(productId)
                productDetailLiveData.postValue(productDetail)
            } catch (e: Exception) {
                messageErrorLiveData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}