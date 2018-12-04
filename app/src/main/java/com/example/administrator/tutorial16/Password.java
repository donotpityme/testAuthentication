package com.example.administrator.tutorial16;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Password extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText editText;
    Button tieptheo;
    ImageView see;
    ProgressBar proc;
    TextView forget;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        auth = FirebaseAuth.getInstance();
        editText = (EditText) findViewById(R.id.editText2);
        tieptheo= (Button) findViewById(R.id.tieptheo);
        see = (ImageView) findViewById(R.id.see);
        proc = (ProgressBar) findViewById(R.id.proc);
        forget = (TextView) findViewById(R.id.forget);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Password.this,Resetpass.class);
                startActivity(i);
            }
        });

        see.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        editText.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }
        });
        Intent intent = getIntent();
        Bundle laydulieu = intent.getBundleExtra("topass");
        final String acc = laydulieu.getString("acc");
        Toast.makeText(Password.this,acc,Toast.LENGTH_LONG).show();

        auth = FirebaseAuth.getInstance();
        tieptheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proc.setVisibility(View.VISIBLE);
                final String pass = editText.getText().toString();
                auth.signInWithEmailAndPassword(acc,pass).addOnCompleteListener(Password.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {
                            Toast.makeText(Password.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                            Toast.makeText(Password.this,"Sai tên tài khoản hoặc mật khẩu",Toast.LENGTH_LONG).show();
                            proc.setVisibility(View.GONE);
                        }
                        else {
                            Toast.makeText(Password.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                            proc.setVisibility(View.GONE);
                            Intent re = new Intent(Password.this,M.class);
                            startActivity(re);
                        }
                    }
                });
            }
        });
    }
}
