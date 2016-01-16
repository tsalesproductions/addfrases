package com.addfrases.addfrases;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class UserUpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int return_function = 0;
    UserCallBack userCallBack;
    String userName;
    TextView uName;
    TextView uEmail;
    TextView uPassword;
    TextView uStatus;
    Button uButtonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);
        uButtonUpdate = (Button) findViewById(R.id.uButtonUpdate);
        uButtonUpdate.setOnClickListener(this);

        String url1 = "http://192.168.0.100/client/user.php?user=" + userCallBack.userName;
        PostResponseAsyncTask task1 = new PostResponseAsyncTask(UserUpdateActivity.this, false, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                ArrayList<User> userList =
                        new JsonConverter<User>().toArrayList(s, User.class);

                ArrayList<String> usuario = new ArrayList<String>();
                for(User value: userList){
                    usuario.add(value.name_user);
                    uName = (TextView) findViewById(R.id.uName);
                    uName.setText(value.name_user);
                    usuario.add(value.email_user);
                    uEmail = (TextView) findViewById(R.id.uEmail);
                    uEmail.setText(value.email_user);
                    usuario.add(value.password_user);
                    uPassword = (TextView) findViewById(R.id.uPassword);
                    uPassword.setText(value.password_user);
                    usuario.add(value.sobre_user);
                    uStatus = (TextView) findViewById(R.id.uStatus);
                    uStatus.setText(value.sobre_user);
                    usuario.add(value.username_user);
                    userName = value.username_user;
                }
            }

        });
        task1.execute(url1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtName", uName.getText().toString());
        postData.put("txtUsername", userName.toString());
        postData.put("txtEmail", uEmail.getText().toString());
        postData.put("txtPassword", uPassword.getText().toString());
        postData.put("txtStatus", uStatus.getText().toString());

        String url1 = "http://192.168.0.100/client/updateuser.php";
        PostResponseAsyncTask task1 = new PostResponseAsyncTask(UserUpdateActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String result) {
                    if(result.contains("success")){
                        Toast.makeText(UserUpdateActivity.this, "Dados alterados com sucesso", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(UserUpdateActivity.this, "Houve algum erro", Toast.LENGTH_LONG).show();
                    }
            }
        });
        task1.execute(url1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        MenuItem it1 = menu.add(Menu.NONE, return_function, Menu.NONE, "Return");
        it1.setIcon(R.drawable.returning);
        it1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case return_function:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return false;
        }
    }

}
