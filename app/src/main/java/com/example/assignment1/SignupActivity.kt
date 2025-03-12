package com.example.assignment1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding // View binding to access UI elements
    private lateinit var sharedPreferences: SharedPreferences // SharedPreferences to store user data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater) // Initialize view binding
        setContentView(binding.root) // Set the content view

        // Initialize SharedPreferences to store user registration details
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Handle "Create Account" button click
        binding.btnCreateAccount.setOnClickListener {
            val username = binding.etUsername.text.toString().trim() // Get entered username
            val password = binding.etPassword.text.toString().trim() // Get entered password
            val confirmPassword = binding.etConfirmPassword.text.toString().trim() // Get confirmation password

            // Check if any field is empty
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if passwords match
            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save username and password in SharedPreferences
            sharedPreferences.edit().apply {
                putString("username", username)
                putString("password", password)
                apply()
            }

            // Show success message and navigate to LoginActivity
            Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Finish this activity to remove it from the back stack
        }

        // Handle "Back" button click to return to MainActivity
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close this activity to prevent going back to it
        }
    }
}
