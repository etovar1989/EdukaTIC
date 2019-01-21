package com.example.l.EdukaTIC;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class d2MenuManana extends AppCompatActivity {
    ImageView img1,img2,img3;
    String opc,titulo;
    TextView txtDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_menu_manana );

        opc = getIntent().getStringExtra( "opc" );
        txtDato = (TextView) findViewById( R.id.txtD2txto );

        if(opc.equals( "1" )){
            titulo= "Ingreso";
            txtDato.setTextColor( Color.rgb( 83,67,63 ) );
        }if(opc.equals( "2" )){
            titulo= "Reingreso";
            txtDato.setTextColor( Color.rgb( 237,156,23 ) );
        }



        txtDato.setText( titulo );

        img1= (ImageView) findViewById( R.id.imgD2MCC );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d2MenuManana.this, d2MananaValCC.class );
                in.putExtra( "opc",opc );
                startActivity( in );

            }
        } );

        img2= (ImageView) findViewById( R.id.imgD2MQR );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d2MenuManana.this, d2MananaValQR.class );
                in.putExtra( "opc",opc );
                startActivity( in );

            }
        } );


        img3 = (ImageView) findViewById( R.id.imgB9 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
    }
}
