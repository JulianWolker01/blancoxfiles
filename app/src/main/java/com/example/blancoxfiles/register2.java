package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class register2 extends AppCompatActivity {

    EditText ConfirmarContrasena, Nombre, Apellido, Cumple, ;
    TextView mensaje;
    ImageView Logo;
    RadioButton Mujer, Hombre;
    Button Boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Boton = findViewById(R.id.Registrar);

    }
}