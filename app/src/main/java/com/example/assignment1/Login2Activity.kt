package com.example.assignment1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.databinding.ActivityLogin2Binding

class Login2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve user data from SharedPreferences (local storage)
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Handle login button click
        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Validate email format
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Get stored email & password from SharedPreferences
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPassword = sharedPreferences.getString("password", "")

            // Check if user credentials match stored values
            if (email == savedEmail && password == savedPassword) {
                // Redirect to GitHub if login is successful
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com")))
            } else {
                // Show error message if credentials are incorrect
                Toast.makeText(this, "Username or password is incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate back to MainActivity when the Back button is clicked
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
