package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class d2MananaValQR extends AppCompatActivity  implements ZXingScannerView.ResultHandler{
    private ZXingScannerView myScannerView;

    String dato,opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_manana_val_qr );


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
        opc = getIntent().getStringExtra( "opc" );

        Toast.makeText( this,"Consulta "+dato, Toast.LENGTH_SHORT).show();

        Intent in = new Intent( d2MananaValQR.this, d2MananaResultado.class );
        in.putExtra( "cc",dato);
        in.putExtra( "opc",opc );
        startActivity( in );
        finish();

    }
}
