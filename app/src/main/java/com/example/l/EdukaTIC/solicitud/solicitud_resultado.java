package com.example.l.EdukaTIC.solicitud;

import android.content.Intent;
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
import com.example.l.EdukaTIC.User;
import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class solicitud_resultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{


    String idMonitor;
    String para;
    String ubicacion;
    String sol;
    String respuesta;
    TextView r;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1;

    User usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_solicitud_resultado );

        rq = Volley.newRequestQueue(this);
        enviarSolicitud();

        img1 = (ImageView) findViewById( R.id.imgSolResBK );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


    }

    private void enviarSolicitud() {

        usuario = new User();
        idMonitor = usuario.getIdU();
        para = getIntent().getStringExtra( "para" );
        ubicacion = getIntent().getStringExtra( "ubicacion" );
        sol = getIntent().getStringExtra( "solicitud" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/solicitud.php?idU="+idMonitor+
                "&para="+para+"&ubicacion="+ubicacion+"&solicitud="+sol;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( this,"Fallo", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText( this,"Listo papa", Toast.LENGTH_LONG).show();
        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        r = (TextView)findViewById( R.id.txtSolRes );
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            respuesta =  jsonObject.optString( "validador" );

            if(respuesta.equals( "1" )){
                r.setText( "Se creò la solicitud" );
            }if(respuesta.equals( "21" )){
                r.setText( "Upss, no Se creò la solicitud" );
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
            Intent m = new Intent(solicitud_resultado.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(solicitud_resultado.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){
            Intent m = new Intent(solicitud_resultado.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(solicitud_resultado.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(solicitud_resultado.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/


}
