package com.dong.project;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Random;


public class FakeActivity extends AppCompatActivity {

    private HashMap<String, String> accounts;
    private String[] sites;
    private boolean reveal = false;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sites = new String[] {"Amazon", "Facebook", "Google", "Youtube",
                "Myspace", "LOL", "UMN", "Instagram", "Microsoft"};
        accounts = new HashMap<String, String>();
        generateAccounts();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String generatePass() {
        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return password;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void generateAccounts() {
        for (String site : sites) {
            accounts.put(site, generatePass());
        }
    }

    public HashMap<String, String> getAccounts() {
        return accounts;
    }

    public void setTextView(View view) {
        reveal = !reveal;
        TextView amountView = (TextView) findViewById(R.id.fakeAccounts);
        if (reveal) {
            amountView.setText(getAccounts().toString());
        }
        else {
            amountView.setText("INFORMATION");
        }
    }

}