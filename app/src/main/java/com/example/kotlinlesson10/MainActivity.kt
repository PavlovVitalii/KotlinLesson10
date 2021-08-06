package com.example.kotlinlesson10

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {

    val splashFragment = SplashFragment()
    val loginFragment = LoginFragment()
    val resultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit{
            setReorderingAllowed(true)
            add(R.id.splash_fragment, splashFragment)

        }


    }
}
