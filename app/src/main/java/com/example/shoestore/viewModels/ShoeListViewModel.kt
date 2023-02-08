package com.example.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>> = _shoeList

    init {
        clearShoeList()
    }

    fun addShoe(shoe: Shoe) {
        val newList = _shoeList.value!!.plus(shoe)
        _shoeList.value = newList
    }

    fun clearShoeList() {
        _shoeList.value = listOf()
    }
}