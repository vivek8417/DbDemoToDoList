package com.example.dbdemotodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dbdemotodolist.view.MainActivityViewImplementor;

public class MainActivity extends AppCompatActivity {
    MainActivityViewImplementor mvcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvcView = new MainActivityViewImplementor(MainActivity.this,null);
        setContentView(mvcView.getRootView());
        mvcView.initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvcView.bindDataToView();
    }
}