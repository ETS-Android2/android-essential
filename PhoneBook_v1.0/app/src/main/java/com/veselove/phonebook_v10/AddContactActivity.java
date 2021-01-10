package com.veselove.phonebook_v10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    private EditText firstNameTxt;
    private EditText lastNameTxt;
    private EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_activity);

        firstNameTxt = findViewById(R.id.editTextFirstName);
        lastNameTxt = findViewById(R.id.editTextLastName);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSave:
                Intent intent = new Intent();
                String firstName = firstNameTxt.getText().toString();
                String lastName = lastNameTxt.getText().toString();
                String phoneNum = phoneNumber.getText().toString();

                if (phoneNum.isEmpty()) {
                    Toast.makeText(this, "Phone number required", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("phoneNumber", phoneNum);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.buttonCancel:
                Intent intent2 = new Intent();
                setResult(RESULT_CANCELED, intent2);
                finish();
                break;
        }
    }
}