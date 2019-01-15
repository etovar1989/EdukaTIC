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

/*
* Ojo te falta el dato del codigo del taller o definir codigos para talleres ;<
*
* */

public class d1Resultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    String opc,cc, dato1, tipo;
    TextView textoTipo;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img2, img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d1_resultado );

        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );

        //Recupero texto enviado
        tipo = getIntent().getStringExtra( "tipo" );

        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.tipoTexto2 );
        //Envio el texto recuperado del inten
        textoTipo.setText( tipo );

        if(tipo.equals( "Ingreso" )){
            textoTipo.setTextColor( Color.rgb( 222,119,9 ));
        }

        //
        //Toast.makeText( this,"OK "+opc, Toast.LENGTH_SHORT).show();
        //Toast.makeText( this,"OK "+cc, Toast.LENGTH_SHORT).show();



        rq = Volley.newRequestQueue(this);
        validarCedula();


        img3 = (ImageView) findViewById( R.id.imgB3 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


    }

    private void validarCedula( ) {
        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/d1.php?idU=" + cc +"&opc="+opc+"&dia=1";
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

        ImageView img1 = (ImageView) findViewById(R.id.imgLik);
        img1.setVisibility(View.INVISIBLE);

        ImageView img2 = (ImageView) findViewById(R.id.imgDislik);
        img2.setVisibility(View.INVISIBLE);

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            dato1 = ( jsonObject.optString( "validador" ) );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(dato1.equals("Ok")){
            Toast.makeText( this,"Ok, se permite el ingreso "+dato1, Toast.LENGTH_SHORT).show();
            img1.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText( this,"Hay mk no funciono "+dato1, Toast.LENGTH_SHORT).show();
            img2.setVisibility(View.VISIBLE);

        }


    }
}
