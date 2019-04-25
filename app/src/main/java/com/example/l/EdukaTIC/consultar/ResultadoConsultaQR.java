package com.example.l.EdukaTIC.consultar;

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
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultadoConsultaQR extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;

    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;

    String datosCC="";
    String nombre = "";
    String taller = "";
    String salon = "";
    String requisitos = "";
    String paralela1 = "";
    String lugar1 = "";
    String paralela2 = "";
    String lugar2 = "";
    String paralela3 = "";
    String lugar3 = "";

    ImageView img1,img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_resultado_consulta_qr );



        img1 = (ImageView) findViewById( R.id.imgBk2 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgScan );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( ResultadoConsultaQR.this, consultaQR.class );
                startActivity( in );
                finish();

            }
        } );

        rq = Volley.newRequestQueue(this);
        validarCedula();

    }

    private void validarCedula( ) {
        String dato = getIntent().getStringExtra( "cc" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_usuario.php?idU=" + dato;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        datosCC = getIntent().getStringExtra( "cc" );
        Toast.makeText( this,"No esta registrada la cedula " + datosCC, Toast.LENGTH_SHORT).show();
        Intent in = new Intent( ResultadoConsultaQR.this, pantallaError.class );
        in.putExtra( "cc",datosCC );
        startActivity( in );
        finish();

    }

    @Override
    public void onResponse(JSONObject response) {

        //Toast.makeText( getContext(),"OK ", Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            nombre = ( jsonObject.optString( "nombreU" ) );
            taller = ( jsonObject.optString( "taller" ) );
            salon = ( jsonObject.optString( "salon" ) );
            requisitos = ( jsonObject.optString( "requisitos" ) );
            paralela1 = ( jsonObject.optString( "paralela1" ) );
            lugar1 = ( jsonObject.optString( "lugar1" ) );
            paralela2 = ( jsonObject.optString( "paralela2" ) );
            lugar2 = ( jsonObject.optString( "lugar2" ) );
            paralela3 = ( jsonObject.optString( "paralela3" ) );
            lugar3 = ( jsonObject.optString( "lugar3" ) );

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Toast.makeText( this,"OK "+nombre, Toast.LENGTH_SHORT).show();


        tv1 = (TextView)findViewById( R.id.txtConCQN  );
        tv2 = (TextView)findViewById( R.id.txtConCQT );
        tv3 = (TextView)findViewById( R.id.txtConCQU );
        tv4 = (TextView)findViewById( R.id.txtConCQR );
        tv5 = (TextView)findViewById( R.id.txtConCQP1 );
        tv6 = (TextView)findViewById( R.id.txtConCQL1 );
        tv7 = (TextView)findViewById( R.id.txtConCQP2 );
        tv8 = (TextView)findViewById( R.id.txtConCQL2 );
        tv9 = (TextView)findViewById( R.id.txtConCQP3 );
        tv10 = (TextView)findViewById( R.id.txtConCQL3 );




        tv1.setText(nombre);
        tv2.setText(taller);
        tv3.setText(salon);
        tv4.setText(requisitos);
        tv5.setText(paralela1);
        tv6.setText(lugar1);
        tv7.setText(paralela2);
        tv8.setText(lugar2);
        tv9.setText(paralela3);
        tv10.setText(lugar3);







    }

    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            final Intent m = new Intent(ResultadoConsultaQR.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            return true;
        }
        if(id==R.id.btnDia1){
            final Intent m = new Intent(ResultadoConsultaQR.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            final Intent m = new Intent(ResultadoConsultaQR.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            final Intent m = new Intent(ResultadoConsultaQR.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/

}
