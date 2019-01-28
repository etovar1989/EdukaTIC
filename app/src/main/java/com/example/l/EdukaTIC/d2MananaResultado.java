package com.example.l.EdukaTIC;

import android.content.Intent;
import android.graphics.Color;
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

public class d2MananaResultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{

    String opc,cc, dato1;
    TextView textoTipo, resultado;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img3,img4;


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

        img4 = (ImageView) findViewById( R.id.imgHome9 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2MananaResultado.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
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
                resultado.setText( "Registro exitoso, este profe puede ingresar a la conferencia" );
            }if(dato1.equals( "2" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                resultado.setText( "Registro exitoso, este profe puede reingresar a la conferencia" );
            }if(dato1.equals( "3" )){
                //Toast.makeText( this,"El profe ya tiene el primer registro", Toast.LENGTH_SHORT).show();
                resultado.setText( "Upss no se realizó el registro, este profe ya tiene registrado el ingreso a la conferencia, si no es correcto, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "4" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                resultado.setText( "Registro exitoso, este profe puede ingresar a la conferencia, pero no asistió a la primera parte de la conferencia" );
            }if(dato1.equals( "5" )){
                //Toast.makeText( this,"El profe ya tiene el segundo registro", Toast.LENGTH_SHORT).show();
                resultado.setText( "Upss no se realizó el registro, este profe ya tiene registrado el ingreso y el reingreso a la conferencia, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "6" )){
                //Toast.makeText( this,"El profe no esta registrado para el evento contatarce con el administrador", Toast.LENGTH_SHORT).show();
                resultado.setText( "Upss no se realizó el registro, este profe ya tiene registrado el reingreso y el ingreso a la conferencia, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "7" )){
                //Toast.makeText( this,"No hay datos", Toast.LENGTH_SHORT).show();
                resultado.setText( "Upss no se realizó el registro, el profe no se registro en la mañana, validar con el personal de Eduteka." );
                resultado.setTextColor( Color.RED);
            }if(dato1.equals( "8" )){
                resultado.setText( "Upss no se realizó el registro, este profe ya tiene registrado el reingreso, validar con el personal de Eduteka." );
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



    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(d2MananaResultado.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2MananaResultado.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2MananaResultado.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2MananaResultado.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2MananaResultado.this, dia3.class);
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
