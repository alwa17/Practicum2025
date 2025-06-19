//ST10447049 Alwaba Nqoba Siqwepu //
package com.example.practicum2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import za.iie.practicum2025.DetailView
import za.iie.practicum2025.Playlist
import za.iie.practicum2025.R

class MainActivity : AppCompatActivity() {
    companion object {
        val packingList = mutableListOf<Playlist>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameInput = findViewById<EditText>(R.id.editName)
        val quantityInput = findViewById<EditText>(R.id.editQuantity)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val nextScreenButton = findViewById<Button>(R.id.btnNext)
        val exitButton = findViewById<Button>(R.id.btnExit)

        //button to add name of song and comment
        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val rating = quantityInput.text.toString().toIntOrNull() ?: 0

            if (name.isNotBlank() && rating > 0) {
                Playlist.add(Playlist(name, rating))
                Toast.makeText(this, "Song added", Toast.LENGTH_SHORT).show()
                nameInput.text.clear()
                quantityInput.text.clear()
            } else {
                Toast.makeText(this, "Please enter a valid name and comment", Toast.LENGTH_SHORT).show()
            }
        }

        nextScreenButton.setOnClickListener {
            startActivity(Intent(this, DetailView::class.java))
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}