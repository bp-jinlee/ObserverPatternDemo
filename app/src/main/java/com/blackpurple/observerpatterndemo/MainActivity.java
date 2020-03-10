package com.blackpurple.observerpatterndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FileManipulation mFileManipulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFileManipulation = new FileManipulation(getApplicationContext());
        mFileManipulation.createFileDirectory("Json");
    }
}
