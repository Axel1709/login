package com.example.axel.a22ventana_login_relativelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, contraseña;
    private TextView info;
    private Button Login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.Usuario);
        contraseña = (EditText) findViewById(R.id.Contraseña);
        info = (TextView) findViewById(R.id.info);
        Login = (Button) findViewById(R.id.btn1);

        info.setText("N° de intentos restantes: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(usuario.getText().toString(),contraseña.getText().toString());

            }
        });
    }
            private void validar (String UserName, String userPassword){
                if ((UserName.equals("Admin")) && (userPassword.equals("1234"))) {
                    Intent intent = new Intent(MainActivity.this, Bienvenido.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    counter --;

                    info.setText("N° de intentos restantes:"+ String.valueOf(counter));
                    if (counter == 0) {

                        Login.setEnabled(false);
                    }
                }
            }
    }

