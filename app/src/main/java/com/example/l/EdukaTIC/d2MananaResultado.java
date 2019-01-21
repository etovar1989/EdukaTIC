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

public class d2MananaResultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{

    String opc,cc, dato1;
    TextView textoTipo, resultado;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img2, img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_manana_resultado );

        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );

        textoTipo = (TextView) findViewById( R.id.txtIngRein );

        if(opc.equals( "1" )){
            textoTipo.setTextColor( Color.rgb( 222,119,9 ));
            textoTipo.setText( "Ingreso" );
        }else{
            textoTipo.setText( "Reingreso" );
        }
        rq = Volley.newRequestQueue(this);
        validarCedula();


        img3 = (ImageView) findViewById( R.id.imgB11 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
    }

    private void validarCedula() {

        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/d2Manana.php?idU=" + cc +"&opc="+opc+"&dia=2";
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
        resultado = (TextView)findViewById( R.id.txtResultadoD2M );

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            dato1 = ( jsonObject.optString( "validador" ) );

            if(dato1.equals( "1" )){
                //Toast.makeText( this,"Se ha realizado el primer registro con exito", Toast.LENGTH_SHORT).show();
                resultado.setText( "Este profe puede ingresar a la conferencia" );
            }if(dato1.equals( "2" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                resultado.setText( "Este profe puede reingresar a la conferencia" );
            }if(dato1.equals( "3" )){
                //Toast.makeText( this,"El profe ya tiene el primer registro", Toast.LENGTH_SHORT).show();
                resultado.setText( "Este profe ya tiene registrado el ingreso a la conferencia, si no es correcto, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "4" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                resultado.setText( "Este profe puede ingresar a la conferencia, pero no asistió a la primera parte de la conferencia" );
            }if(dato1.equals( "5" )){
                //Toast.makeText( this,"El profe ya tiene el segundo registro", Toast.LENGTH_SHORT).show();
                resultado.setText( "Este profe ya tiene registrado el ingreso y el reingreso a la conferencia, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "6" )){
                //Toast.makeText( this,"El profe no esta registrado para el evento contatarce con el administrador", Toast.LENGTH_SHORT).show();
                resultado.setText( "Este profe ya tiene registrado el reingreso y el ingreso a la conferencia, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "7" )){
                //Toast.makeText( this,"No hay datos", Toast.LENGTH_SHORT).show();
                resultado.setText( "No se puede hacer el registro de ingreso por que, primero hizo en registro de reingreso, contactarce con el admistrador del sistema" );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "8" )){
                resultado.setText( "No se puede hacer el registro de reingreso por que, ya se realizo este." );
                resultado.setTextColor( Color.RED);

            }if(dato1.equals( "20" )){
                resultado.setText( "El profe no esta registrado para el evento contatarce con el administrador." );
                resultado.setTextColor( Color.RED);

            }if(dato1.equals( "21" )){
                resultado.setText( "No hay datos." );
                resultado.setTextColor( Color.RED);
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
