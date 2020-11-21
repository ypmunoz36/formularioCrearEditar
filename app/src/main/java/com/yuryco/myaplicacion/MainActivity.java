package com.yuryco.myaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    String nombreCompleto = "";
    String telefonoPersona = "";
    String email = "";
    String descripcion = "";
    String fechaNacimiento = "";

    TextInputEditText  teNombre ;
    TextInputEditText teTelefono ;
    TextInputEditText teEmail  ;
    TextInputEditText teDescripcion ;
    EditText etDate;

    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(R.string.tituloRegistro);

        instanciarComponentesGraficos();

        Bundle parametros = getIntent().getExtras();

        if(parametros != null){
            teNombre.setText(parametros.getString( getResources().getString( R.string.pnombre)));
            teTelefono.setText(parametros.getString( getResources().getString( R.string.pTelefono)));
            teEmail.setText(parametros.getString( getResources().getString( R.string.pEmail)));
            teDescripcion.setText(parametros.getString( getResources().getString( R.string.pDescripcion)));
            etDate.setText(parametros.getString( getResources().getString( R.string.pnacimiento)));
        }



        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }

    private void instanciarComponentesGraficos() {
        teNombre =   findViewById(R.id.teNombre);
        teTelefono = findViewById(R.id.teTelefono);
        teEmail = findViewById(R.id.teEmail);
        teDescripcion = findViewById(R.id.teDescripcion);
        etDate = findViewById(R.id.etDate);
    }

    public void guardarDatos(View v){
         Log.i("MainActivity m1", "fechaNacimiento "+ fechaNacimiento);
         capturarFormulario();
         Intent i = new Intent(MainActivity.this, Detalle.class);
         i.putExtra(getString(R.string.pnombre), nombreCompleto);
         i.putExtra(getString(R.string.pnacimiento),fechaNacimiento);
         i.putExtra(getString(R.string.pEmail),email);
         i.putExtra(getString(R.string.pDescripcion),descripcion);
         i.putExtra(getString(R.string.pTelefono), telefonoPersona);
         startActivity(i);
         finish();
     }
    public void capturarFormulario(){

        nombreCompleto = teNombre.getText().toString();
        telefonoPersona = teTelefono.getText().toString();
        email = teEmail.getText().toString();
        descripcion = teDescripcion.getText().toString();
        fechaNacimiento = etDate.getText().toString();
    }
}