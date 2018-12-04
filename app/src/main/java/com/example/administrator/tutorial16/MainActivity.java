package com.example.administrator.tutorial16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.Base64Utils;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView more;
    TextView create;
    Button tieptheo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        more = (TextView) findViewById(R.id.timhieuthem);
        create = (TextView) findViewById(R.id.signup);
        tieptheo = (Button) findViewById(R.id.tieptheo);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,More.class);
                startActivity(intent);
            }
        });
        tieptheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText.getText().toString()))
                {
                    Toast.makeText(MainActivity.this,"Bạn cần nhập Email!",Toast.LENGTH_LONG).show();
                }else {
                    String acc = editText.getText().toString();
                    Intent topass = new Intent(MainActivity.this, Password.class);
                    Bundle b = new Bundle();
                    b.putString("acc", acc);
                    topass.putExtra("topass", b);
                    startActivity(topass);
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tocre = new Intent(MainActivity.this,create2.class);
                startActivity(tocre);
            }
        });
    }
}
