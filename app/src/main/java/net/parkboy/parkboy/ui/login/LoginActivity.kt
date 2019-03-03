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

    private fun initView() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE

        login.setOnClickListener { viewChecker(1) }
        registration.setOnClickListener { viewChecker(2) }

        btn_login_cancel.setOnClickListener { viewChecker(3) }
        btn_registration_cancel.setOnClickListener { viewChecker(4) }
    }

    fun viewChecker(type: Int) {
        when (type) {
            1 -> {
                login_layout.visibility = View.VISIBLE
                login.visibility = View.GONE
                registration.visibility = View.GONE

                inputPassword.setOnClickListener { checkLogin() }
                btn_login.setOnClickListener { checkLogin() }
            }
            2 -> {
                sign_up_layout.visibility = View.VISIBLE
                registration.visibility = View.GONE
                login.visibility = View.GONE

                signConfirmPassword.setOnClickListener { checkSignUp() }
                btn_registration.setOnClickListener { checkSignUp() }
            }
            3 -> {
                login.visibility = View.VISIBLE
                registration.visibility = View.VISIBLE

                login_layout.visibility = View.GONE
            }
            4 -> {
                registration.visibility = View.VISIBLE
                login.visibility = View.VISIBLE

                sign_up_layout.visibility = View.GONE
            }
        }
    }

    private fun checkLogin() {
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

    private fun checkSignUp() {
        if (!signUsername.text.isNullOrEmpty() && !signPassword.text.isNullOrEmpty()) {
            if (signPassword.text.toString() == signConfirmPassword.text.toString()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
            }
        } else if (!signUsername.text.isNullOrEmpty()) {
            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
        } else if (!signPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Username & password can't be empty", Toast.LENGTH_SHORT).show()
        }
    }
}