package com.example.viewbinding

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.viewbinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.name.text = "Aruna"
        binding.btnOpen.setOnClickListener(View.OnClickListener {
            startFragment()
        })
    }

    private fun startFragment() {
        val newFragment = MainFragment()
        val args = Bundle()
        newFragment.setArguments(args)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(binding.fragmentContainer.id, newFragment)
        transaction.addToBackStack(null)

        // Commit the transaction
        transaction.commit()
    }
}