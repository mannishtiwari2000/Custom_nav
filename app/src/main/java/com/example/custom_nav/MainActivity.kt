package com.example.custom_nav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment=HomeFragment()
        val secondFragment=WorkFragment()
        val thirdFragment=SettingFragment()


        setCurrentFragment(firstFragment)
        var bottomNavigationView: BottomNavigationView =  findViewById(R.id.bottomnavigationbar);

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.work->setCurrentFragment(secondFragment)
                R.id.Setting->setCurrentFragment(thirdFragment)

            }
            true
        }

 }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framecontainer,fragment)
            commit()
        }
}