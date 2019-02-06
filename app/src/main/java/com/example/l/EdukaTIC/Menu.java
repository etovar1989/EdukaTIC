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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.peticiones.peticiones_consulta;
import com.example.l.EdukaTIC.peticiones.peticiones_menu;
import com.example.l.EdukaTIC.solicitud.solicitud;

public class Menu extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;

    private final int SOLICTUD_PERMISO_CAMARA = 1;

    User usuario = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu );

        tv1 = (TextView)findViewById( R.id.txtNombres );
        tv2 = (TextView)findViewById( R.id.tvAprobadas );
        tv3 = (TextView)findViewById( R.id.tvSolicitud);
        tv4 = (TextView)findViewById( R.id.tvCanceladas );

        //usuario.setNames("Hola");
        //usuario.setLastN("mundo");
        String dato1 = usuario.getNames();
        String dato2 = usuario.getLastN();
        //String dato1 = getIntent().getStringExtra( "nombres" );
        //String dato2 = getIntent().getStringExtra( "apellidos" );


        tv1.setText( dato1+" "+dato2 );

        img5 = (ImageView) findViewById( R.id.imgPeticion );
        img6 = (ImageView) findViewById( R.id.imgPconOk );
        img7 = (ImageView) findViewById( R.id.imgPconCancel );

        img5.setVisibility( View.INVISIBLE );
        img6.setVisibility( View.INVISIBLE );
        img7.setVisibility( View.INVISIBLE );

        tv2.setVisibility( View.INVISIBLE );
        tv3.setVisibility( View.INVISIBLE );
        tv4.setVisibility( View.INVISIBLE );

        if(usuario.getPerfil().equals( "1" )){
            img5.setVisibility( View.VISIBLE );
            img6.setVisibility( View.VISIBLE );
            img7.setVisibility( View.VISIBLE );

            tv2.setVisibility( View.VISIBLE );
            tv3.setVisibility( View.VISIBLE );
            tv4.setVisibility( View.VISIBLE );
        }



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



        img5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( Menu.this, peticiones_menu.class );
                startActivity( in );
            }
        } );



        img6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, peticiones_consulta.class );
                in.putExtra( "estado","1");
                startActivity( in );


            }
        } );



        img7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, peticiones_consulta.class );
                in.putExtra( "estado","2");
                startActivity( in );


            }
        } );

        img8 = (ImageView) findViewById( R.id.imgSolicitud );
        img8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, solicitud.class );
                startActivity( in );


            }
        } );

        img9 = (ImageView) findViewById( R.id.imgConsultarSolicitud );
        img9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, consulta_solicitud.class );
                startActivity( in );


            }
        } );


        if(ActivityCompat.checkSelfPermission( this, Manifest.permission.CAMERA ) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText( this,"Gracias por tu confianza, que la fuerza te acompañe", Toast.LENGTH_SHORT).show();
        }else{
            explicarPermiso();
            solictarPermisoCamara();

        }

    }//final de onCreate

    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            return true;
        }
        if(id==R.id.btnConsultar){
            final Intent m = new Intent(Menu.this, validarUsuarios.class);
            startActivity(m);
            return true;
        }
        if(id==R.id.btnDia1){
            final Intent m = new Intent(Menu.this, dia1.class);
            startActivity(m);
            return true;
        }
        if(id==R.id.btnDia2){
            final Intent m = new Intent(Menu.this, dia2.class);
            startActivity(m);
            return true;
        }
        if(id==R.id.btnDia3){
            final Intent m = new Intent(Menu.this, dia3.class);
            startActivity(m);
            return true;
        }
        if(id==R.id.btnSalir){
            finish();
            System.exit( 0 );
        }
        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/

    private void solictarPermisoCamara() {
        //0. pedir permiso con cuadros de dialogo del sistema
        ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.CAMERA}, SOLICTUD_PERMISO_CAMARA );
        Toast.makeText( this,"Permiso camara", Toast.LENGTH_SHORT).show();

    }

    private void explicarPermiso() {
        Toast.makeText( this,"Los permisos son requeridos para el correcto funcionamiento de la aplicación.", Toast.LENGTH_SHORT).show();
        //alertDialogoBasico();
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
