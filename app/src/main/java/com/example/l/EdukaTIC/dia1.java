package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class dia1 extends AppCompatActivity {

    ImageView img1,img2,img3;
    String opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia1 );




        img1 = (ImageView) findViewById( R.id.imgD1m1 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                opc = "1";
                com.example.l.EdukaTIC.User usuario = new com.example.l.EdukaTIC.User();
                usuario.setD1m( opc );

                Intent in = new Intent( dia1.this, d1Menu.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgD1m2 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                opc = "2";
                com.example.l.EdukaTIC.User usuario = new com.example.l.EdukaTIC.User();
                usuario.setD1m( opc );

                Intent in = new Intent( dia1.this, d1Menu.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );

        img3 = (ImageView) findViewById( R.id.imgB1 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );




    }



    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(dia1.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(dia1.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(dia1.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(dia1.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnSalir){
            finish();
            System.exit( 0 );
        }
        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/



}
