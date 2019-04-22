package com.jinwoo.reactive

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navigationItemClickListener
            = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when(item.itemId) {
            R.id.navigation_home -> {
                transaction.replace(R.id.main_container, HomeFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_heart -> {
                transaction.replace(R.id.main_container, HeartFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_hash_tag -> {
                transaction.replace(R.id.main_container, HashTagFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_menu -> {
                transaction.replace(R.id.main_container, ProfileFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
         false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_container, HomeFragment())
            commit()
        }
        bottom_navi.setOnNavigationItemSelectedListener(navigationItemClickListener)
    }

    override fun onBackPressed() {
        if (bottom_navi.selectedItemId == R.id.navigation_home)
            super.onBackPressed()
        else
            bottom_navi.selectedItemId = R.id.navigation_home
    }
}
