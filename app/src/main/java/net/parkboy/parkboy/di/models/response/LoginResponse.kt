package net.parkboy.parkboy.di.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("idCustomer")
    @Expose
    var userid: String = ""

    @SerializedName("nama")
    @Expose
    var name: String = ""

    override fun toString(): String {
        return "LoginResponse(email='$userid', nama='$name')"
    }
}