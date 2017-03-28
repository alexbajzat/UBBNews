package com.bajzat.ubbnews.service;

import com.bajzat.ubbnews.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bjz on 3/26/2017.
 */

public class LoginCheck {
    private static LoginService sLoginService;
    private static String token;

    public static boolean checkAccount(String username, String password) {

        Call<LoginResponse> call = sLoginService.verify(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                token = response.body().getToken();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

        return token == null;
    }

    public static void setService(LoginService service) {
        sLoginService = service;
    }

    public static String getToken(){ return token;}
}
