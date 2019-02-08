package com.example.l.EdukaTIC.solicitud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.User;
import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.peticiones.Model;
import com.example.l.EdukaTIC.peticiones.PeticionAdapter;
import com.example.l.EdukaTIC.peticiones.listDatails;
import com.example.l.EdukaTIC.peticiones.peticiones_resultado;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class consulta_solicitud extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Model> models;
    private PeticionAdapter peticionAdapter;
    private AsyncHttpClient cliente;

    User usuario = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulta_solicitud );

        cliente = new AsyncHttpClient();

        llenarLista();

    }


    private void llenarLista() {

        final String dato = getIntent().getStringExtra( "estado" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_monitor_solicitud.php?idU="+ usuario.getIdU();
        cliente.post( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    cargarPeticiones(new String(responseBody));

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText( consulta_solicitud.this,"Fallo",Toast.LENGTH_SHORT ).show();
                finish();

            }
        } );
    }

    private void cargarPeticiones(String respuesta) {
        listView = (ListView) findViewById( R.id.list_view_cunsulta_m );
        models = listDatails.getList(respuesta);

        peticionAdapter = new PeticionAdapter( consulta_solicitud.this,models );
        listView.setAdapter( peticionAdapter );

    }

    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(consulta_solicitud.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(consulta_solicitud.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){
            Intent m = new Intent(consulta_solicitud.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(consulta_solicitud.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(consulta_solicitud.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/
}
