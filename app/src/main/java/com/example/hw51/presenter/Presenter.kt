package com.example.hw51.presenter

import com.example.hw51.CounterView
import com.example.hw51.model.CounterModel

class Presenter {

    private val model = CounterModel()
    lateinit var view: CounterView

    fun increment(){
        model.increment()
        view.updateCount(model.count)
    }
    fun decrement(){
        model.decrement()
        view.updateCount(model.count)
    }

    fun attachView(view: CounterView){
        this.view = view
    }
}