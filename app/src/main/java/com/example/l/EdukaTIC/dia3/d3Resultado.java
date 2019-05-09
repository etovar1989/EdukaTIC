package com.example.l.EdukaTIC.dia3;

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
import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.consultar.validarUsuarios;

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

    ImageView img1;

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
        cc = getIntent().getStringExtra( "cc" );
        taller = getIntent().getStringExtra( "taller" );
        opc = getIntent().getStringExtra( "opc" );
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
                texto.setText( "Se realizo el registro del profe para el taller, aunque primero se realizo el registro por la mañana -_-." );

            }if(dato1.equals( "4" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Uups!! No realizo el registro porque el profe ya fue realizado en otra oportunidad -_-." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "5" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Uups!! No realizo el registro porque el profe ya tiene los dos registros -_-." );
                texto.setTextColor( Color.RED);

            }if(dato1.equals( "20" )){
                texto.setText( "Uups!! No realizo el registro porque el profe no está inscrito a este taller -_-." );
                texto.setTextColor( Color.RED);
            }if(dato1.equals( "21" )){
                texto.setText( "Uups!! El asistente no realizo el registro general, por favor dirígelo a registro general -_-." );
                texto.setTextColor( Color.RED);
            }if(dato1.equals( "22" )){
                texto.setText( "No hay datos -_-." );
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

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/




}
