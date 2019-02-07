package com.example.l.EdukaTIC.peticiones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class peticiones_datalle extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    private TextView tv1,tv2,tv3;

    String monitorName="";
    String monitorUbicacion = "";
    String monitorSolicitud = "";
    String idP = "";
    String opcEstado = "";
    String notas="";
    ImageView img1,img2,img3;
    EditText nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_peticiones_datalle );


        rq = Volley.newRequestQueue(this);
        validarPeticion();

        idP = getIntent().getStringExtra( "idP" );
        opcEstado = getIntent().getStringExtra( "estado" );

        nota = (EditText)findViewById( R.id.edtNota );
        notas = nota.getText().toString();

        img1 = (ImageView) findViewById( R.id.imgPOk );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( peticiones_datalle.this, peticiones_resultado.class );
                in.putExtra( "estado","1");
                in.putExtra( "idP",idP );
                in.putExtra( "nota", nota.getText().toString() );
                startActivity( in );
                finish();

            }
        } );

        img2 = (ImageView) findViewById( R.id.imgPCancel );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( peticiones_datalle.this, peticiones_resultado.class );
                in.putExtra( "estado","2");
                in.putExtra( "idP",idP );
                in.putExtra( "nota",nota.getText().toString() );
                startActivity( in );
                finish();

            }
        } );



        img3 = (ImageView) findViewById( R.id.imgPBack );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }

    private void validarPeticion( ) {
        String dato = getIntent().getStringExtra( "idP" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_detalle_solicitud.php?idP=" + dato;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( this,"Error ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            monitorName = ( jsonObject.optString( "nombre" ) );
            monitorUbicacion = ( jsonObject.optString( "ubicacion" ) );
            monitorSolicitud = ( jsonObject.optString( "solicitud" ) );


        } catch (JSONException e) {
            e.printStackTrace();
        }

        tv1 = (TextView)findViewById( R.id.txtMonitorName );
        tv2 = (TextView)findViewById( R.id.txtMonitorUbicacion );
        tv3 = (TextView)findViewById( R.id.txtMonitorSolicitud );

        tv1.setText(monitorName);
        tv2.setText(monitorUbicacion);
        tv3.setText(monitorSolicitud);


    }


    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(peticiones_datalle.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(peticiones_datalle.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(peticiones_datalle.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(peticiones_datalle.this, dia3.class);
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
