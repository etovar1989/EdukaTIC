package com.example.l.EdukaTIC.consultar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.EdukaTIC.Menu;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.dia1.dia1;
import com.example.l.EdukaTIC.dia2.dia2;
import com.example.l.EdukaTIC.dia3.dia3;

public class ResutadoConsultaCC extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_resutado_consulta_cc );

        tv1 = (TextView)findViewById( R.id.txtConCCN  );
        tv2 = (TextView)findViewById( R.id.txtConCCT );
        tv3 = (TextView)findViewById( R.id.txtConCCU );
        tv4 = (TextView)findViewById( R.id.txtConCCR );
        tv5 = (TextView)findViewById( R.id.txtConCCP1 );
        tv6 = (TextView)findViewById( R.id.txtConCCL1 );
        tv7 = (TextView)findViewById( R.id.txtConCCP2 );
        tv8 = (TextView)findViewById( R.id.txtConCCL2 );
        tv9 = (TextView)findViewById( R.id.txtConCCP3 );
        tv10 = (TextView)findViewById( R.id.txtConCCL3 );


        String dato1 = getIntent().getStringExtra( "nombreU" );
        String dato2 = getIntent().getStringExtra( "taller" );
        String dato3 = getIntent().getStringExtra( "salon" );
        String dato4 = getIntent().getStringExtra( "requisitos" );
        String dato5 = getIntent().getStringExtra( "paralela1" );
        String dato6 = getIntent().getStringExtra( "lugar1" );
        String dato7 = getIntent().getStringExtra( "paralela2" );
        String dato8 = getIntent().getStringExtra( "lugar2" );
        String dato9 = getIntent().getStringExtra( "paralela3" );
        String dato10 = getIntent().getStringExtra( "lugar3" );


        tv1.setText(dato1);
        tv2.setText(dato2);
        tv3.setText(dato3);
        tv4.setText(dato4);
        tv5.setText(dato5);
        tv6.setText(dato6);
        tv7.setText(dato7);
        tv8.setText(dato8);
        tv9.setText(dato9);
        tv10.setText(dato10);




        img1 = (ImageView) findViewById( R.id.imgBk );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            final Intent m = new Intent(ResutadoConsultaCC.this, Menu.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnConsultar){
            return true;
        }
        if(id==R.id.btnDia1){
            final Intent m = new Intent(ResutadoConsultaCC.this, dia1.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia2){
            final Intent m = new Intent(ResutadoConsultaCC.this, dia2.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }
        if(id==R.id.btnDia3){
            final Intent m = new Intent(ResutadoConsultaCC.this, dia3.class);
            m.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
            startActivity(m);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }


    /*Fin  Barra de menu de la apk*/



}
