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

    val login = view?.findViewById<EditText>(R.id.login_text)
    val password = view?.findViewById<EditText>(R.id.password_text)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        password?.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    validate()

                    true
                }
                else -> false
            }
        }

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    fun validate() {
        val bundle = Bundle()
        login?.error = if (!login?.text.toString().equals("admin")) {
            "invalid login"
        } else {
            if (login != null) {
                bundle.putString("login", login.text.toString())
            }
            null
        }
        password?.error = if (!password?.text.toString().equals("123456")) {
            "invalid password"
        } else {
            bundle.putString("password", password?.text.toString())
            null
        }

        if (login?.text.toString().equals("admin") &&
            password?.editableText.toString().equals("123456")
        ) {
            parentFragmentManager.commit {
                replace(R.id.login_text, ResultFragment())
            }
        }

    }
}
