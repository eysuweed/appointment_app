package com.uilover.project2112.Activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.uilover.project2112.R

class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_explore, container, false)

        // Find all health tip layouts
        val healthTip1Layout: LinearLayout = binding.findViewById(R.id.healthTip1Layout)
        val healthTip2Layout: LinearLayout = binding.findViewById(R.id.healthTip2Layout)
        val healthTip3Layout: LinearLayout = binding.findViewById(R.id.healthTip3Layout)
        val healthTip4Layout: LinearLayout = binding.findViewById(R.id.healthTip4Layout)
        val healthTip5Layout: LinearLayout = binding.findViewById(R.id.healthTip5Layout)
        val healthTip6Layout: LinearLayout = binding.findViewById(R.id.healthTip6Layout)
        val healthTip7Layout: LinearLayout = binding.findViewById(R.id.healthTip7Layout)
        val healthTip8Layout: LinearLayout = binding.findViewById(R.id.healthTip8Layout)
        val healthTip9Layout: LinearLayout = binding.findViewById(R.id.healthTip9Layout)
        val healthTip10Layout: LinearLayout = binding.findViewById(R.id.healthTip10Layout)

        // Set onClickListeners for each layout
        healthTip1Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_1))
            startActivity(intent)
        }

        healthTip2Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_2))
            startActivity(intent)
        }

        healthTip3Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_3))
            startActivity(intent)
        }

        healthTip4Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_4))
            startActivity(intent)
        }

        healthTip5Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_5))
            startActivity(intent)
        }

        healthTip6Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_6))
            startActivity(intent)
        }

        healthTip7Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_7))
            startActivity(intent)
        }

        healthTip8Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_8))
            startActivity(intent)
        }

        healthTip9Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_9))
            startActivity(intent)
        }

        healthTip10Layout.setOnClickListener {
            val intent = Intent(activity, HealthTipActivity::class.java)
            intent.putExtra("HEALTH_TIP", getString(R.string.health_tip_10))
            startActivity(intent)
        }

        return binding
    }
}
