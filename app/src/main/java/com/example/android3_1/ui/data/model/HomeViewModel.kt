package com.example.android3_1.ui.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private var _userData = MutableLiveData<Model>()
    val userData :LiveData<Model> = _userData

    fun updateUserModel(userModel: Model){
        _userData.value = userModel
    }

}