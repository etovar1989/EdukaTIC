package com.example.l.EdukaTIC.solicitud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.User;
import com.example.l.EdukaTIC.peticiones.Model;
import com.example.l.EdukaTIC.peticiones.PeticionAdapter;
import com.example.l.EdukaTIC.peticiones.listDatails;
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
}
