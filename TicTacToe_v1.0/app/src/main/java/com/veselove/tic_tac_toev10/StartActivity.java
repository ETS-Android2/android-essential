package com.veselove.tic_tac_toev10;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private EditText fillName1;
    private EditText fillName2;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fillName1 = (EditText) findViewById(R.id.editTextTextPersonName);
        fillName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fillName1.length() == 0 || fillName2.length() == 0) {
                    Toast.makeText(StartActivity.this, "Enter the name of both players", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    intent.putExtra("NAME1", fillName1.getText());
                    intent.putExtra("NAME2", fillName2.getText());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                StartActivity.this);
        quitDialog.setTitle("Do you want to exit?");

        quitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        quitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        quitDialog.show();
    }
}