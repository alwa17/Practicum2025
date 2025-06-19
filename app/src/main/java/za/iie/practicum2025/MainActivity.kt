package com.example.practicum2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import za.iie.practicum2025.R

class MainActivity : AppCompatActivity() {
    companion object {
        val packingList = mutableListOf<PackingItem>()
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
        val artistInput = findViewById<EditText>(R.id.editArtist)
        val quantityInput = findViewById<EditText>(R.id.editQuantity)
        val commentInput = findViewById<EditText>(R.id.editComment)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val nextScreenButton = findViewById<Button>(R.id.btnNext)
        val exitButton = findViewById<Button>(R.id.btnExit)

        //declaration of everything

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0
            val artist = artistInput.text.toString()
            val comment = commentInput.text.toString()
        //button that adds everything enters in for artist,name,rating and comment.

            if (name.isNotBlank() && quantity > 0)  {
                packingList.add(PackingItem(name, quantity))
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
                nameInput.text.clear()
                quantityInput.text.clear()

            } else {
                Toast.makeText(this, "Please enter a valid name, artist, quantity and comment", Toast.LENGTH_SHORT).show()
            }
           /* if (artist.isNotBlank() && comment.isNotBlank() ) {
                packingList.add(PackingItem(artist, quantity))
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
                artistInput.text.clear()
                commentInput.text.clear()
            }else {
                Toast.makeText(this, "PLease enter valid artist name and comment", Toast.LENGTH_SHORT).show()
            } */
        }
        // separated these two if statements to make the feedback more clear on where the input error is

        nextScreenButton.setOnClickListener {
            startActivity(Intent(this, DetailView::class.java))
        }
        // button that navigates to the next screen (detail view)


        exitButton.setOnClickListener {
            finishAffinity()
        }
        //button too shut down the running application
    }
}