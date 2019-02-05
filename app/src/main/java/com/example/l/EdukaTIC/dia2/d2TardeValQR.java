package com.example.l.EdukaTIC.dia2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.l.EdukaTIC.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class d2TardeValQR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    String taller, nom;
    private ZXingScannerView myScannerView;
    String dato="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_tarde_val_qr );


        myScannerView = new ZXingScannerView( this );
        setContentView( myScannerView );
        myScannerView.setResultHandler( this );
        myScannerView.startCamera();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

    }

    @Override
    public void handleResult(Result result) {

        dato = result.getText();
        taller = getIntent().getStringExtra( "taller" );
        nom = getIntent().getStringExtra( "nombre" );

        Toast.makeText( this,"Consulta "+dato, Toast.LENGTH_SHORT).show();
        Intent in = new Intent( d2TardeValQR.this, d2TardeResultado.class );
        in.putExtra( "cc",dato);
        in.putExtra( "taller",taller);
        in.putExtra( "nombre",nom);
        startActivity( in );
        finish();


    }
}
