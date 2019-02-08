package com.example.l.EdukaTIC.dia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.consultar.validarUsuarios;

public class d2Manana extends AppCompatActivity {

    ImageView img1,img2,img3,img4;
    String opc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_manana );

        img1 = (ImageView)findViewById( R.id.imgIn );
        img2 = (ImageView)findViewById( R.id.imgOut );

        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc = "1";
                Intent in = new Intent( d2Manana.this, d2MenuManana.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );

        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc = "2";
                Intent in = new Intent( d2Manana.this, d2MenuManana.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );




        img3 = (ImageView) findViewById( R.id.imgB8 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

/*
        img4 = (ImageView) findViewById( R.id.imgHome6 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2Manana.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );
*/

    }


    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(d2Manana.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2Manana.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2Manana.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2Manana.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2Manana.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/




}
