package com.example.imransk.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET, passET;
    private Button login_btn;
    private FirebaseAuth mfFirebaseAuth=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        emailET = findViewById(R.id.email_ET);
        passET = findViewById(R.id.pass_ET);
        login_btn = findViewById(R.id.log_in);

        mfFirebaseAuth=FirebaseAuth.getInstance();
        if (mfFirebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),LoginSuccessActivity.class));
        }


        login_btn.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        String email = emailET.getText().toString().trim();
        String pass = passET.getText().toString().trim();
        mfFirebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),LoginSuccessActivity.class));
                            Toast.makeText(LogInActivity.this, "success Login", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LogInActivity.this, "failed Login", Toast.LENGTH_SHORT).show();
                                                   }
                    }
                });
    }
}
