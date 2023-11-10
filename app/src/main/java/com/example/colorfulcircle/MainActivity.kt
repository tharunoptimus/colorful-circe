package com.example.colorfulcircle

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.colorfulcircle.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private fun generateRandomColorDrawable(): GradientDrawable {
        val random = Random
        val color = String.format("#%06x", random.nextInt(0xffffff + 1))
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.OVAL
        drawable.setColor(Color.parseColor(color))
        return drawable
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            circle.setOnClickListener {
                circle.background = generateRandomColorDrawable()
            }
        }

        setContentView(binding.root)

    }
}