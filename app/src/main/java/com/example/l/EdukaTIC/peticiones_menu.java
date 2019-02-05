package com.example.l.EdukaTIC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class peticiones_menu extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Model> models;
    private PeticionAdapter peticionAdapter;
    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_peticiones_menu );

        cliente = new AsyncHttpClient();

        llenarLista();
    }


    private void llenarLista() {
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_solicitud.php";
        cliente.post( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    cargarPeticiones(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText( peticiones_menu.this,"Fallo",Toast.LENGTH_SHORT ).show();

            }
        } );
    }

    private void cargarPeticiones(String respuesta) {
        listView = (ListView) findViewById( R.id.list_view );
        models = listDatails.getList(respuesta);

        peticionAdapter = new PeticionAdapter( peticiones_menu.this,models );
        listView.setAdapter( peticionAdapter );


        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Model model = models.get( i );
                Toast.makeText( peticiones_menu.this,"Clic en el item numero: "+model.getIdP(),Toast.LENGTH_SHORT ).show();


            }
        } );
    }



}
