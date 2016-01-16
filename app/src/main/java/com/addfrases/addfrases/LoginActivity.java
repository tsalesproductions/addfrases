package com.addfrases.addfrases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

import static com.addfrases.addfrases.R.id;
import static com.addfrases.addfrases.R.layout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvRegisterLink;
    UserCallBack userCallBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

        etUsername = (EditText) findViewById(id.etUsername);
        etPassword = (EditText) findViewById(id.etPassword);
        btnLogin = (Button) findViewById(id.btnLogin);
        tvRegisterLink = (TextView) findViewById(id.tvRegisterLink);
        tvRegisterLink.setText("Cadastrar-se agora!");
        btnLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtUsername", etUsername.getText().toString());
        userCallBack.userName = etUsername.getText().toString();
        postData.put("txtPassword", etPassword.getText().toString());


        switch (v.getId()) {
            case id.tvRegisterLink:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }

        String url1 = "http://192.168.0.100/client/login.php";
        PostResponseAsyncTask task1 = new PostResponseAsyncTask(LoginActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if(s.contains("success")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
                }
            }
        });
        task1.execute(url1);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        // salvando o texto antes da orientação ocorrer
        String username = etUsername.getText().toString();
        outState.putString("username", username);
    }
}