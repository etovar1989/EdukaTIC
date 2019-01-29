package com.example.l.EdukaTIC;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class d3ValCC extends AppCompatActivity {

    EditText cajaCC;
    Button consultarCC;
    String taller,opc, dato, titulo;
    ImageView img1,img4;
    TextView textoTipo;
    TextView txtDato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d3_val_cc );

        //busco caja de texto para obtener los datos de esta
        cajaCC = (EditText)findViewById( R.id.txtD1CC );
        //Recupero texto enviado
        taller = getIntent().getStringExtra( "taller" );
        dato = getIntent().getStringExtra( "nombre" );
        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.txtTipo3 );
        //Envio el texto recuperado del inten
        textoTipo.setText( dato );

        opc = getIntent().getStringExtra( "opc" );

        txtDato = (TextView) findViewById( R.id.txtD3Tipo );
        if(opc.equals( "1" )){
            titulo= "Ingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 83,67,63 ) );
        }if(opc.equals( "2" )){
            titulo= "Reingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 237,156,23 ) );
        }



        consultarCC = (Button) findViewById( R.id.btnD1Consultar );
        consultarCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opc = getIntent().getStringExtra( "opc" );
                Intent in = new Intent( d3ValCC.this, d3Resultado.class );
                in.putExtra( "cc",cajaCC.getText().toString());
                in.putExtra( "opc",opc );
                in.putExtra( "taller",taller );
                in.putExtra( "nombre",dato );
                startActivity( in );
                cajaCC.setText( "" );

            }
        } );

        img1 = (ImageView) findViewById( R.id.imgB );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        /*
        img4 = (ImageView) findViewById( R.id.imgHome16 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d3ValCC.this, Menu.class);
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
            Intent m = new Intent(d3ValCC.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d3ValCC.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d3ValCC.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d3ValCC.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d3ValCC.this, dia3.class);
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
