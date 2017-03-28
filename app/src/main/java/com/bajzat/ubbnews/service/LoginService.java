package com.bajzat.ubbnews.service;

import com.bajzat.ubbnews.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bjz on 3/26/2017.
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> verify(@Field("username") String username
            , @Field("password") String password);
}
