package com.example.l.EdukaTIC.consultar;

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
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pantallaError extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    String val="";
    String dato="";
    TextView msj,msjNA,msjIdT,msjP1,msjP2,msjP3;
    ImageView img1;
    String nombreApellido="";
    String idTaller="";
    String nombreTaller="";
    String idP1="";
    String idP2="";
    String idP3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pantalla_error );

        rq = Volley.newRequestQueue(this);
        validarCedula();
        msj = (TextView)findViewById( R.id.txtmsjError );
        msjNA = (TextView)findViewById( R.id.txtNombreApellido );
        msjIdT = (TextView)findViewById( R.id.txtEidT );
        msjP1 = (TextView)findViewById( R.id.txtEP1 );
        msjP2 = (TextView)findViewById( R.id.txtEP2 );
        msjP3 = (TextView)findViewById( R.id.txtEP3 );
        img1 = (ImageView) findViewById( R.id.imgB15 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }




    private void validarCedula() {
        dato = getIntent().getStringExtra( "cc" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_error.php?idU=" + dato;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);


    }

    @Override
    public void onErrorResponse(VolleyError error) {

        //Toast.makeText( this,"No esta registrada la cedula "+dato, Toast.LENGTH_LONG).show();

        msj.setText( "No esta registrada esta cedula para el evento" );

    }

    @Override
    public void onResponse(JSONObject response) {

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            val = ( jsonObject.optString( "val" ) );
            nombreApellido = ( jsonObject.optString( "nombre" ) );
            idTaller = ( jsonObject.optString( "idTaller" ) );
            nombreTaller = ( jsonObject.optString( "nombreTaller" ) );
            idP1 = ( jsonObject.optString( "D2CP1" ) );
            idP2 = ( jsonObject.optString( "D2CP2" ) );
            idP3 = ( jsonObject.optString( "D2CP3" ) );
            //Toast.makeText( this,"Estado "+ val, Toast.LENGTH_LONG).show();
            if(val.equals( "1" )){
                msjNA.setText(nombreApellido );
                msj.setText( "Upss, error el usuario no está registrado en ninguna paralela, por favor, dirigir el profe a un punto de registro o comunicarse con el personal de Eduteka. " );
                msjIdT.setText( idTaller + " - " + nombreTaller);
                msjIdT.setTextColor( Color.rgb( 143,209,21 ) );
            }
            if(val.equals( "2" )){
                msjNA.setText(nombreApellido );
                msj.setText( "Upss, error el usuario no está registrado en ningún taller, por favor, dirigir el profe a un punto de registro o comunicarse con el personal de Eduteka." );
                msjP1.setText( idP1 );
                msjP1.setTextColor( Color.rgb( 143,209,21 ) );
                msjP2.setText( idP2 );
                msjP2.setTextColor( Color.rgb( 143,209,21 ) );
                msjP3.setText( idP3 );
                msjP3.setTextColor( Color.rgb( 143,209,21 ) );
            }
            if(val.equals( "3" )){
                msjNA.setText(nombreApellido );
                msj.setText( "Upss, error el usuario no esta registrado ni en taller ni en conferencias, por favor contactarse con el persona de Eduteka." );
            }
            if(val.equals( "21" )){
                msjNA.setText("NN");
                msjNA.setTextColor( Color.RED );
                msj.setText( "Upss, error el usuario no esta registrado en el evento, por favor contactarse con el persona de Eduteka." );
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
            final Intent m = new Intent(pantallaError.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            return true;
        }
        if(id==R.id.btnDia1){
            final Intent m = new Intent(pantallaError.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            final Intent m = new Intent(pantallaError.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            final Intent m = new Intent(pantallaError.this, dia3.class);
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
