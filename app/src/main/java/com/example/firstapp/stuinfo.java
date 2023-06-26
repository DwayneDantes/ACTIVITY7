package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class stuinfo extends AppCompatActivity {
    private EditText etLastName, etFirstName, etCourse, etYear, etEmail, etContactNumber, etBirthYear;
    private MaterialButton btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuinfo);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Portal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etLastName = findViewById(R.id.et_lastname);
        etFirstName = findViewById(R.id.et_firstname);
        etCourse = findViewById(R.id.et_course);
        etYear = findViewById(R.id.et_year);
        etEmail = findViewById(R.id.et_email);
        etContactNumber = findViewById(R.id.et_number);
        etBirthYear = findViewById(R.id.et_birthyear);

        btnSubmit = findViewById(R.id.et_input);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void submitForm() {
        String lastName = etLastName.getText().toString().trim();
        String firstName = etFirstName.getText().toString().trim();
        String course = etCourse.getText().toString().trim();
        String year = etYear.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String contactNumber = etContactNumber.getText().toString().trim();
        String birthYear = etBirthYear.getText().toString().trim();

        if (TextUtils.isEmpty(lastName) || TextUtils.isEmpty(firstName) || TextUtils.isEmpty(course) ||
                TextUtils.isEmpty(year) || TextUtils.isEmpty(email) || TextUtils.isEmpty(contactNumber) ||
                TextUtils.isEmpty(birthYear)) {
            Toast.makeText(this, "Please fill in all the required fields", Toast.LENGTH_SHORT).show();
        } else if (!TextUtils.isDigitsOnly(year) || !TextUtils.isDigitsOnly(contactNumber) || !TextUtils.isDigitsOnly(birthYear)) {
            Toast.makeText(this, "Year, Contact Number, and Birth Year should only contain numbers", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent5 = new Intent(stuinfo.this, sturecord.class);
            // Pass the data to the next activity if needed
            intent5.putExtra("lastName", lastName);
            intent5.putExtra("firstName", firstName);
            intent5.putExtra("course", course);
            intent5.putExtra("year", year);
            intent5.putExtra("email", email);
            intent5.putExtra("contactNumber", contactNumber);
            intent5.putExtra("birthYear", birthYear);
            startActivity(intent5);
        }
    }

    }


