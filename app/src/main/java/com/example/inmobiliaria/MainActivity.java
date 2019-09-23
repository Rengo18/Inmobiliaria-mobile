package com.example.inmobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        textViewError = findViewById(R.id.incorrecto);
    }

    public void IniciarSesion(View view){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String emailValido = "tincho_martintin10@hotmail.com";
        String passwordValido="123";
        if(!email.isEmpty() && !password.isEmpty()){
                if(email==emailValido && password==passwordValido){
                    textViewError.setVisibility(view.VISIBLE);
                    textViewError.setText("inicia sesion");
                }else{
                    textViewError.setVisibility(view.VISIBLE);
                    textViewError.setText("el password o email no son validos");
                }
        }else{
            textViewError.setVisibility(view.VISIBLE);
           textViewError.setText("para iniciar sesion ingrese email y password");
        }
    }


}
