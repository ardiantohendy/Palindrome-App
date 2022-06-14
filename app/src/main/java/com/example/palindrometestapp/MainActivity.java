package com.example.palindrometestapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resutTest;
    private EditText insertText;
    private Button btnRunTest;

    public void palindromeResult() {
        String text = insertText.getText().toString();
        String form = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            form += String.valueOf(c);
        }
        if (text.toLowerCase(Locale.ROOT).equals(form.toLowerCase(Locale.ROOT))) {
            resutTest.setText(text + " is a PALINDROME");
        } else {
            resutTest.setText(text + " is not a PALINDROME");
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRunTest:
                if(insertText.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please fill palindrome text form!!!", Toast.LENGTH_SHORT).show();
                    resutTest.setText("Result");
                } else {
                    palindromeResult();
                }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertText = findViewById(R.id.editText);
        btnRunTest = findViewById(R.id.btnRunTest);
        resutTest = findViewById(R.id.resultText);

        btnRunTest.setOnClickListener(this);

    }
}