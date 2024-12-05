// BookmarkFragment.kt in com.example.therapy project
package com.uilover.project2112.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class BookmarkFragment : Fragment() {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val binding = inflater.inflate(R.layout.fragment_bookmark, container, false)
//
//        // Get saved bookmarks (titles and contents) from SharedPreferences
//        val sharedPreferences = requireContext().getSharedPreferences("bookmarks", Context.MODE_PRIVATE)
//        val bookmarkedTitles = sharedPreferences.getStringSet("bookmarked_titles", mutableSetOf())?.toList() ?: emptyList()
//        val bookmarkedContents = sharedPreferences.getStringSet("bookmarked_contents", mutableSetOf())?.toList() ?: emptyList()
//
//        // Set up the ListView to display the bookmarked titles using RayAdapter
//        val listView: ListView = binding.findViewById(R.id.bookmarkListView)
//        val adapter = RayAdapter(requireContext(), bookmarkedTitles)
//        listView.adapter = adapter
//
//        // Set an item click listener to show the full health tip content when clicked
//        listView.setOnItemClickListener { parent, view, position, id ->
//            val clickedTitle = bookmarkedTitles[position]
//            val clickedContent = bookmarkedContents[position]
//
//            // Show the full health tip in HealthTipActivity2 (read-only mode)
//            showHealthTipDetail(clickedTitle, clickedContent)
//        }
//
//        return binding
//    }

//    private fun showHealthTipDetail(title: String, content: String) {
//        // Start HealthTipActivity2 to display the full health tip content
//        val intent = Intent(requireContext(), HealthTipActivity2::class.java)
//        intent.putExtra("HEALTH_TIP_TITLE", title)
//        intent.putExtra("HEALTH_TIP", content)
//        startActivity(intent)
//    }

    // Custom RayAdapter to display the titles in a ListView
    class RayAdapter(context: Context, private val titles: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, titles) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getView(position, convertView, parent)
            // Customize the view here (e.g., add background, change text size, etc.)
            return view
        }
    }
}
