package com.uilover.project2112.Activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.uilover.project2112.Adapter.NearDoctorsAdapter
import com.uilover.project2112.R
import com.uilover.project2112.ViewModel.MainViewModel
import com.uilover.project2112.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    private lateinit var fragmentManager: FragmentManager
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the doctor's list functionality
        initNearByDoctor()

        // Initialize fragment navigation and bottom navigation
        fragmentManager = supportFragmentManager
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.background = null

        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment? = when (item.itemId) {
                R.id.fragment_home -> HomeFragment()
                R.id.fragment_explore -> ExploreFragment()
                R.id.fragment_bookmark -> BookmarkFragment()
                R.id.fragment_profile -> ProfileFragment()
                else -> null
            }

            fragment?.let {
                replaceFragment(it)
                true
            } ?: false
        }

        // Set default fragment
        replaceFragment(HomeFragment())
    }

    // Function to initialize the doctor's list
    private fun initNearByDoctor() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity, Observer {
                topView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                topView.adapter = NearDoctorsAdapter(it)
                progressBar.visibility = View.GONE
            })
        }
    }

    // Function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        fragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            addToBackStack(null)
            commit()
        }
    }

    // Handle the back button press to return to the home fragment if not already on it
    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
        if (currentFragment is HomeFragment) {
            moveTaskToBack(true) // Move the app to the background if on HomeFragment
        } else {
            bottomNavigationView.selectedItemId = R.id.fragment_home
            replaceFragment(HomeFragment())
        }
    }

    // Empty function for setting the "Add Organization" listener if needed
    fun setOnAddOrgListener(function: () -> Unit) {
        // Implementation can be added here if required
    }
}
