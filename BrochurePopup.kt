package com.example.interior_design_app

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BrochurePopup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brochure_popup)

        // Optionally, close the popup when the user taps outside
        setFinishOnTouchOutside(true)

        val closeButton: Button = findViewById(R.id.closePopupButton)
        closeButton.setOnClickListener {
            finish()  // Close the popup activity
        }
    }
}
