package com.example.kotlinlesson10

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class SplashFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPreferences = requireActivity().getSharedPreferences("user", Context.MODE_PRIVATE)
        val user = sharedPreferences.all

        Handler(Looper.getMainLooper()).postDelayed({
            if (user.size >= 2) {
                parentFragmentManager.commit {
                    replace(R.id.splash_fragment, ResultFragment())
                }
            } else {
                parentFragmentManager.commit {
                    replace(R.id.splash_fragment, LoginFragment())
                }

            }
        }, 2000)


        return inflater.inflate(R.layout.fragment_splash, container, false)

    }
}



