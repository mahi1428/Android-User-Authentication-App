package com.example.assignment1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UpdatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Open GitHub updates page immediately
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.blog/")))


        finish()
    }
}

