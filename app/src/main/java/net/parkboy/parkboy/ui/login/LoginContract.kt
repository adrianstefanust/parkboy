package net.parkboy.parkboy.ui.login

import net.parkboy.parkboy.di.models.response.LoginResponse
import net.parkboy.parkboy.di.models.request.LoginRequest
import net.parkboy.parkboy.util.data.BaseContract

class LoginContract {
    interface View : BaseContract.View {
        fun onSuccessLogin(loginResponse: LoginResponse)
        fun onErrorLogin(msg: String)
        fun onProgress(state: Boolean)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getLoginUser(loginRequest: LoginRequest)
    }
}