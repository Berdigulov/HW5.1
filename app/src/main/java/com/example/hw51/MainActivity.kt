package com.example.hw51

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.hw51.databinding.ActivityMainBinding
import com.example.hw51.presenter.Presenter

class MainActivity : AppCompatActivity(),CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()
        presenter.attachView(this)
    }

    @SuppressLint("ResourceAsColor")
    private fun initClicker() {
        with(binding){
            btnPlus.setOnClickListener {
                presenter.increment()
            }
            btnMinus.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show()
    }

    override fun setColor() {
        binding.tvResult.setBackgroundColor(Color.GREEN)
    }


}