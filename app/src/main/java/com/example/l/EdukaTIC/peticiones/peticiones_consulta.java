package com.example.l.EdukaTIC.peticiones;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
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

public class peticiones_consulta extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Model> models;
    private PeticionAdapter peticionAdapter;
    private AsyncHttpClient cliente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_peticiones_consulta );

        cliente = new AsyncHttpClient();

        llenarLista();

    }


    private void llenarLista() {

        final String dato = getIntent().getStringExtra( "estado" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_solicitud.php?estado="+ dato;
        cliente.post( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    cargarPeticiones(new String(responseBody));
                    //alertDialogoBasico(dato);
                    //Toast.makeText( peticiones_consulta.this,"ok",Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText( peticiones_consulta.this,"Fallo",Toast.LENGTH_SHORT ).show();
                finish();

            }
        } );
    }


    private void cargarPeticiones(String respuesta) {
        listView = (ListView) findViewById( R.id.list_view_query );
        models = listDatails.getList(respuesta);

        peticionAdapter = new PeticionAdapter( peticiones_consulta.this,models );
        listView.setAdapter( peticionAdapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Model model = models.get( i );
                //Toast.makeText( peticiones_consulta.this,"Clic en el item numero: "+model.getSolicitudMonitor(),Toast.LENGTH_SHORT ).show();

            }
        } );

    }



    private void alertDialogoBasico(String estado) {
        String calamarino = "";
        if(estado.equals( "1" )){
            calamarino = "APROBADAS";
        }if(estado.equals( "2" )){
            calamarino = "CANCELADAS";
        }

        //1. Instanciar el AlertDialog.Builder con este constructor
        AlertDialog.Builder builder = new AlertDialog.Builder( this );

        //2. Encadenar varios metodos setter para ajustar las caracteristicas del dialogo
        builder.setMessage( "A continuacion se veran las solicitudes " + calamarino + ", preciones 'OK' para continuar" );

        builder.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        } );
        builder.show();
    }





    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(peticiones_consulta.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(peticiones_consulta.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(peticiones_consulta.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(peticiones_consulta.this, dia3.class);
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
