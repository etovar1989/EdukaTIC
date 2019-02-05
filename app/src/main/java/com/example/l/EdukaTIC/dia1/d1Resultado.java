package com.example.l.EdukaTIC.dia1;

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
import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.consultar.validarUsuarios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
* Ojo te falta el dato del codigo del taller o definir codigos para talleres ;<
*
* */

public class d1Resultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    String opc,cc, dato1;
    TextView textoTipo,resultadoD1;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img2,img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d1_resultado );

        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );

        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.tipoTexto2 );


        if(opc.equals( "1" )){
            textoTipo.setTextColor( Color.rgb( 222,119,9 ));
            textoTipo.setText( "Ingreso" );
        }else{
            textoTipo.setText( "Reingreso" );
        }

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
        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            dato1 = ( jsonObject.optString( "validador" ) );
            resultadoD1 = (TextView)findViewById( R.id.txtResultadoD1 );

            if(dato1.equals( "1" )){
                //Toast.makeText( this,"Se ha realizado el primer registro con exito", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Registro exitoso, este profe puede ingresar a la conferencia." );
            }if(dato1.equals( "2" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Registro exitoso, este profe puede reingresar a la conferencia." );
            }if(dato1.equals( "3" )){
                //Toast.makeText( this,"El profe ya tiene el primer registro", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Upss no se realizó el registro, este profe ya tiene registrado el ingreso a la conferencia, si no es correcto, validar con el personal de Eduteka." );
                resultadoD1.setTextColor( Color.RED);
            }if(dato1.equals( "4" )){
                //Toast.makeText( this,"Se ha realizado el segundo registro con exito", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Registro exitoso, este profe puede ingresar a la conferencia, pero no asistió a la primera parte de la conferencia" );
            }if(dato1.equals( "5" )){
                //Toast.makeText( this,"El profe ya tiene el segundo registro", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Upss no se realizó el registro, este profe ya tiene registrado el ingreso y el reingreso a la conferencia, validar con el personal de Eduteka." );
                resultadoD1.setTextColor( Color.RED);
            }if(dato1.equals( "6" )){
                //Toast.makeText( this,"El profe no esta registrado para el evento contatarce con el administrador", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Upss no se realizó el registro, este profe ya tiene registrado el reingreso y el ingreso a la conferencia, validar con el personal de Eduteka." );
                resultadoD1.setTextColor( Color.RED);
            }if(dato1.equals( "7" )){
                //Toast.makeText( this,"No hay datos", Toast.LENGTH_SHORT).show();
                resultadoD1.setText( "Upss no se realizó el registro, el profe no se registro en la mañana, validar con el personal de Eduteka." );
                resultadoD1.setTextColor( Color.RED);
            }if(dato1.equals( "8" )){
                resultadoD1.setText( "Upss no se realizó el registro, este profe ya tiene registrado el reingreso, validar con el personal de Eduteka." );
                resultadoD1.setTextColor( Color.RED);

            }if(dato1.equals( "20" )){
                resultadoD1.setText( "El profe no esta registrado para la conferencia, contatarce con el administrador." );
                resultadoD1.setTextColor( Color.RED);

            }if(dato1.equals( "21" )){
                resultadoD1.setText( "No hay datos." );
                resultadoD1.setTextColor( Color.RED);
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
            Intent m = new Intent(d1Resultado.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d1Resultado.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){
            Intent m = new Intent(d1Resultado.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d1Resultado.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d1Resultado.this, dia3.class);
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
