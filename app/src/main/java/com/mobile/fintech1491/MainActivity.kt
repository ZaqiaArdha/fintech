package com.mobile.fintech1491

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mobile.fintech1491.home.HomeFragment
import com.mobile.fintech1491.profile.ProfileFragment
import com.mobile.fintech1491.setting.settingFragment
import com.mobile.fintech1491.home.HomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome: Button
    private lateinit var btnProfile: Button
    private lateinit var btnSettings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome = findViewById(R.id.btn_home)
        btnProfile = findViewById(R.id.btn_profile)
        btnSettings = findViewById(R.id.btn_settings)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username", "ardha")
            startActivity(intent)
        }

        btnHome.setOnClickListener {
            loadFragment(HomeFragment())
        }
        btnProfile.setOnClickListener {
            loadFragment(ProfileFragment())
        }
        btnSettings.setOnClickListener{
            loadFragment(settingFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}