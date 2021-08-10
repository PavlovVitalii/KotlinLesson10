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
    private lateinit var loginText: String
    private lateinit var passwordText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            loginText = it.getString("login").toString()
            passwordText = it.getString("password").toString()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login = view.findViewById(R.id.show_login)
        password = view.findViewById(R.id.show_password)
        login.text = "Login ${loginText}"
        password.text = "Password ${passwordText}"

    }


}
