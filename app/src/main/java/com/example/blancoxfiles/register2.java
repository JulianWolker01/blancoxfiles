package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register2 extends AppCompatActivity {

    EditText ConfirmarContra, Contra, Nombre, Apellido, edad, Telefono1, Correo;
    TextView Consigna,Tengo;
    ImageView Imagen;
    Button Boton;
    ProgressBar progressBar;

    String str_nombre, str_Correo, str_Contra, str_Apellido, str_Fecha, str_Telefono;
    String url = "https://stoss-cone.000webhostapp.com/Proyecto_blanco/Registrarse.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        Tengo = findViewById(R.id.mensaje2);
        progressBar = findViewById(R.id.progressBar);
        Telefono1 = findViewById(R.id.Telefono);
        Boton = findViewById(R.id.Registrar);
        Consigna = findViewById(R.id.mensaje);
        Imagen = findViewById(R.id.Logo);
        Nombre = findViewById(R.id.Nombre1);
        Apellido = findViewById(R.id.Apellido1);
        edad = findViewById(R.id.Edad);
        Contra = findViewById(R.id.Contrasena);
        ConfirmarContra = findViewById(R.id.ConfirmContrasena);
        Correo = findViewById(R.id.Correo);


        Tengo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register(view);
            }
        });
    }


    private void Register(View view) {
        // Mostrar el ProgressBar
        progressBar.setVisibility(View.VISIBLE);

        if (Nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Nombre", Toast.LENGTH_SHORT).show();
            // Ocultar el ProgressBar
            progressBar.setVisibility(View.GONE);
        } else if (Apellido.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Apellido", Toast.LENGTH_SHORT).show();
            // Ocultar el ProgressBar
            progressBar.setVisibility(View.GONE);
        } else if (edad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Fecha de Nacimiento", Toast.LENGTH_SHORT).show();
            // Ocultar el ProgressBar
            progressBar.setVisibility(View.GONE);
        } else if (Telefono1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Telefono", Toast.LENGTH_SHORT).show();
            // Ocultar el ProgressBar
            progressBar.setVisibility(View.GONE);
        } else if (Correo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Correo", Toast.LENGTH_SHORT).show();
            // Ocultar el ProgressBar
            progressBar.setVisibility(View.GONE);
        } else if (Contra.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Password", Toast.LENGTH_SHORT).show();
            // Ocultar el ProgressBar
            progressBar.setVisibility(View.GONE);
        } else {
            str_nombre = Nombre.getText().toString().trim();
            str_Apellido = Apellido.getText().toString().trim();
            str_Fecha = edad.getText().toString().trim();
            str_Telefono = Telefono1.getText().toString().trim();
            str_Correo = Correo.getText().toString().trim();
            str_Contra = Contra.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Ocultar el ProgressBar
                    progressBar.setVisibility(View.GONE);
                    Nombre.setText("");
                    Apellido.setText("");
                    edad.setText("");
                    Correo.setText("");
                    Contra.setText("");
                    Toast.makeText(register2.this, response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Ocultar el ProgressBar
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(register2.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Nombre", str_nombre);
                    params.put("Apellido", str_Apellido);
                    params.put("Fecha", str_Fecha);
                    params.put("Telefono", str_Telefono);
                    params.put("Correo", str_Correo);
                    params.put("password", str_Contra);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(register2.this);
            requestQueue.add(request);
        }
    }
}