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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d3Resultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    String opc,cc, taller,nombre,titulo;
    TextView texto, nom_taller;
    String dato1="";
    TextView txtDato, def;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d3_resultado );


        nombre = getIntent().getStringExtra( "nombre" );

        nom_taller = (TextView)findViewById( R.id.txtNombreTaller );
        nom_taller.setText( nombre );

        //txtNombreTaller

        //Toast.makeText( this,"OK "+taller, Toast.LENGTH_SHORT).show();
        //Toast.makeText( this,"OK "+opc, Toast.LENGTH_SHORT).show();
        //Toast.makeText( this,"OK "+cc, Toast.LENGTH_SHORT).show();

        rq = Volley.newRequestQueue(this);
        validarCedula();


        img1 = (ImageView) findViewById( R.id.imgB7 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        /*
        img4 = (ImageView) findViewById( R.id.imgHome17 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d3Resultado.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );
        */

        opc = getIntent().getStringExtra( "opc" );

        txtDato = (TextView) findViewById( R.id.txtD3Tipo );
        def = (TextView)findViewById( R.id.txtDef3 );
        if(opc.equals( "1" )){
            titulo= "Ingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 83,67,63 ) );
            def.setText( "Mañana" );
        }if(opc.equals( "2" )){
            titulo= "Reingreso";
            txtDato.setText( titulo );
            txtDato.setTextColor( Color.rgb( 237,156,23 ) );
            def.setText( "Tarde" );
        }




    }

    private void validarCedula( ) {
        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );
        taller = getIntent().getStringExtra( "taller" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/d3Validacion.php?idU=" + cc +"&taller="+taller+"&opc="+opc;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( this,"Error contactate con el administrador", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onResponse(JSONObject response) {

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            dato1 = ( jsonObject.optString( "validador" ) );
            //Toast.makeText( this,dato1, Toast.LENGTH_SHORT).show();
            texto = (TextView)findViewById( R.id.txtRespuesta );

            if(dato1.equals( "1" )){
                //Toast.makeText( this,"Se ha realizado el primer registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Registro exitoso, este profe puede ingresar a el taller" );

            }if(dato1.equals( "2" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Registro exitoso, este profe puede reingresar a el taller" );

            }if(dato1.equals( "3" )){
                //Toast.makeText( this,"El profe ya tiene el primer registro", Toast.LENGTH_SHORT).show();
                texto.setText( "Upss no se realizó el registro, este profe ya tiene registrado el ingreso a el taller, si no es correcto, validar con el personal de Eduteka." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "4" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Registro exitoso, este profe puede ingresar a el taller, pero no asistió a la primera parte del taller" );

            }if(dato1.equals( "5" )){
                //Toast.makeText( this,"El profe ya tiene el segundo registro", Toast.LENGTH_SHORT).show();
                texto.setText( "Upss no se realizó el registro, este profe ya tiene registrado el ingreso y el reingreso a el taller, validar con el personal de Eduteka." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "6" )){
                //Toast.makeText( this,"El profe no esta registrado para el evento contatarce con el administrador", Toast.LENGTH_SHORT).show();
                texto.setText( "Upss no se realizó el registro, este profe ya tiene registrado el reingreso y el ingreso a el taller, validar con el personal de Eduteka." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "7" )){
                //Toast.makeText( this,"No hay datos", Toast.LENGTH_SHORT).show();
                texto.setText( "Upss no se realizó el registro, el profe no se registro en la mañana, validar con el personal de Eduteka." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "8" )){
                texto.setText( "Upss no se realizó el registro, este profe ya tiene registrado el reingreso, validar con el personal de Eduteka." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "20" )){
                texto.setText( "El profe no esta registrado para el taller contatarce con el administrador." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "21" )){
                texto.setText( "No hay datos." );
                texto.setTextColor( Color.RED);
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }



    }


    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(d3Resultado.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d3Resultado.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d3Resultado.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d3Resultado.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d3Resultado.this, dia3.class);
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
