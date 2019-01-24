package com.example.l.EdukaTIC;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private TextView tv1;
    ImageView img1,img2,img3,img4,img5;

    private final int SOLICTUD_PERMISO_CAMARA = 1;

    User usuario = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu );

        tv1 = (TextView)findViewById( R.id.txtNombres );

        //usuario.setNames("Hola");
        //usuario.setLastN("mundo");
        String dato1 = usuario.getNames();
        String dato2 = usuario.getLastN();
        //String dato1 = getIntent().getStringExtra( "nombres" );
        //String dato2 = getIntent().getStringExtra( "apellidos" );


        tv1.setText( dato1+" "+dato2 );


        img1 = (ImageView) findViewById( R.id.imgVerUs );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, validarUsuarios.class );
                startActivity( in );
            }
        } );


        img2 = (ImageView) findViewById( R.id.imgD1 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, dia1.class );
                startActivity( in );
            }
        } );


        img3 = (ImageView) findViewById( R.id.imgD2 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( Menu.this, dia2.class );
                startActivity( in );
            }
        } );

        img4 = (ImageView) findViewById( R.id.imgD3 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( Menu.this, dia3.class );
                startActivity( in );
            }
        } );

        img5 = (ImageView) findViewById( R.id.imgClose2 );
        img5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit( 0 );


            }
        } );


        if(ActivityCompat.checkSelfPermission( this, Manifest.permission.CAMERA ) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText( this,"Gracias por tu confianza, que la fuerza te acompañe", Toast.LENGTH_SHORT).show();
        }else{
            explicarPermiso();
            solictarPermisoCamara();

        }

    }//final de onCreate




    private void solictarPermisoCamara() {
        //0. pedir permiso con cuadros de dialogo del sistema
        ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.CAMERA}, SOLICTUD_PERMISO_CAMARA );
        Toast.makeText( this,"Permiso camara", Toast.LENGTH_SHORT).show();

    }

    private void explicarPermiso() {
        Toast.makeText( this,"Los permisos son requeridos para el correcto funcionamiento de la aplicación.", Toast.LENGTH_SHORT).show();
        alertDialogoBasico();
    }

    private void alertDialogoBasico() {
        //1. Instanciar el AlertDialog.Builder con este constructor
        AlertDialog.Builder builder = new AlertDialog.Builder( this );

        //2. Encadenar varios metodos setter para ajustar las caracteristicas del dialogo
        builder.setMessage( "Es necesario los permisos para la cámara, si quieres que se puedan leer los códigos QR. Por favor presiona ‘OK’" );

        builder.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        } );
        builder.show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

        if(requestCode == SOLICTUD_PERMISO_CAMARA){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText( this,"Gracias por tu confianza, que la fuerza te acompañe", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText( this,"No se otorgaron los permisos a la cámara, la aplicación no funcionara en su totalidad, no se podrán hacer la lectura de códigos QR. ", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
