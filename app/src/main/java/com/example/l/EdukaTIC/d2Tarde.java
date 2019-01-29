package com.example.l.EdukaTIC;

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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class d2Tarde extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ImageView img1,img2,img4;
    private Spinner spT;
    String dato, nombre;

    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_tarde );

        spT = (Spinner)findViewById( R.id.spTalleres2 );

        cliente = new AsyncHttpClient( );

        llenatSpinner();

        spT.setOnItemSelectedListener(this);




        img1 = (ImageView) findViewById( R.id.imgD2TValidar );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( d2Tarde.this, d2TardeMenu.class );
                in.putExtra( "taller",dato );
                in.putExtra( "nombre",nombre );
                startActivity( in );
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgB12 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        /*
        img4 = (ImageView) findViewById( R.id.imgHome10 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2Tarde.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );
*/


    }

    private void llenatSpinner() {
        String url="http://edukatic.icesi.edu.co/complementos_apk/d2Conferencia.php?";
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
                t.setNombre(jsonArreglo.getJSONObject( i ).getString("idConferencia")+" - "+ jsonArreglo.getJSONObject( i ).getString("nombreConferencia"));
                lista.add( t );
            }

            ArrayAdapter<Talleres> a = new ArrayAdapter<Talleres>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spT.setAdapter( a );


        }catch (Exception e){

        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Texto
        nombre = parent.getItemAtPosition(position).toString();
        //Posicion
        dato = String.valueOf( parent.getItemIdAtPosition(position) );
        Toast.makeText( getApplicationContext(),nombre, Toast.LENGTH_LONG).show();
        //Toast.makeText( this,"Opcion: "+parent.getItemIdAtPosition(position), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(d2Tarde.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2Tarde.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2Tarde.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2Tarde.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2Tarde.this, dia3.class);
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
