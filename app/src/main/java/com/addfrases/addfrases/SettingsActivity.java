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

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int return_function = 0;
    Button uUpdateUser;
    Button uUpdatePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        uUpdateUser = (Button) findViewById(R.id.uUpdateUser);
        uUpdatePicture = (Button) findViewById(R.id.uUpdatePicture);
        uUpdateUser.setOnClickListener(this);
        uUpdatePicture.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.uUpdateUser:
                startActivity(new Intent(this, UserUpdateActivity.class));
                break;

            case R.id.uUpdatePicture:
                startActivity(new Intent(this, UpdatePictureActivity.class));
                break;
        }
    }
}
