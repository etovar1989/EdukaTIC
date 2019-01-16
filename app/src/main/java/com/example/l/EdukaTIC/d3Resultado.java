package com.example.l.EdukaTIC;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    String opc,cc, taller,nombre;
    TextView texto, nom_taller;
    String dato1="";

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img2;

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


        img2 = (ImageView) findViewById( R.id.imgB7 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


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
                texto.setText( "Se ha realizado el primer registro con exito" );
            }if(dato1.equals( "2" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Se ha realizado el segundo registro con exito" );
            }if(dato1.equals( "3" )){
                //Toast.makeText( this,"El profe ya tiene el primer registro", Toast.LENGTH_SHORT).show();
                texto.setText( "El profe ya tiene el primer registro" );
                texto.setTextColor( Color.RED);
            }if(dato1.equals( "4" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                texto.setText( "Se ha realizado el segundo registro con exito\"" );
            }if(dato1.equals( "5" )){
                //Toast.makeText( this,"El profe ya tiene el segundo registro", Toast.LENGTH_SHORT).show();
                texto.setText( "El profe ya tiene el segundo registro" );
                texto.setTextColor( Color.RED);
            }if(dato1.equals( "6" )){
                //Toast.makeText( this,"El profe no esta registrado para el evento contatarce con el administrador", Toast.LENGTH_SHORT).show();
                texto.setText( "El profe no esta registrado para el este taller" );
                texto.setTextColor( Color.RED);
            }if(dato1.equals( "7" )){
                //Toast.makeText( this,"No hay datos", Toast.LENGTH_SHORT).show();
                texto.setText( "No hay datos" );
                texto.setTextColor( Color.RED);
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
