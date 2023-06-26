package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;

public class MenuActivity extends AppCompatActivity {
    ImageButton button4;
    ImageButton button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Portal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button4 = (ImageButton) findViewById(R.id.imageButton4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MenuActivity.this, stuinfo.class);
                startActivity(intent2);
            }


        });
        button5 = (ImageButton) findViewById(R.id.imageButton5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MenuActivity.this, stugrade.class);
                startActivity(intent3);
            }
        });
    }

        public boolean onOptionsItemsSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }






}