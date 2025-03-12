package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.databinding.ActivitySignup2Binding

class Signup2Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySignup2Binding // View binding to access UI elements

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater) // Initializing view binding
        setContentView(binding.root) // Setting the content view

        // Initialize SharedPreferences to store user registration details
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // When the "Create Account" button is clicked
        binding.btnCreateAccount.setOnClickListener {
            val email = binding.etUsername.text.toString().trim() // Get email input
            val password = binding.etPassword.text.toString().trim() // Get password input
            val confirmPassword = binding.etConfirmPassword.text.toString().trim() // Get confirmation password

            // Validate if the email format is correct
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate password strength: at least 1 uppercase, 1 special character, and 8-15 characters
            if (!password.matches("^(?=.*[A-Z])(?=.*[@#\$%^&+=!]).{8,15}$".toRegex())) {
                Toast.makeText(this, "Password must be 8-15 chars, 1 uppercase, 1 special character!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Check if both passwords match
            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Store the email and password in SharedPreferences
            sharedPreferences.edit().apply {
                putString("email", email)
                putString("password", password)
                apply()
            }

            // Show success message and redirect to Login2Activity
            Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Login2Activity::class.java))
            finish() // Finish the current activity so it is removed from the back stack
        }

        // When the "Back" button is clicked, return to MainActivity
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close this activity to prevent going back to it
        }
    }
}
