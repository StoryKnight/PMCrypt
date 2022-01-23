package com.dong.project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.RequiresApi;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Random;

public class BrowseActivity extends AppCompatActivity {

    private HashMap<String, String> accounts;
    private String[] sites;
    private boolean reveal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accounts = new HashMap<String, String>();
        setContentView(R.layout.activity_browse);
    }

    public HashMap<String, String> getAccounts() {
        return accounts;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String generatePass() {
        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return password;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setPassText(View view) {
        TextView amountView = (TextView) findViewById(R.id.passTextField);
        amountView.setText(generatePass());
    }

    public void setTextView(View view) {
        reveal = !reveal;
        TextView amountView = (TextView) findViewById(R.id.realAccounts);
        if (reveal) {
            amountView.setText(getAccounts().toString());
        }
        else {
            amountView.setText("INFORMATION");
        }
    }

    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }


}
