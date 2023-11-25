package com.example.th7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.textViewResult);

        // Retrieve the result string from Intent and display it
        String result = getIntent().getStringExtra("result");
        resultTextView.setText(result);
    }
    public static void start(Context context, String result) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra("result", result);
        context.startActivity(intent);
    }
}