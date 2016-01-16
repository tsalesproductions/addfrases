package com.addfrases.addfrases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText rName, rUsername, rEmail, rPassword;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rName = (EditText) findViewById(R.id.rName);
        rUsername = (EditText) findViewById(R.id.rUsername);
        rEmail = (EditText) findViewById(R.id.rEmail);
        rPassword = (EditText) findViewById(R.id.rPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    public void processFinish(String result) {
        if(result.contains("success")){
            startActivity(new Intent(this, LoginActivity.class));
        }
        else{
            Toast.makeText(this, "Erro, verifique os campos", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtName", rName.getText().toString());
        postData.put("txtUsername", rUsername.getText().toString());
        postData.put("txtEmail", rEmail.getText().toString());
        postData.put("txtPassword", rPassword.getText().toString());


        String url1 = "http://192.168.0.100/client/register.php";
        PostResponseAsyncTask task1 = new PostResponseAsyncTask(RegisterActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if(s.contains("success")){
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
                else{
                    Toast.makeText(RegisterActivity.this, "O usuário já existe, ou houve algum erro, tente novamente.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        task1.execute(url1);



    }
}
