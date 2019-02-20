package com.epooja.epooja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button loginButton;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.etName);
        password = (EditText) findViewById(R.id.etPassword);
        info = (TextView) findViewById(R.id.tvInfo);
        loginButton = (Button) findViewById(R.id.btnLogin);
        info.setText(info.getText().toString()+counter);

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
            info.setText(info.getText().toString()+counter);
        }
    }
}
