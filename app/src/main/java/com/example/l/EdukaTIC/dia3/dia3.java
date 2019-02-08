package com.example.l.EdukaTIC.dia3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.Talleres;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.loopj.android.http.*;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class dia3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ImageView img1,img2,img3;
    private Spinner spT;
    String dato,opc, nombre;


    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia3 );

        spT = (Spinner)findViewById( R.id.spTalleres );



        cliente = new AsyncHttpClient( );

        llenatSpinner();

        spT.setOnItemSelectedListener(this);



        img1 = (ImageView) findViewById( R.id.imgD3M1 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc="1";
                Intent in = new Intent( dia3.this, d3Menu.class );
                in.putExtra( "opc",opc );
                in.putExtra( "taller",dato );
                in.putExtra( "nombre",nombre );
                startActivity( in );
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgD3M2 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opc="2";
                Intent in = new Intent( dia3.this, d3Menu.class );
                in.putExtra( "opc", opc);
                in.putExtra( "taller",dato );
                in.putExtra( "nombre",nombre );
                startActivity( in );
            }
        } );



        img3 = (ImageView) findViewById( R.id.imgB5 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        /*
        img4 = (ImageView) findViewById( R.id.imgHome14 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dia3.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );

        */



    }

    private void llenatSpinner() {
        String url="http://edukatic.icesi.edu.co/complementos_apk/d3Taller.php";
        cliente.post( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    cargarSpinner(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        } );
    }

    private void cargarSpinner(String respuesta) {
        ArrayList<Talleres> lista = new ArrayList<Talleres>();

        try{
            JSONArray jsonArreglo = new JSONArray( respuesta );
            for(int i=0; i< jsonArreglo.length(); i++){

                Talleres t = new Talleres();
                t.setNombre(jsonArreglo.getJSONObject( i ).getString("idTaller")+" - "+ jsonArreglo.getJSONObject( i ).getString("nombreTaller"));
                lista.add( t );
            }

            ArrayAdapter <Talleres> a = new ArrayAdapter<Talleres>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spT.setAdapter( a );


        }catch (Exception e){

        }

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Texto
        nombre = parent.getItemAtPosition(position).toString();
        //Posicion
        dato = String.valueOf( parent.getItemIdAtPosition(position) );
        Toast.makeText( getApplicationContext(),nombre, Toast.LENGTH_LONG).show();
        //Toast.makeText( this,"Opcion: "+parent.getItemIdAtPosition(position), Toast.LENGTH_SHORT).show();



    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }


    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(dia3.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(dia3.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(dia3.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(dia3.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(dia3.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/



}
