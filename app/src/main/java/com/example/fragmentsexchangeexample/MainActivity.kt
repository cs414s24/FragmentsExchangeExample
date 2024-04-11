package com.example.fragmentsexchangeexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // A global variable to alternate between two fragments
    private var isFragmentOneLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun exchangeFragments(view: View) {

        // Begin the transaction
        val transaction = supportFragmentManager.beginTransaction()

        if (isFragmentOneLoaded) {
            transaction.replace(R.id.fragmentContainerView1, FragmentOne())
            transaction.replace(R.id.fragmentContainerView2, FragmentTwo())
            isFragmentOneLoaded = false
        } else {
            transaction.replace(R.id.fragmentContainerView1, FragmentTwo())
            transaction.replace(R.id.fragmentContainerView2, FragmentOne())
            isFragmentOneLoaded = true
        }

        // This might be used to add the fragments to backstack so that the user may go back the previous state with back button
        //transaction.addToBackStack(null)

        // Commit the transaction to apply
        transaction.commit()

    }
}