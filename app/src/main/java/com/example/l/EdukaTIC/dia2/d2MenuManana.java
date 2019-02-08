package com.example.l.EdukaTIC.dia2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.consultar.validarUsuarios;

public class d2MenuManana extends AppCompatActivity {
    ImageView img1,img2,img3,img4;
    String opc,titulo;
    TextView txtDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_menu_manana );

        opc = getIntent().getStringExtra( "opc" );
        txtDato = (TextView) findViewById( R.id.txtD2txto );

        if(opc.equals( "1" )){
            titulo= "Ingreso";
            txtDato.setTextColor( Color.rgb( 83,67,63 ) );
        }if(opc.equals( "2" )){
            titulo= "Reingreso";
            txtDato.setTextColor( Color.rgb( 237,156,23 ) );
        }



        txtDato.setText( titulo );

        img1= (ImageView) findViewById( R.id.imgD2MCC );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d2MenuManana.this, d2MananaValCC.class );
                in.putExtra( "opc",opc );
                startActivity( in );

            }
        } );

        img2= (ImageView) findViewById( R.id.imgD2MQR );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d2MenuManana.this, d2MananaValQR.class );
                in.putExtra( "opc",opc );
                startActivity( in );

            }
        } );


        img3 = (ImageView) findViewById( R.id.imgB9 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        /*
        img4 = (ImageView) findViewById( R.id.imgHome7 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2MenuManana.this, Menu.class);
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
            Intent m = new Intent(d2MenuManana.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2MenuManana.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2MenuManana.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2MenuManana.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2MenuManana.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/



}
