package com.example.l.EdukaTIC;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultadoConsultaQR extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16;

    String datosCC="";
    String nombre = "";
    String taller = "";
    String ubicacion = "";
    String requisitos = "";
    String idTaller = "";
    String TallerM1 = "";
    String TallerM2 = "";
    String GeneralM1 = "";
    String GeneralM2 = "";
    String GM1 = "";
    String GM2 = "";
    String GT1 = "";
    String GT2 = "";
    String GT3 = "";
    String D2CP1 = "";
    String D2CP2 = "";
    String D2CP3 = "";
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
        Toast.makeText( this,"No esta registrada la cedula " + datosCC, Toast.LENGTH_LONG).show();
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
            taller = ( jsonObject.optString( "nombreTaller" ) );
            ubicacion = ( jsonObject.optString( "salaTaller" ) );
            requisitos = ( jsonObject.optString( "reqTaller" ) );
            idTaller = ( jsonObject.optString( "idTaller" ) );
            TallerM1 = ( jsonObject.optString( "tallerM1" ) );
            TallerM2 = ( jsonObject.optString( "tallerM2" ) );
            GeneralM1 = ( jsonObject.optString( "GeneralM1" ) );
            GeneralM2 = ( jsonObject.optString( "GeneralM2" ) );
            GM1 = ( jsonObject.optString( "GM1" ) );
            GM2 = ( jsonObject.optString( "GM2" ) );
            GT1 = ( jsonObject.optString( "GT1" ) );
            GT2 = ( jsonObject.optString( "GT2" ) );
            GT3 = ( jsonObject.optString( "GT3" ) );
            D2CP1 = ( jsonObject.optString( "D2CP1" ) );
            D2CP2 = ( jsonObject.optString( "D2CP2" ) );
            D2CP3 = ( jsonObject.optString( "D2CP3" ) );

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Toast.makeText( this,"OK "+nombre, Toast.LENGTH_SHORT).show();

        tv1 = (TextView)findViewById( R.id.textoNombre );
        tv2 = (TextView)findViewById( R.id.textoTaller );
        tv3 = (TextView)findViewById( R.id.textoUbicacion );
        tv4 = (TextView)findViewById( R.id.textoRequisito );
        tv5 = (TextView)findViewById( R.id.txtMV );
        tv6 = (TextView)findViewById( R.id.txtTV );
        tv7 = (TextView)findViewById( R.id.txtMM );
        tv8 = (TextView)findViewById( R.id.txtTM );
        tv9 = (TextView)findViewById( R.id.txtMJ1 );
        tv10 = (TextView)findViewById( R.id.txtMJ2 );
        tv11 = (TextView)findViewById( R.id.txtTJ1 );
        tv12 = (TextView)findViewById( R.id.txtTJ2 );
        tv13 = (TextView)findViewById( R.id.txtTJ3 );
        tv14 = (TextView)findViewById( R.id.txtCP1 );
        tv15 = (TextView)findViewById( R.id.txtCP2 );
        tv16 = (TextView)findViewById( R.id.txtCP3 );





        tv1.setText(nombre);
        tv2.setText(idTaller+" - "+taller);
        tv3.setText(ubicacion);
        tv4.setText(requisitos);
        tv5.setText(TallerM1);
        tv6.setText(TallerM2);
        tv7.setText(GeneralM1);
        tv8.setText(GeneralM2);
        tv9.setText(GM1);
        tv10.setText(GM2);
        tv11.setText(GT1);
        tv12.setText(GT2);
        tv13.setText(GT3);
        tv14.setText(D2CP1);
        tv15.setText(D2CP2);
        tv16.setText(D2CP3);




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
        if(id==R.id.btnSalir){
            finish();
            System.exit( 0 );
        }
        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/

}
