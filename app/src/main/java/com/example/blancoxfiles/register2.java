package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class register2 extends AppCompatActivity {

    EditText ConfirmarContra, Contra, Nombre, Apellido, Fecha, Telefono1;
    TextView Consigna;
    ImageView Imagen, Tengocuenta;
    Button Boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Telefono1 = findViewById(R.id.Telefono);
        Boton = findViewById(R.id.Registrar);
        Consigna = findViewById(R.id.mensaje);
        Imagen = findViewById(R.id.Logo);
        Nombre = findViewById(R.id.Nombre1);
        Apellido = findViewById(R.id.Apellido1);
        Fecha = findViewById(R.id.Nacimiento);
        Contra = findViewById(R.id.Contrasena);
        ConfirmarContra = findViewById(R.id.ConfirmContrasena);
        Tengocuenta = findViewById(R.id.volver);

    }
}