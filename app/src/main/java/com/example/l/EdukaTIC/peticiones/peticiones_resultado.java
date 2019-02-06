package com.example.l.EdukaTIC.peticiones;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;

import org.json.JSONObject;

public class peticiones_resultado extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    ImageView img1,img2,img3;

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_peticiones_resultado );

        rq = Volley.newRequestQueue(this);
        validarPeticion();

        tv1 = (TextView)findViewById( R.id.txtPresultado );
        String peticionRespuesta = getIntent().getStringExtra( "estado" );
        if(peticionRespuesta.equals( "1" )){
            tv1.setText("Se resolviò la solicitud");
            tv1.setTextColor( Color.rgb( 84,192,18 ));

        }if(peticionRespuesta.equals( "2" )){
            tv1.setText("Se cancelo la solicitud");
            tv1.setTextColor( Color.rgb( 214,20,20 ));
        }


        img1 = (ImageView) findViewById( R.id.imgPeticion );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( peticiones_resultado.this, peticiones_menu.class );
                startActivity( in );
                finish();

            }
        } );

        img2 = (ImageView) findViewById( R.id.imgConfirm );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( peticiones_resultado.this, peticiones_consulta.class );
                in.putExtra( "estado","1");
                startActivity( in );
                finish();

            }
        } );

        img3 = (ImageView) findViewById( R.id.imgCancel );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( peticiones_resultado.this, peticiones_consulta.class );
                in.putExtra( "estado","2");
                startActivity( in );
                finish();

            }
        } );




    }

    private void validarPeticion( ) {
        String dato = getIntent().getStringExtra( "idP" );
        String peticionRespuesta = getIntent().getStringExtra( "estado" );
        String nota = getIntent().getStringExtra( "nota" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_detalle_resultado.php?idP=" + dato +
                "&estado=" + peticionRespuesta + "&nota = " + nota;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }



    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }


    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(peticiones_resultado.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(peticiones_resultado.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(peticiones_resultado.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(peticiones_resultado.this, dia3.class);
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
