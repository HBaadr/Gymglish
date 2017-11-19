package com.badr.hourimeche.gymglish;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = (EditText) findViewById((R.id.input_email));
        passwordText = (EditText) findViewById((R.id.input_password));
        loginButton = (Button) findViewById((R.id.btn_login));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        if (!validate()) {
            onLoginFailed();
        } else {
            test();
        }

    }

    private void test() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        String emailV = "gymglish@gymglish.com";
        String passwordV = "gymglish";

        if (Objects.equals(email, emailV) && Objects.equals(password, passwordV)) {
            Intent intent = new Intent(this, List.class);
            startActivity(intent);
        } else if (!Objects.equals(email, emailV) && Objects.equals(password, passwordV)) {
            Toast.makeText(this, "Login incorrect !", Toast.LENGTH_LONG).show();
        } else if (Objects.equals(email, emailV) && !Objects.equals(password, passwordV)) {
            Toast.makeText(this, "Password incorrect !", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Login and password incorrect !", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


    private void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
    }

    private boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        }

        return valid;
    }
}