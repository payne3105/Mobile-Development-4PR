package com.example.a4pr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button sendButton;
    EditText editText;
    TextView insertText;
    TextView sdkText;
    String inputText;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();

        findId();
        sdkText.setText("");
    }

    @Override
    @SuppressLint("SetTextI18n")
    protected void onResume() {
        super.onResume();

        String sdk = String.valueOf(Build.VERSION.SDK_INT);
        sdkText.setText(sdk + " SDK");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(inputText, editText.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        findId();
        messageSend();

        if (savedInstanceState != null) {
            insertText.setText(getResources().getString(R.string.greetings) + " " + savedInstanceState.getString(inputText));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void findId() {
        sendButton = (Button) findViewById(R.id.buttonSend);
        editText = (EditText) findViewById(R.id.textEdit);
        insertText = (TextView) findViewById(R.id.insertText);
        sdkText = (TextView) findViewById(R.id.sdkText);
    }


    public void messageSend() {
        sendButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                inputText = editText.getText().toString();
                insertText.setText(getResources().getString(R.string.greetings) + " " + inputText);
            }
        });
    }

}