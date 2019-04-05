//package net.parkboy.parkboy.ui.login
//
//import android.content.Intent
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.view.KeyEvent
//import android.view.View
//import android.widget.Toast
//import com.google.gson.GsonBuilder
//import kotlinx.android.synthetic.main.activity_login.*
//import net.parkboy.parkboy.BaseApp
//import net.parkboy.parkboy.R
//import net.parkboy.parkboy.di.component.DaggerActivityComponent
//import net.parkboy.parkboy.di.models.request.LoginRequest
//import net.parkboy.parkboy.di.models.response.LoginResponse
//import net.parkboy.parkboy.di.module.ActivityModule
//import net.parkboy.parkboy.ui.home.HomeActivity
//import javax.inject.Inject
//
//class LoginActivity : AppCompatActivity(), LoginContract.View {
//
//    @Inject
//    lateinit var presenter: LoginContract.Presenter
//    val gson = GsonBuilder().create()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//        injectDependency()
//        presenter.attach(this)
////        checkUser()
//        initView()
//    }
//
//    //    private fun initView() {
////        sign_up_layout.visibility = View.GONE
////        login_layout.visibility = View.GONE
////
////        login.setOnClickListener { viewChecker(1) }
////        registration.setOnClickListener { viewChecker(2) }
////
////        btn_login_cancel.setOnClickListener { viewChecker(3) }
////        btn_registration_cancel.setOnClickListener { viewChecker(4) }
////    }
////
////    fun viewChecker(type: Int) {
////        when (type) {
////            1 -> {
////                login_layout.visibility = View.VISIBLE
////                login.visibility = View.GONE
////                registration.visibility = View.GONE
////
////                inputPassword.setOnClickListener { checkLogin() }
////                btn_login.setOnClickListener { checkLogin() }
////            }
////            2 -> {
////                sign_up_layout.visibility = View.VISIBLE
////                registration.visibility = View.GONE
////                login.visibility = View.GONE
////
////                signConfirmPassword.setOnClickListener { checkSignUp() }
////                btn_registration.setOnClickListener { checkSignUp() }
////            }
////            3 -> {
////                login.visibility = View.VISIBLE
////                registration.visibility = View.VISIBLE
////
////                login_layout.visibility = View.GONE
////            }
////            4 -> {
////                registration.visibility = View.VISIBLE
////                login.visibility = View.VISIBLE
////
////                sign_up_layout.visibility = View.GONE
////            }
////        }
////    }
////
////    private fun checkLogin() {
////        if (sign_up_layout.visibility == View.GONE) {
////            if (!inputUsername.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
////                if (inputUsername.text.toString() == "a" && inputPassword.text.toString() == "a") {
////                    val intent = Intent(this, HomeActivity::class.java)
////                    startActivity(intent)
////                }
////            } else if (!inputUsername.text.isNullOrEmpty()) {
////                Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
////            } else if (!inputPassword.text.isNullOrEmpty()) {
////                Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show()
////            } else {
////                Toast.makeText(this, "Username & password can't be empty", Toast.LENGTH_SHORT).show()
////            }
////        }
////    }
////
////    private fun checkSignUp() {
////        if (!signUsername.text.isNullOrEmpty() && !signPassword.text.isNullOrEmpty()) {
////            if (signPassword.text.toString() == signConfirmPassword.text.toString()) {
////                val intent = Intent(this, HomeActivity::class.java)
////                startActivity(intent)
////            } else {
////                Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
////            }
////        } else if (!signUsername.text.isNullOrEmpty()) {
////            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
////        } else if (!signPassword.text.isNullOrEmpty()) {
////            Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show()
////        } else {
////            Toast.makeText(this, "Username & password can't be empty", Toast.LENGTH_SHORT).show()
////        }
////    }
//
//    private fun initView() {
//        loginBtn.setOnClickListener {
//            doIt()
//        }
//        inputPassword.setOnKeyListener { _, keyCode, keyevent ->
//            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
//                doIt()
//                true
//            } else
//                false
//        }
//    }
//
//    private fun doIt() {
//        if (!inputUsername.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
//            presenter.getLoginUser(
//                LoginRequest(
//                    inputUsername.text.toString(),
//                    inputPassword.text.toString()
//                )
//            )
//        } else if (!inputUsername.text.isNullOrEmpty()) {
//            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
//        } else if (!inputPassword.text.isNullOrEmpty()) {
//            Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Username & password can't be empty", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun checkUser() {
//        if (!BaseApp.pref.GetUserID().isNullOrBlank()) {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun injectDependency() {
//        val activityComponent = DaggerActivityComponent.builder()
//            .activityModule(ActivityModule(this))
//            .build()
//
//        activityComponent.inject(this)
//    }
//
//    override fun onSuccessLogin(loginResponse: LoginResponse) {
//        BaseApp.pref.SetUserID(loginResponse.userid)
//        val intent = Intent(this, HomeActivity::class.java)
//        startActivity(intent)
//    }
//
//    override fun onErrorLogin(msg: String) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onProgress(state: Boolean) {
//        rl_login_fielder.visibility = if (state) View.VISIBLE else View.GONE
//    }
//
//    override fun onDestroy() {
//        presenter.unsubscribe()
//        super.onDestroy()
//    }
//}

package net.parkboy.parkboy.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import net.parkboy.parkboy.R
import net.parkboy.parkboy.ui.home.HomeActivity
import net.parkboy.parkboy.ui.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
