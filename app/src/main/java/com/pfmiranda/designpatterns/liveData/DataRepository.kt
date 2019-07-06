package com.pfmiranda.designpatterns.liveData

import androidx.lifecycle.MutableLiveData

class DataRepository {

    companion object{
        var data : MutableLiveData<Data> = MutableLiveData()

        fun addText(text : String){
            if(data.value == null){
                data.value = Data()
            }
            data.value?.data?.add(text)
        }

        fun getMutable(): MutableLiveData<Data>{
            return data
        }
    }

}