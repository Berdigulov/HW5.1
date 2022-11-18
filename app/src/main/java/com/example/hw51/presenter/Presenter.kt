package com.example.hw51.presenter

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.hw51.CounterView
import com.example.hw51.MainActivity
import com.example.hw51.model.CounterModel

class Presenter(context: Context) {

    private val model = CounterModel()
    lateinit var view: CounterView

    fun increment(){
        model.increment()
        view.updateCount(model.count)
        if(model.getCount()==10){
            view.showToast()
        }else if(model.getCount() == 15){
            view.setColor()
        }
    }
    fun decrement(){
        model.decrement()
        view.updateCount(model.count)
    }

    fun attachView(view: CounterView){
        this.view = view
    }



}