package com.example.l.EdukaTIC;

import android.content.Intent;
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

public class d2TardeResultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{

    String cc, dato1,taller, nombre;
    TextView textoTipo, resultado;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_tarde_resultado );


        textoTipo = (TextView) findViewById( R.id.txtConferenciaD2T );
        nombre = getIntent().getStringExtra( "nombre" );

        textoTipo.setText( nombre);

        rq = Volley.newRequestQueue(this);
        validarCedula();


        img1 = (ImageView) findViewById( R.id.imgB16 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        img4 = (ImageView) findViewById( R.id.imgHome13 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2TardeResultado.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );

    }
    private void validarCedula() {


        cc = getIntent().getStringExtra( "cc" );
        taller = getIntent().getStringExtra( "taller" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/d2Tarde.php?idU="+cc+"&conferencia="+taller;
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
        resultado = (TextView)findViewById( R.id.txtResultadoD2T );

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            dato1 = ( jsonObject.optString( "validador" ) );

            if(dato1.equals( "1" )){
                resultado.setText( "Registro exitoso, esta es la primera conferencia paralela a la que ingresa el profe." );
            }if(dato1.equals( "2" )){
                resultado.setText( "Registro exitoso, esta es la primera conferencia paralela a la que ingresa el profe." );
            }if(dato1.equals( "3" )){
                resultado.setText( "Registro exitoso, esta es la segunda conferencia paralela a la que ingresa el profe." );
            }if(dato1.equals( "4" )){
                resultado.setText( "Registro exitoso, esta es la tarcera conferencia paralela a la que ingresa el profe." );
            }if(dato1.equals( "5" )){
                resultado.setText( "Upss no se realizó el registro, el profe ya asistió a todas las paralelas del día, si esto no es correcto por favor contactarse con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);

            }if(dato1.equals( "20" )){
                resultado.setText( "El profe no esta registrado para la conferencia, contatarce con el administrador." );
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
