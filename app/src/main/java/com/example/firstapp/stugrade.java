package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class stugrade extends AppCompatActivity {
    private EditText etLastName, etFirstName, etAttendance, etQuiz1, etQuiz2, etQuiz3, etQuiz4, etExam;
    private MaterialButton btnSubmit;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stugrade);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Portal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etLastName = findViewById(R.id.et_lastname);
        etFirstName = findViewById(R.id.et_firstname);
        etAttendance = findViewById(R.id.tv_attendance1);
        etQuiz1 = findViewById(R.id.et_quiz1);
        etQuiz2 = findViewById(R.id.et_quiz2);
        etQuiz3 = findViewById(R.id.et_quiz3);
        etQuiz4 = findViewById(R.id.et_quiz4);
        etExam = findViewById(R.id.et_exam);
        btnSubmit = findViewById(R.id.et_input3);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = etLastName.getText().toString().trim();
                String firstName = etFirstName.getText().toString().trim();
                String attendanceStr = etAttendance.getText().toString().trim();
                String quiz1Str = etQuiz1.getText().toString().trim();
                String quiz2Str = etQuiz2.getText().toString().trim();
                String quiz3Str = etQuiz3.getText().toString().trim();
                String quiz4Str = etQuiz4.getText().toString().trim();
                String examStr = etExam.getText().toString().trim();

                if (lastName.isEmpty() || firstName.isEmpty() || attendanceStr.isEmpty() ||
                        quiz1Str.isEmpty() || quiz2Str.isEmpty() || quiz3Str.isEmpty() ||
                        quiz4Str.isEmpty() || examStr.isEmpty()) {
                    Toast.makeText(stugrade.this, "Please fill in all areas!", Toast.LENGTH_SHORT).show();;
                } else {
                    int attendance = Integer.parseInt(attendanceStr);
                    int quiz1 = Integer.parseInt(quiz1Str);
                    int quiz2 = Integer.parseInt(quiz2Str);
                    int quiz3 = Integer.parseInt(quiz3Str);
                    int quiz4 = Integer.parseInt(quiz4Str);
                    int exam = Integer.parseInt(examStr);

                    if (attendance < 1 || attendance > 100 || quiz1 < 1 || quiz1 > 100 ||
                            quiz2 < 1 || quiz2 > 100 || quiz3 < 1 || quiz3 > 100 ||
                            quiz4 < 1 || quiz4 > 100 || exam < 1 || exam > 100) {
                        Toast.makeText(stugrade.this,"Please enter valid values (1-100) for attendance, quizzes, and exam.",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(stugrade.this,"Grades submitted successfully.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(stugrade.this, sturesult.class);
                        intent.putExtra("lastName", lastName);
                        intent.putExtra("firstName", firstName);
                        intent.putExtra("attendance", attendance);
                        intent.putExtra("quiz1", quiz1);
                        intent.putExtra("quiz2", quiz2);
                        intent.putExtra("quiz3", quiz3);
                        intent.putExtra("quiz4", quiz4);
                        intent.putExtra("exam", exam);
                        startActivity(intent);


                    }
                }
            }
        });


    }
}