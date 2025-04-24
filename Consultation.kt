package com.example.interior_design_app

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Consultation : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultation)

        usernameEditText = findViewById(R.id.username)
        phoneNumberEditText = findViewById(R.id.phoneNumber)

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance().reference

        val consultationButton: Button = findViewById(R.id.submitconsultation)
        consultationButton.setOnClickListener {
            if (validateUsername() && validatePhoneNumber()) {
                val username = usernameEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()

                // Store in Firebase
                storeUserData(username, phoneNumber)

                // Show confirmation
                Toast.makeText(this, "Consultancy Booked", Toast.LENGTH_SHORT).show()

                // Navigate to the next screen (e.g., LoginActivity)
                val intent = Intent(this, HomeFragment::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter valid username and phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to validate username
    private fun validateUsername(): Boolean {
        val username = usernameEditText.text.toString()
        if (TextUtils.isEmpty(username)) {
            usernameEditText.error = "Please enter your name"
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            return false
        }
        // Update regex to allow alphabets and spaces
        if (!username.matches(Regex("^[a-zA-Z\\s]+$"))) {
            usernameEditText.error = "Please enter only alphabets and spaces"
            Toast.makeText(this, "Please enter only alphabets and spaces", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Function to validate phone number
    private fun validatePhoneNumber(): Boolean {
        val phoneNumber = phoneNumberEditText.text.toString()
        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.error = "Please enter your phone number"
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!Patterns.PHONE.matcher(phoneNumber).matches() || phoneNumber.length != 10) {
            phoneNumberEditText.error = "Please enter a valid 10-digit phone number"
            Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Function to store data in Firebase
    private fun storeUserData(username: String, phoneNumber: String) {
        // Create a unique ID for each entry using push().key
        val userId = database.child("users").push().key
        if (userId != null) {
            val user = User(username, phoneNumber)
            database.child("users").child(userId).setValue(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                }
        }
    }

    // Data class to represent a User
    data class User(val username: String, val phoneNumber: String)
}
