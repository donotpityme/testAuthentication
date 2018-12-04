package com.example.administrator.tutorial16;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Create extends AppCompatActivity {

    private EditText ho;
    private EditText ten;
    private EditText acc;
    private EditText pass;
    private EditText repass;
    private Button tieptheo;
    private TextView login;
    private FirebaseAuth auth;
    private ProgressBar proc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        ho = (EditText) findViewById(R.id.ho);
        ten = (EditText) findViewById(R.id.ten);
        acc = (EditText) findViewById(R.id.acc);
        pass = (EditText) findViewById(R.id.pass);
        repass = (EditText) findViewById(R.id.repass);
        tieptheo = (Button) findViewById(R.id.tieptheo);
        login = (TextView) findViewById(R.id.login);
        proc = (ProgressBar) findViewById(R.id.proc);

        auth = FirebaseAuth.getInstance();

        Toast.makeText(Create.this,"Tạo mới",Toast.LENGTH_LONG).show();

        tieptheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proc.setVisibility(View.VISIBLE);
                String email = acc.getText().toString();
                String pas = pass.getText().toString();
                auth.createUserWithEmailAndPassword(email, pas);
}
});
}}
