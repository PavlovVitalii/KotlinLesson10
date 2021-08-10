package com.example.kotlinlesson10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class LoginFragment : Fragment() {

    private lateinit var login: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login = view.findViewById(R.id.login_text)
        password = view.findViewById(R.id.password_text)
        password.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    validate()
                    true
                }
                else -> false
            }
        }
    }

    fun validate() {

        val bundle = Bundle()

        login.error = if (login.text.toString() != "admin") {
            "invalid login"
        } else {
            bundle.putString("login", login.text.toString())
            null
        }

        password.error = if (password.text.toString() != "123456") {
            "invalid password"
        } else {
            bundle.putString("password", password.text.toString())
            null
        }

        if (login.text.toString() == "admin" &&
            password.text.toString() == "123456"
        ) {
            childFragmentManager.commit {
                replace(R.id.splash_fragment,ResultFragment())
            }
        }

    }
}
