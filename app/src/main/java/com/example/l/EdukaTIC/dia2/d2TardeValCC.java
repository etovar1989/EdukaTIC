package com.example.l.EdukaTIC.dia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.consultar.validarUsuarios;

public class d2TardeValCC extends AppCompatActivity {

    EditText cajaCC;
    Button consultarCC;
    String taller, dato;
    ImageView img1,img4;
    TextView textoTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_tarde_val_cc );

        //busco caja de texto para obtener los datos de esta
        cajaCC = (EditText)findViewById( R.id.txtD2ValCC );
        //Recupero texto enviado
        taller = getIntent().getStringExtra( "taller" );
        dato = getIntent().getStringExtra( "nombre" );
        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.txtTipo4 );
        //Envio el texto recuperado del inten
        textoTipo.setText( dato );

        //Toast.makeText( this,"Opcion"+taller, Toast.LENGTH_SHORT).show();

        consultarCC = (Button) findViewById( R.id.btnD2TConsultarCC );
        consultarCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent in = new Intent( d2TardeValCC.this, d2TardeResultado.class );
                in.putExtra( "cc",cajaCC.getText().toString());
                in.putExtra( "taller",taller );
                in.putExtra( "nombre",dato );
                startActivity( in );
                cajaCC.setText( "" );

            }
        } );

        img1 = (ImageView) findViewById( R.id.imgB14 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );



        /*
        img4 = (ImageView) findViewById( R.id.imgHome12 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2TardeValCC.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );
        */


    }



    /* Barra de menu de la apk*/
    public boolean onCreateOptionsMenu (android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu, mimenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if(id==R.id.btnInicio){
            Intent m = new Intent(d2TardeValCC.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2TardeValCC.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2TardeValCC.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2TardeValCC.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2TardeValCC.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/






}
