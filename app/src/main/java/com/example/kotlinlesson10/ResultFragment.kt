package com.example.kotlinlesson10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class ResultFragment : Fragment() {

    private lateinit var login: TextView
    private lateinit var password: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bandle = Bundle()
        login = view.findViewById(R.id.show_login)
        password = view.findViewById(R.id.show_password)
        login.text = bandle.getString("login")
        password.text = bandle.getString("password")

    }


}
