package com.example.l.EdukaTIC;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class d3Menu extends AppCompatActivity {
    private TextView tv1;
    String dato1,dato2,dato3, titulo;
    ImageView img1,img2,img3,img4;
    TextView txtDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d3_menu );

        dato1 = getIntent().getStringExtra( "taller" );
        dato2 = getIntent().getStringExtra( "opc" );
        dato3 = getIntent().getStringExtra( "nombre" );
        tv1 = (TextView)findViewById( R.id.txtTaller );

        tv1.setText( dato3 );

        //Toast.makeText( this,"Opcion "+dato2, Toast.LENGTH_SHORT).show();

        dato2 = getIntent().getStringExtra( "opc" );

        txtDato = (TextView) findViewById( R.id.txtD3Tipo );
        if(dato2.equals( "1" )){
            titulo= "Ingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 83,67,63 ) );
        }if(dato2.equals( "2" )){
            titulo= "Reingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 237,156,23 ) );
        }

        img1= (ImageView) findViewById( R.id.imgValCC2 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d3Menu.this, d3ValCC.class );
                in.putExtra( "taller",dato1 );
                in.putExtra( "opc",dato2 );
                in.putExtra( "nombre",dato3 );
                startActivity( in );

            }
        } );

        img2= (ImageView) findViewById( R.id.imgValQR );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d3Menu.this, d3ValQR.class );
                in.putExtra( "taller",dato1 );
                in.putExtra( "opc",dato2 );
                in.putExtra( "nombre",dato3 );
                startActivity( in );

            }
        } );

        img3 = (ImageView) findViewById( R.id.imgB6 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        /*
        img4 = (ImageView) findViewById( R.id.imgHome15 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d3Menu.this, Menu.class);
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
            Intent m = new Intent(d3Menu.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d3Menu.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d3Menu.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d3Menu.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d3Menu.this, dia3.class);
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
