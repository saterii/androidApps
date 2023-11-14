package com.example.e07myfirstappwithnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.replace


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openFirstFragment(v: View) {
        // replace first fragment to the screen
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FirstFragment>(R.id.nav_host_fragment)
        }
    }



}