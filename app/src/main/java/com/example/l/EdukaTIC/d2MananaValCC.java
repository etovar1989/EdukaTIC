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

public class d2MananaValCC extends AppCompatActivity {

    EditText cajaCC;
    Button d2ConsultarMCC;
    String opc,titulo;
    ImageView img1,img4;
    TextView txtDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_manana_val_cc );


        //busco caja de texto para obtener los datos de esta
        cajaCC = (EditText)findViewById( R.id.txtD2MCC );
        opc = getIntent().getStringExtra( "opc" );

        txtDato = (TextView) findViewById( R.id.txtTipo2 );
        if(opc.equals( "1" )){
            titulo= "Ingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 83,67,63 ) );
        }if(opc.equals( "2" )){
            titulo= "Reingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 237,156,23 ) );
        }

        d2ConsultarMCC = (Button) findViewById( R.id.btnD2MConsultarCC );
        d2ConsultarMCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( d2MananaValCC.this, d2MananaResultado.class );
                in.putExtra( "cc",cajaCC.getText().toString());
                in.putExtra( "opc",opc );
                startActivity( in );
                cajaCC.setText( "" );

            }
        } );



        img1 = (ImageView) findViewById( R.id.imgB10 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
/*
        img4 = (ImageView) findViewById( R.id.imgHome8 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2MananaValCC.this, Menu.class);
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
            Intent m = new Intent(d2MananaValCC.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2MananaValCC.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2MananaValCC.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2MananaValCC.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2MananaValCC.this, dia3.class);
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
