package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class register2 extends AppCompatActivity {

    EditText ConfirmarContra, Contra, Nombre, Apellido, Cumpleanos;
    TextView Consigna;
    ImageView Imagen;
    RadioButton Mujer, Hombre;
    Button Boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Boton = findViewById(R.id.Registrar);
        Mujer = findViewById(R.id.Mujer1);
        Hombre = findViewById(R.id.Hombre1);
        Consigna = findViewById(R.id.mensaje);
        Imagen = findViewById(R.id.Logo);
        Nombre = findViewById(R.id.Nombre1);
        Apellido = findViewById(R.id.Apellido1);
        Cumpleanos = findViewById(R.id.Cumple);
        Contra = findViewById(R.id.Contrasena);
        ConfirmarContra = findViewById(R.id.ConfirmContrasena);

    }
}