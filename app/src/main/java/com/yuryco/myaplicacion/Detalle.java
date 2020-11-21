package com.yuryco.myaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    String vNombre = "" ;
    String vFNacimiento = "" ;
    String vTelefono = "";
    String vEmail =  "" ;
    String vDescripcion = ""  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        this.setTitle(R.string.tituloDetall);

        persistencia();

    }

    private void persistencia() {
        Bundle parametros  =getIntent().getExtras();

         vNombre = parametros.getString(getString(R.string.pnombre));
         vFNacimiento = parametros.getString(getString(R.string.pnacimiento));
         vTelefono = parametros.getString(getString(R.string.pTelefono));
         vEmail =   parametros.getString(getString(R.string.pEmail));
         vDescripcion =  parametros.getString(getString(R.string.pDescripcion));

        TextView tvNombre = findViewById(R.id.tvPNombre);
        TextView tvPFnacimiento = findViewById(R.id.tvPFnacimiento);
        TextView tvPTelefono = findViewById(R.id.tvPTelefono);
        TextView tvPEmail = findViewById(R.id.tvPEmail);
        TextView tvPDescripcion = findViewById(R.id.tvPDescripcion);

        tvNombre.setText(vNombre);
        tvPFnacimiento.setText(vFNacimiento);
        tvPTelefono.setText(vTelefono);
        tvPEmail.setText(vEmail);
        tvPDescripcion.setText(vDescripcion);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent i = new Intent(Detalle.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void editarDatos(View v){
        Intent i = new Intent(Detalle.this,MainActivity.class);
        i.putExtra(getString(R.string.pnombre), vNombre);
        i.putExtra(getString(R.string.pnacimiento),vFNacimiento);
        i.putExtra(getString(R.string.pEmail),vEmail);
        i.putExtra(getString(R.string.pDescripcion),vDescripcion);
        i.putExtra(getString(R.string.pTelefono), vTelefono);
        startActivity(i);
        finish();
    }
}