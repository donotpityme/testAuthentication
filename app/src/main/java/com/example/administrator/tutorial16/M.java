package com.example.administrator.tutorial16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class M extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        Toast.makeText(M.this, "Login Successfully!", Toast.LENGTH_LONG).show();
    }
}
