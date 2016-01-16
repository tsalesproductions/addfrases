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

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int return_function = 0;
    UserCallBack userCallBack;
    TextView cName;
    TextView cMessage;
    Button cSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        cName = (TextView) findViewById(R.id.cName);
        cName.setText(userCallBack.nameUser+" @"+userCallBack.userName);
        cMessage = (TextView) findViewById(R.id.cMessage);
        cSubmit = (Button) findViewById(R.id.cSubmit);
        cSubmit.setOnClickListener(this);


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
        switch(v.getId()){
            case R.id.cSubmit:
                HashMap postData = new HashMap();
                postData.put("mobile", "android");
                postData.put("txtName", cName.getText().toString());
                postData.put("txtUsername", UserCallBack.userName.toString());
                postData.put("txtMessage", cMessage.getText().toString());

                String url1 = "http://192.168.0.100/client/contact.php";
                PostResponseAsyncTask task1 = new PostResponseAsyncTask(ContactActivity.this, postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String result) {
                        if(result.contains("success")){
                            Toast.makeText(ContactActivity.this, "Mensagem Enviada com sucesso!", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(ContactActivity.this, "Houve algum erro", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                task1.execute(url1);
                 break;
        }
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
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return false;
        }
    }
}
