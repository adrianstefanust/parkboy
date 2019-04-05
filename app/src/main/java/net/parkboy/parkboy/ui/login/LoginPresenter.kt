package net.parkboy.parkboy.ui.login

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import net.parkboy.parkboy.api.ApiServiceInterface
import net.parkboy.parkboy.di.models.request.LoginRequest

class LoginPresenter : LoginContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val ApiService: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: LoginContract.View

    override fun getLoginUser(loginRequest: LoginRequest) {
        view.onProgress(true)
        val subscribe = ApiService.login(loginRequest).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.onSuccessLogin(it)
            }, { error ->
                var msg = error.localizedMessage
                view.onProgress(false)
                view.onErrorLogin(msg)
            })
        subscriptions.add(subscribe)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }
}