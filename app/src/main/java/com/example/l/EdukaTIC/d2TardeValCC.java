package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class d2TardeValCC extends AppCompatActivity {

    EditText cajaCC;
    Button consultarCC;
    String taller, dato;
    ImageView img1,img2;
    TextView textoTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_tarde_val_cc );

        //busco caja de texto para obtener los datos de esta
        cajaCC = (EditText)findViewById( R.id.txtD2ValCC );
        //Recupero texto enviado
        taller = getIntent().getStringExtra( "taller" );
        dato = getIntent().getStringExtra( "nombre" );
        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.txtTipo4 );
        //Envio el texto recuperado del inten
        textoTipo.setText( dato );

        //Toast.makeText( this,"Opcion"+taller, Toast.LENGTH_SHORT).show();

        consultarCC = (Button) findViewById( R.id.btnD2TConsultarCC );
        consultarCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent in = new Intent( d2TardeValCC.this, d2TardeResultado.class );
                in.putExtra( "cc",cajaCC.getText().toString());
                in.putExtra( "taller",taller );
                in.putExtra( "nombre",dato );
                startActivity( in );
                cajaCC.setText( "" );

            }
        } );

        img2 = (ImageView) findViewById( R.id.imgB14 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }
}
