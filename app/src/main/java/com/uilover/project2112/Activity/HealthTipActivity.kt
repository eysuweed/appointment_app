// HealthTipActivity.kt in com.example.therapy project
package com.uilover.project2112.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uilover.project2112.R

class HealthTipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_tip)

        // Get the health tip title and content from the Intent
        val healthTipTitle = intent.getStringExtra("HEALTH_TIP_TITLE")
        val healthTipContent = intent.getStringExtra("HEALTH_TIP")

        // Display the health tip content in the TextView
        val healthTipTextView: TextView = findViewById(R.id.healthTipText)
        healthTipTextView.text = healthTipContent

        // Set up the button click listener
        val bookmarkButton: Button = findViewById(R.id.bookmarkButton)
        bookmarkButton.setOnClickListener {
            if (healthTipTitle != null && healthTipContent != null) {
                // Save the health tip to bookmarks in SharedPreferences
                saveHealthTipToBookmarks(healthTipTitle, healthTipContent)

                // Show a success message
                Toast.makeText(this, "Health tip added to bookmarks", Toast.LENGTH_SHORT).show()

                // Close this activity and return to ExploreFragment
                finish() // This will close HealthTipActivity and return to the previous fragment/activity
            }
        }
    }

    private fun saveHealthTipToBookmarks(title: String, content: String) {
        val sharedPreferences = getSharedPreferences("bookmarks", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Get the current bookmarks or create an empty list if none exist
        val bookmarks = sharedPreferences.getStringSet("bookmarked_titles", mutableSetOf()) ?: mutableSetOf()
        val bookmarkContents = sharedPreferences.getStringSet("bookmarked_contents", mutableSetOf()) ?: mutableSetOf()

        // Add the new bookmark title and content
        bookmarks.add(title)
        bookmarkContents.add(content)

        // Save the updated sets of titles and contents
        editor.putStringSet("bookmarked_titles", bookmarks)
        editor.putStringSet("bookmarked_contents", bookmarkContents)
        editor.apply()
    }
}
