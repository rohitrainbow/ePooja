package com.epooja.epooja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button loginButton;
    private LoginButton fbLoginButton;
    private CallbackManager callbackManager;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        name = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        info = findViewById(R.id.tvInfo);
        loginButton = findViewById(R.id.btnLogin);
        fbLoginButton=findViewById(R.id.btnFacebookLogin);
        callbackManager=CallbackManager.Factory.create();
        info.setText(format("%s%d", getText(R.string.atmpt_rem), counter));


        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(String userName, String password) {
        if (userName.equals("rohit") && password.equals("lalwani")) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);

        } else {
            counter--;
            if (counter == 0) {
                loginButton.setEnabled(false);
            }
            info.setText(format("%s%d", getText(R.string.atmpt_rem), counter));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
