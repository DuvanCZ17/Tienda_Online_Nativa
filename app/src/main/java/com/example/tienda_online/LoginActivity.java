package com.example.tienda_online;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button btnEnter, btnRegister;
    EditText  password, emailAddress;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        btnEnter = findViewById(R.id.btnEnter);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = emailAddress.getText().toString().trim();
                String passwordUser = password.getText().toString().trim();

                if(emailUser.isEmpty() && passwordUser.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(emailUser, passwordUser);
                }
            }
        });
    }

    private void loginUser(String emailUser, String passwordUser) {
     mAuth.signInWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if (task.isSuccessful()){
                 finish();
                 startActivity(new Intent(LoginActivity.this, MainActivity.class));
                 Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
             }
         }
     }).addOnFailureListener(new OnFailureListener() {
         @Override
         public void onFailure(@NonNull Exception e) {
             Toast.makeText(LoginActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
         }
     });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}