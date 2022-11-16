package com.example.barbershopadh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalMenu extends AppCompatActivity {

    public TextView textViewName;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SharedPreferences sharedPref = this.getSharedPreferences("nombre", Context.MODE_PRIVATE);
        String nombre = sharedPref.getString(getString(R.string.first_name), "");

        textViewName = findViewById(R.id.textViewName);

        textViewName.setText("Hola " + nombre);
    }

    // Métodos públicos
    // Método que dirige a agendar cita
    public void buttonPlanDate(View view) {
        Intent intent = new Intent(this, ScheduleDate.class);
        startActivity(intent);
    }

    // Método que dirige a cancelar cita
    public void buttonCancelDate(View view) {
        Intent intent = new Intent(this, SelectDate.class);
        startActivity(intent);
    }

    // Método que dirige a salir de la sesión
    public void buttonExit(View view) {
        SharedPreferences sharedPref = this.getSharedPreferences("correo_electronico", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(this, com.example.barbershopadh.MainActivity.class);
        startActivity(intent);
    }

    // Método que dirige a la información del salón
    public void buttonAboutMe(View view) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
}