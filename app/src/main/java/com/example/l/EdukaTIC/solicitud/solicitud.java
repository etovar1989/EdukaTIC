package com.example.l.EdukaTIC.solicitud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.l.EdukaTIC.R;

public class solicitud extends AppCompatActivity {

    ImageView img1,img2;
    Spinner opciones;
    String nombre,valorSp;
    EditText ubicacion,sol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_solicitud );

        ubicacion = (EditText)findViewById( R.id.edtUbicacion );
        sol = (EditText)findViewById( R.id.edtSolicitud );
        img1 = (ImageView)findViewById( R.id.imgSendSolicitud ) ;

        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( TextUtils.isEmpty(ubicacion.getText())){
                    ubicacion.setError( "Campo reqierodo" );
                }if( TextUtils.isEmpty(sol.getText())){
                    sol.setError( "Campo reqierodo" );
                }else {
                    Intent in = new Intent( solicitud.this, solicitud_resultado.class );
                    in.putExtra( "para",valorSp );
                    in.putExtra( "ubicacion",ubicacion.getText().toString() );
                    in.putExtra( "solicitud",sol.getText().toString() );
                    startActivity( in );
                    finish();

                }


            }
        } );



        opciones = (Spinner)findViewById( R.id.spNombres );

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,R.array.opciones,android.R.layout.simple_spinner_item );
        opciones.setAdapter( adapter );

        opciones.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nombre = adapterView.getItemAtPosition(i).toString();
                //Posicion
                valorSp = String.valueOf( adapterView.getItemIdAtPosition(i) );
                //Toast.makeText( getApplicationContext(),nombre, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


        img2 = (ImageView) findViewById( R.id.imgSoliBack );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
    }



}
