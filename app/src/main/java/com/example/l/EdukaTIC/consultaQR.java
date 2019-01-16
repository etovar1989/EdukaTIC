package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class consultaQR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView myScannerView;
    String dato="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulta_qr );

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

        //Log.v("HnadleResult", result.getText());

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Resultado del Scan" );
        builder.setMessage( result.getText() );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        */

        dato = result.getText();

        Toast.makeText( this,"Consulta "+dato, Toast.LENGTH_SHORT).show();
        Intent in = new Intent( consultaQR.this, ResultadoConsultaQR.class );
        in.putExtra( "cc",dato);
        startActivity( in );
        finish();


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
