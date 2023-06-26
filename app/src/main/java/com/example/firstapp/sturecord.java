package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class sturecord extends AppCompatActivity {
    private TextView tvLastName, tvFirstName, tvCourse, tvYear, tvEmail, tvContactNumber, tvBirthYear, tvAge;
    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sturecord);

        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Portal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvLastName = findViewById(R.id.tv_last_name);
        tvFirstName = findViewById(R.id.tv_first_name);
        tvCourse = findViewById(R.id.tv_course);
        tvYear = findViewById(R.id.tv_year);
        tvEmail = findViewById(R.id.tv_email);
        tvContactNumber = findViewById(R.id.tv_contact_number);
        tvBirthYear = findViewById(R.id.tv_birth_year);
        tvAge = findViewById(R.id.tv_age);
        btnBack = findViewById(R.id.et_input2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String lastName = extras.getString("lastName");
            String firstName = extras.getString("firstName");
            String course = extras.getString("course");
            String year = extras.getString("year");
            String email = extras.getString("email");
            String contactNumber = extras.getString("contactNumber");
            String birthYear = extras.getString("birthYear");

            tvLastName.setText("LAST NAME:" + lastName);
            tvFirstName.setText("FIRST NAME:" + firstName);
            tvCourse.setText("COURSE:" + course);
            tvYear.setText("YEAR:" + year);
            tvEmail.setText("EMAIL:" + email);
            tvContactNumber.setText("CONTACT:" + contactNumber);
            tvBirthYear.setText("BIRTHYEAR:" + birthYear);

            int currentYear = 2023; // Update this with the current year
            int age = currentYear - Integer.parseInt(birthYear);
            tvAge.setText(String.valueOf("AGE:" + age));
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(sturecord.this, MenuActivity.class);
                startActivity(intent4);
            }


        });
    }
}