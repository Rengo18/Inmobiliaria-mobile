package com.example.inmobiliaria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
                if(email.equals(emailValido) && password.equals(passwordValido)){
                   Intent i =new Intent(this,Principal.class);
                   i.putExtra("email",email);
                   String nombre= "Franco Martin Colombo";
                   i.putExtra("nombre",nombre);
                   startActivity(i);
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


