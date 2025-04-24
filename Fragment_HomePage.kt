package com.example.interior_design_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.interior_design_app.Bedroom_more
import com.example.interior_design_app.BrochurePopup
import com.example.interior_design_app.Furniture_room
import com.example.interior_design_app.Kitchen_more
import com.example.interior_design_app.Living_more
import com.example.interior_design_app.R

class HomeFragment : Fragment() {
    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout and store it in a variable
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val image1 = view.findViewById<ImageView>(R.id.img1)

        image1.setOnClickListener {
            val intent = Intent(requireContext(), Living_more::class.java)
            startActivity(intent)
        }

        val image2 = view.findViewById<ImageView>(R.id.img2)

        image2.setOnClickListener {
            val intent = Intent(requireContext(), Kitchen_more::class.java)
            startActivity(intent)
        }

        val image3 = view.findViewById<ImageView>(R.id.img6)

        image3.setOnClickListener {
            val intent = Intent(requireContext(), Bedroom_more::class.java)
            startActivity(intent)
        }

        val image4 = view.findViewById<ImageView>(R.id.img4)
        image4.setOnClickListener {
            val intent = Intent(requireContext(), Furniture_room::class.java)
            startActivity(intent)
        }

        val downloadButton: Button = view.findViewById(R.id.download)

        // Set an onClick listener to the button
        downloadButton.setOnClickListener {
            // Create an Intent to start the BrochureActivity
            val intent = Intent(activity, BrochurePopup::class.java)
            startActivity(intent)
        }

        val BookConsultation: Button = view.findViewById(R.id.bookConsultation)

        // Set an onClick listener to the button
        BookConsultation.setOnClickListener {
            // Create an Intent to start the BrochureActivity
            val intent = Intent(activity, Consultation::class.java)
            startActivity(intent)
        }
        return view

    }

}
