package com.example.administrator.tutorial16;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Resetpass extends AppCompatActivity {

    EditText editText;
    Button button;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpass);

        editText = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.tieptheo);
        progressBar = (ProgressBar) findViewById(R.id.pro);

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(editText.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Resetpass.this,"Đã gửi email khôi phục mật khẩu",Toast.LENGTH_LONG).show();
                Intent i = new Intent(Resetpass.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
