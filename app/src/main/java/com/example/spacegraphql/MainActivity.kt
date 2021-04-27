package com.example.spacegraphql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.spacegraphql.Fun.FunFragment
import com.example.spacegraphql.Home.HomeFragment
import com.example.spacegraphql.Me.MeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavBar: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val homeFragment= HomeFragment()
        val meFragment= MeFragment()
        val funFragment= FunFragment()
        setFragment(homeFragment)
        bottomNavBar.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home -> setFragment(homeFragment)
                R.id.me -> setFragment(meFragment)
                R.id.theater -> setFragment(funFragment)
            }
            true
        }

    }
    fun setFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
     replace(R.id.frag_wrapper,fragment)
        commit()
    }
}