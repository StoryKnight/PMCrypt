package com.dong.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final int PREFERENCE_FILE_KEY = 69;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceType")
    public void login(View view) {
        EditText amountView = (EditText) findViewById(R.id.editTextNumberPassword);
        if (amountView == null) {
            return;
        }

        else if (amountView.getText().equals(0)) {
            return;
        }

        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        // check pass
        int pass = getResources().getInteger(R.integer.pass);
        System.out.println("current pass:" + pass);

        // immediately change it
        SharedPreferences.Editor editor = sharedPref.edit();
        System.out.println("input pass:" + String.valueOf(amountView.getText()));
        editor.putInt(, Integer.parseInt(String.valueOf(amountView.getText())));
        editor.apply();
        if (pass == 0) {

            editor.clear();
            editor.apply();


            System.out.println("pass created");
        }

        if (Integer.parseInt(String.valueOf(amountView.getText())) == pass) {

        }
        // switchBrowse();

    }

    private void switchBrowse() {
        Intent switchActivityIntent = new Intent(this, BrowseActivity.class);
        startActivity(switchActivityIntent);
    }

    private void reset() {
        Context context = getActivity();

    }

    private Context getActivity() {
        return MainActivity.this;
    }
}