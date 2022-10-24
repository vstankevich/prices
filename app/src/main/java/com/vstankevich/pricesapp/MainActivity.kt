package com.vstankevich.pricesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vstankevich.price.presentation.PriceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, PriceFragment()).commit()
    }
}