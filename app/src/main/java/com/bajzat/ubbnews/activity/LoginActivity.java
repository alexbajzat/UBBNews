package com.bajzat.ubbnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bajzat.ubbnews.R;
import com.bajzat.ubbnews.service.LoginCheck;
import com.bajzat.ubbnews.service.LoginService;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by bjz on 3/26/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText username_field;
    private EditText password_field;
    private Button submitButton;
    private LoginService mLoginService;
    private Retrofit retrofit;
    private LoginCheck loginCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_field = (EditText) findViewById(R.id.username_field);
        password_field = (EditText) findViewById(R.id.password_field);
        submitButton = (Button) findViewById(R.id.submit_button);
        manageClick();
        initService();


    }

    protected void manageClick() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = username_field.getText().toString();
                String password = password_field.getText().toString();
                if (loginCheck.checkAccount(username, password)) {
                    toastSomething("Login Succesful!");
                    changeActivity();
                } else {
                    toastSomething("Failed to login!");
                    clear();
                }
            }
        });
    }

    private void initService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.scs.ubbcluj.ro/~bair2009/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mLoginService = retrofit.create(LoginService.class);
        loginCheck.setService(mLoginService);
    }

    private void toastSomething(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void clear() {
        username_field.setText("");
        password_field.setText("");
    }

    private void changeActivity() {

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
