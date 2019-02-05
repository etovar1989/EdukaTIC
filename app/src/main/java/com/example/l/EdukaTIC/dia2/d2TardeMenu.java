package com.example.l.EdukaTIC.dia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia3.dia3;
import com.example.l.EdukaTIC.consultar.validarUsuarios;

public class d2TardeMenu extends AppCompatActivity {
    private TextView tv1;
    String dato1,dato2;
    ImageView img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_tarde_menu );

        dato1 = getIntent().getStringExtra( "taller" );
        dato2 = getIntent().getStringExtra( "nombre" );
        tv1 = (TextView)findViewById( R.id.txtTaller2 );

        tv1.setText( dato2 );

        Toast.makeText( this,"Opcion "+dato2, Toast.LENGTH_SHORT).show();

        img1= (ImageView) findViewById( R.id.imgValCC3 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d2TardeMenu.this, d2TardeValCC.class );
                in.putExtra( "taller",dato1 );
                in.putExtra( "nombre",dato2 );
                startActivity( in );

            }
        } );

        img2= (ImageView) findViewById( R.id.imgValQRD2T );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d2TardeMenu.this, d2TardeValQR.class );
                in.putExtra( "taller",dato1 );
                in.putExtra( "nombre",dato2 );
                startActivity( in );

            }
        } );


        img3 = (ImageView) findViewById( R.id.imgB13 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        /*
        img4 = (ImageView) findViewById( R.id.imgHome11 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2TardeMenu.this, Menu.class);
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
            Intent m = new Intent(d2TardeMenu.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            Intent m = new Intent(d2TardeMenu.this, validarUsuarios.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia1){

            Intent m = new Intent(d2TardeMenu.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            Intent m = new Intent(d2TardeMenu.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            Intent m = new Intent(d2TardeMenu.this, dia3.class);
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
