package com.example.l.EdukaTIC.peticiones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.consultar.validarUsuarios;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;
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
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_solicitud.php?estado=0";
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
                //Toast.makeText( peticiones_menu.this,"Clic en el item numero: "+model.getIdP(),Toast.LENGTH_SHORT ).show();
                Intent in = new Intent( peticiones_menu.this, peticiones_datalle.class );
                in.putExtra( "idP",model.getIdP());
                startActivity( in );
                finish();


            }
        } );
    }



    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(peticiones_menu.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(peticiones_menu.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(peticiones_menu.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(peticiones_menu.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/



}
