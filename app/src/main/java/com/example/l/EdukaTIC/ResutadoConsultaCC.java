package com.example.l.EdukaTIC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResutadoConsultaCC extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
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


        String dato1 = getIntent().getStringExtra( "nombre" );
        String dato2 = getIntent().getStringExtra( "taller" );
        String dato3 = getIntent().getStringExtra( "ubicacion" );
        String dato4 = getIntent().getStringExtra( "requisitos" );
        String dato6 = getIntent().getStringExtra( "idTaller" );
        String dato7 = getIntent().getStringExtra( "tallerM1" );
        String dato8 = getIntent().getStringExtra( "tallerM2" );
        String dato9 = getIntent().getStringExtra( "GeneralM1" );
        String dato10 = getIntent().getStringExtra( "GeneralM2" );

        tv1.setText(dato1);
        tv2.setText(dato6+" - "+dato2);
        tv3.setText(dato3);
        tv4.setText(dato4);
        tv5.setText(dato7);
        tv6.setText(dato8);
        tv7.setText(dato9);
        tv8.setText(dato10);


        img1 = (ImageView) findViewById( R.id.imgBk );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );



    }
}
