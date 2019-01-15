package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class d3ValQR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    String dato,dato1,dato2,dato3;
    private ZXingScannerView myScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d3_val_qr );

        //dato1 = getIntent().getStringExtra( "taller" );
        //dato2 = getIntent().getStringExtra( "opc" );
        //dato3 = getIntent().getStringExtra( "nombre" );

        //Toast.makeText( this,"Opcion "+dato2, Toast.LENGTH_SHORT).show();

        myScannerView = new ZXingScannerView( this );
        setContentView( myScannerView );
        myScannerView.setResultHandler( this );
        myScannerView.startCamera();


    }

    @Override
    public void handleResult(Result result) {
        dato = result.getText();
        dato1 = getIntent().getStringExtra( "taller" );
        dato2 = getIntent().getStringExtra( "opc" );
        dato3 = getIntent().getStringExtra( "nombre" );
        Toast.makeText( this,"Consulta "+dato, Toast.LENGTH_SHORT).show();
        //myScannerView.resumeCameraPreview( this );

        Intent in = new Intent( d3ValQR.this, d3Resultado.class );
        in.putExtra( "taller",dato1);
        in.putExtra( "opc",dato2 );
        in.putExtra( "nombre",dato3 );
        in.putExtra( "cc",dato );
        startActivity( in );
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

    }
}
