package com.example.l.EdukaTIC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResutadoConsultaCC extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16;;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_resutado_consulta_cc );

        tv1 = (TextView)findViewById( R.id.txtConCCN  );
        tv2 = (TextView)findViewById( R.id.txtConCCT );
        tv3 = (TextView)findViewById( R.id.txtConCCU );
        tv4 = (TextView)findViewById( R.id.txtConCCR );
        tv5 = (TextView)findViewById( R.id.txtMV );
        tv6 = (TextView)findViewById( R.id.txtTV );
        tv7 = (TextView)findViewById( R.id.txtMM );
        tv8 = (TextView)findViewById( R.id.txtTM );
        tv9 = (TextView)findViewById( R.id.txtMJ1 );
        tv10 = (TextView)findViewById( R.id.txtMJ2 );
        tv11 = (TextView)findViewById( R.id.txtTJ1 );
        tv12 = (TextView)findViewById( R.id.txtTJ2 );
        tv13 = (TextView)findViewById( R.id.txtTJ3 );
        tv14 = (TextView)findViewById( R.id.txtCP1 );
        tv15 = (TextView)findViewById( R.id.txtCP2 );
        tv16 = (TextView)findViewById( R.id.txtCP3 );


        String dato1 = getIntent().getStringExtra( "nombre" );
        String dato2 = getIntent().getStringExtra( "taller" );
        String dato3 = getIntent().getStringExtra( "ubicacion" );
        String dato4 = getIntent().getStringExtra( "requisitos" );
        String dato6 = getIntent().getStringExtra( "idTaller" );
        String dato7 = getIntent().getStringExtra( "tallerM1" );
        String dato8 = getIntent().getStringExtra( "tallerM2" );
        String dato9 = getIntent().getStringExtra( "GeneralM1" );
        String dato10 = getIntent().getStringExtra( "GeneralM2" );
        String dato11 = getIntent().getStringExtra( "GM1" );
        String dato12 = getIntent().getStringExtra( "GM2" );
        String dato13 = getIntent().getStringExtra( "GT1" );
        String dato14 = getIntent().getStringExtra( "GT2" );
        String dato15 = getIntent().getStringExtra( "GT3" );
        String dato16 = getIntent().getStringExtra( "D2CP1" );
        String dato17 = getIntent().getStringExtra( "D2CP2" );
        String dato18 = getIntent().getStringExtra( "D2CP3" );

        tv1.setText(dato1);
        tv2.setText(dato6+" - "+dato2);
        tv3.setText(dato3);
        tv4.setText(dato4);
        tv5.setText(dato7);
        tv6.setText(dato8);
        tv7.setText(dato9);
        tv8.setText(dato10);
        tv9.setText(dato11);
        tv10.setText(dato12);
        tv11.setText(dato13);
        tv12.setText(dato14);
        tv13.setText(dato15);
        tv14.setText(dato16);
        tv15.setText(dato17);
        tv16.setText(dato18);


        img1 = (ImageView) findViewById( R.id.imgBk );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );



    }
}
