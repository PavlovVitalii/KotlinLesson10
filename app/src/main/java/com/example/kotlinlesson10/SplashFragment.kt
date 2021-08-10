package com.example.kotlinlesson10

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class SplashFragment : Fragment() {

    val result = ResultFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler(Looper.getMainLooper()).postDelayed({

                parentFragmentManager.commit {
                    replace(R.id.splash_fragment, LoginFragment())

            }
        }, 2000)


        return inflater.inflate(R.layout.fragment_splash, container, false)

    }
}



