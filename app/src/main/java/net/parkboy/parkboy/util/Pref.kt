package net.parkboy.parkboy.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder

class Pref(context: Context) {
    private val PREF_PACKAGE_NAME = "net.parkboy.parkboy"
    private val USER_ID = "idCustomer"
    private var USERNAME = "nama"

    val gson = GsonBuilder().create()

    private val prefs: SharedPreferences = context.getSharedPreferences(PREF_PACKAGE_NAME, 0)

    //LoginProfile

    fun GetUserID(): String {
        return prefs.getString(USER_ID, "")
    }

    fun SetUserID(status: String) {
        prefs.edit().putString(USER_ID, status).apply()
    }
}