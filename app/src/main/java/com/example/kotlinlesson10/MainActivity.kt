package com.example.kotlinlesson10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val splasActivity = SplashFragment()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.splash_fragment, splasActivity)

        }


    }
}
