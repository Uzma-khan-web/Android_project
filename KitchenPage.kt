package com.example.interior_design_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController

class Kitchen_more : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitchen_more)

        val toolbar = findViewById<Toolbar>(R.id.Tool3)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set navigation click listener
        toolbar.setNavigationOnClickListener {
            findNavController(R.id.Homefragment).popBackStack()
        }
    }
}
