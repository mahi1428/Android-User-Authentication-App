package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // View binding for accessing UI elements

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Initializing view binding
        setContentView(binding.root)

        // When the Signup button is clicked, navigate to SignupActivity
        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        // When the Login button is clicked, navigate to LoginActivity
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // When the Signup2 button is clicked, navigate to Signup2Activity
        binding.btnSignup2.setOnClickListener {
            startActivity(Intent(this, Signup2Activity::class.java))
        }

        // When the Login2 button is clicked, navigate to Login2Activity
        binding.btnLogin2.setOnClickListener {
            startActivity(Intent(this, Login2Activity::class.java))
        }

        // When the Updates button is clicked, navigate to UpdatesActivity
        binding.btnUpdates.setOnClickListener {
            startActivity(Intent(this, UpdatesActivity::class.java))
        }
    }
}
