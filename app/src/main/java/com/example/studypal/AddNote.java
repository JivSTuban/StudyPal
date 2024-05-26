package com.example.studypal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNote extends AppCompatActivity {

    EditText tfTitle, tfDescription, tfSubject;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        tfTitle = findViewById(R.id.tfTitle);
        tfDescription = findViewById(R.id.tfSubject);
        tfSubject = findViewById(R.id.tfDescription);

        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper myDB = new MyDBHelper(AddNote.this);
                myDB.addNote(tfTitle.getText().toString().trim(),
                        tfDescription.getText().toString().trim(),
                        tfSubject.getText().toString().trim());
                finish();

            }
        });
    }
}