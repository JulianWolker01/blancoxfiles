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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;

public class register2 extends AppCompatActivity {

    EditText ConfirmarContra, Contra, Nombre, Apellido, Fecha, Telefono1,Correo;
    TextView Consigna;
    ImageView Imagen, Tengocuenta;
    Button Boton;

    String str_nombre,str_Correo,str_Contra,str_Apellido;
    String url = "";
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
        Tengocuenta = findViewById(R.id.volver);

    }
    private void Register(View view){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait a second...");

        if (Nombre.getText().toString().equals(" ") && Apellido.getText().toString().equals(" ")){
            Toast.makeText(this, "Ingresar Usuario", Toast.LENGTH_SHORT).show();

        }
        else if (Correo.getText().toString().equals(" ")){
            Toast.makeText(this, "Ingresar Correo", Toast.LENGTH_SHORT).show();

        }
        else if (Contra.getText().toString().equals(" ") ){
            Toast.makeText(this, "Ingresar Password", Toast.LENGTH_SHORT).show();

        }
        else{
            progressDialog.show();

            str_nombre = Nombre.getText().toString().trim();
            str_Correo = Correo.getText().toString().trim();
            str_Contra = Contra.getText().toString().trim();
            str_Apellido = Apellido.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    Nombre.setText("");
                    Correo.setText("");
                    Contra.setText("");
                    Apellido.setText("");
                    Toast.makeText(register2.this, response, Toast.LENGTH_SHORT).show();
                }
            } new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(register2.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            }

        }
    }
}