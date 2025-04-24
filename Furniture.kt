package com.example.interior_design_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController

class Furniture_room : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture_room)

        val toolbar = findViewById<Toolbar>(R.id.Tool5)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set navigation click listener
        toolbar.setNavigationOnClickListener {
            findNavController(R.id.Homefragment).popBackStack() // Adjust ID as needed
        }
    }
}
