package com.example.assignment1

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences  // Used to store user login details locally

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences to retrieve stored credentials
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // When the login button is clicked
        binding.btnLogin.setOnClickListener {
            val enteredUsername = binding.etUsername.text.toString().trim() // Get username input
            val enteredPassword = binding.etPassword.text.toString().trim() // Get password input

            // Retrieve stored credentials
            val savedUsername = sharedPreferences.getString("username", null) // Get saved username
            val savedPassword = sharedPreferences.getString("password", null) // Get saved password

            // Check if entered credentials match stored credentials
            if (enteredUsername == savedUsername && enteredPassword == savedPassword) {
                // If login is successful, open GitHub homepage
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"))
                startActivity(intent)
            } else {
                // If login fails, show a toast message
                Toast.makeText(this, "Username or password is incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }
        }

        // When the back button is clicked, return to MainActivity
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close this activity so it doesn't stay in the background
        }
    }
}
