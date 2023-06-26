package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class sturesult extends AppCompatActivity {
    private TextView tvLastName, tvFirstName, tvAttendance, tvQuiz1, tvQuiz2, tvQuiz3, tvQuiz4,
            tvExam, tvAverage, tvStatus, tvRemarks;

    private MaterialButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sturesult);

        Toolbar toolbar = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Portal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String lastName = getIntent().getStringExtra("lastName");
        String firstName = getIntent().getStringExtra("firstName");
        int attendance = getIntent().getIntExtra("attendance", 0);
        int quiz1 = getIntent().getIntExtra("quiz1", 0);
        int quiz2 = getIntent().getIntExtra("quiz2", 0);
        int quiz3 = getIntent().getIntExtra("quiz3", 0);
        int quiz4 = getIntent().getIntExtra("quiz4", 0);
        int exam = getIntent().getIntExtra("exam", 0);
        btnBack = findViewById(R.id.et_input2);
        // Calculate average
        double average = calculateAverage(attendance, quiz1, quiz2, quiz3, quiz4, exam);

        // Calculate status and remarks
        String status = calculateStatus(average);
        String remarks = calculateRemarks(average);

        // Find TextViews in the layout
        tvLastName = findViewById(R.id.tv_last_name);
        tvFirstName = findViewById(R.id.tv_first_name);
        tvAttendance = findViewById(R.id.tv_attendance);
        tvQuiz1 = findViewById(R.id.tv_quiz1);
        tvQuiz2 = findViewById(R.id.tv_quiz2);
        tvQuiz3 = findViewById(R.id.tv_quiz3);
        tvQuiz4 = findViewById(R.id.tv_quiz4);
        tvExam = findViewById(R.id.tv_exam);
        tvAverage = findViewById(R.id.tv_average);
        tvStatus = findViewById(R.id.tv_status);
        tvRemarks = findViewById(R.id.tv_remarks);

        // Set the data to TextViews
        tvLastName.setText("Last Name:"+lastName);
        tvFirstName.setText("First Name:"+firstName);
        tvAttendance.setText(String.valueOf("Attendance:"+attendance));
        tvQuiz1.setText(String.valueOf("Quiz 1:"+quiz1));
        tvQuiz2.setText(String.valueOf("Quiz 2:"+quiz2));
        tvQuiz3.setText(String.valueOf("Quiz 3:"+quiz3));
        tvQuiz4.setText(String.valueOf("Quiz 4:"+quiz4));
        tvExam.setText(String.valueOf("Exam:"+exam));
        tvAverage.setText(String.format("Average:"+"%.2f", average));
        tvStatus.setText("Status:"+status);
        tvRemarks.setText("Remarks:"+remarks);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(sturesult.this, MenuActivity.class);
                startActivity(intent4);
            }
    });}

    private double calculateAverage(int attendance, int quiz1, int quiz2, int quiz3, int quiz4, int exam) {
        double attendanceWeight = 0.2;
        double quizzesWeight = 0.3;
        double examWeight = 0.5;

        double attendanceScore = attendance * attendanceWeight;
        double quizzesScore = ((quiz1 + quiz2 + quiz3 + quiz4) / 4.0) * quizzesWeight;
        double examScore = exam * examWeight;

        return attendanceScore + quizzesScore + examScore;
    }

    private String calculateStatus(double average) {
        return average >= 60 ? "Passed" : "Failed";
    }

    private String calculateRemarks(double average) {
        if (average >= 96 && average <= 100) {
            return "4.00";
        } else if (average >= 90 && average <= 95) {
            return "3.50";
        } else if (average >= 84 && average <= 89) {
            return "3.00";
        } else if (average >= 78 && average <= 83) {
            return "2.50";
        } else if (average >= 72 && average <= 77) {
            return "2.00";
        } else if (average >= 66 && average <= 71) {
            return "1.50";
        } else if (average >= 60 && average <= 65) {
            return "1.00";
        } else {
            return "INC";
        }
    }


}
