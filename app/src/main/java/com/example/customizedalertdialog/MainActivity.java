package com.example.customizedalertdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Widgets
    private Button buttonCustomAlertDialog;
    private LinearLayout linearLayoutLogout;
    //Variables
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIdForAllWidgets();
        buttonCustomAlertDialog.setOnClickListener(this);
    }

    private void getIdForAllWidgets() {
        buttonCustomAlertDialog = findViewById(R.id.button_alert_dialog);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonCustomAlertDialog) {
            showDialog();
        } else if (view == linearLayoutLogout) {
            linearLayoutLogout.setBackgroundResource(R.color.silver);
            Toast.makeText(this, "You are LogOut", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.item_custom_alert_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .show();
        linearLayoutLogout = view.findViewById(R.id.linear_layout_log_out);
        linearLayoutLogout.setOnClickListener(this);
    }
}
