package net.parkboy.parkboy.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.view_login.*
import net.parkboy.parkboy.R
import net.parkboy.parkboy.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_login)

        initView()
    }

    fun initView() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE

        btn_login.setOnClickListener { login() }
        inputUsername.setOnClickListener { checkLogin() }
        inputPassword.setOnClickListener { checkLogin() }

        btn_registration.setOnClickListener { signUp() }
        signConfirmPassword.setOnClickListener { checkSignUp() }
    }

    fun signUp() {
        sign_up_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
    }

    fun login() {
        login_layout.visibility = View.VISIBLE
        sign_up_layout.visibility = View.GONE
    }

    fun checkLogin() {
        if (sign_up_layout.visibility == View.GONE) {
            if (!inputUsername.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                if (inputUsername.text.toString() == "admin" && inputPassword.text.toString() == "admin") {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            } else if (!inputUsername.text.isNullOrEmpty()) {
                Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
            } else if (!inputPassword.text.isNullOrEmpty()) {
                Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Username & password can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkSignUp() {
        if (!inputUsername.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
            if (inputUsername.text.toString() == "admin" && inputPassword.text.toString() == "admin") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        } else if (signConfirmPassword.text != signPassword.text) {
            Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
        } else if (!inputUsername.text.isNullOrEmpty()) {
            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
        } else if (!inputPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Username & password can't be empty", Toast.LENGTH_SHORT).show()
        }
    }
}