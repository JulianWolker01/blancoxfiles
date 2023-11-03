package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

    EditText ConfirmarContra, Contra, Nombre, Apellido, Fecha, Telefono1, Correo;
    TextView Consigna;
    ImageView Imagen, TengoCuenta;
    Button Boton;

    String str_nombre, str_Correo, str_Contra, str_Apellido, str_Fecha, str_Telefono;
    String url = "http://localhost/Funciones/Registrarse.php";

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
        Correo = findViewById(R.id.Correo);
        TengoCuenta = findViewById(R.id.tengocuenta);

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register(view);
            }
        });
    }

    private void Register(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait a second...");
        progressDialog.show();

        if (Nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Nombre", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else if (Apellido.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Apellido", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else if (Fecha.getText().toString().isEmpty()) {
            Toast.makeText(this, "Fecha de Nacimiento", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else if (Telefono1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Telefono", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else if (Correo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Correo", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else if (Contra.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Password", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else {
            str_nombre = Nombre.getText().toString().trim();
            str_Apellido = Apellido.getText().toString().trim();
            str_Fecha = Fecha.getText().toString().trim();
            str_Telefono = Telefono1.getText().toString().trim();
            str_Correo = Correo.getText().toString().trim();
            str_Contra = Contra.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    Nombre.setText("");
                    Apellido.setText("");
                    Fecha.setText("");
                    Correo.setText("");
                    Contra.setText("");
                    Toast.makeText(register2.this, response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
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