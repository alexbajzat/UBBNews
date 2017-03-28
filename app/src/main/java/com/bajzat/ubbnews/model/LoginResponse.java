package com.bajzat.ubbnews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bjz on 3/26/2017.
 */

public class LoginResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("token")
    @Expose
    private String token;

    public LoginResponse(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
