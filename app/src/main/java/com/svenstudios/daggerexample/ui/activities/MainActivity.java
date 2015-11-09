package com.svenstudios.daggerexample.ui.activities;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;

import com.svenstudios.daggerexample.R;
import com.svenstudios.daggerexample.application.DaggerExampleApp;
import com.svenstudios.daggerexample.injections.AppContainer;
import com.svenstudios.daggerexample.ui.fragments.MainActivityFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.main_content) ViewGroup content;

    @Inject AppContainer appContainer;

    public MainActivity() {
        DaggerExampleApp.getInstance().getGraph().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Remove the status bar color. The DrawerLayout is responsible for drawing it from now on.
            setStatusBarColor(getWindow());
        }

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup container = appContainer.bind(this);

        inflater.inflate(R.layout.activity_main, container);
        ButterKnife.bind(this, container);

        if (savedInstanceState == null) {

            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.add(R.id.main_content, new MainActivityFragment());
            tx.commit();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static void setStatusBarColor(Window window) {
        window.setStatusBarColor(Color.TRANSPARENT);
    }

}
