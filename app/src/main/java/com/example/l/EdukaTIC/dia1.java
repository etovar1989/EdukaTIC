package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class dia1 extends AppCompatActivity {

    ImageView img1,img2,img3,img4;
    String opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia1 );




        img1 = (ImageView) findViewById( R.id.imgD1m1 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                opc = "1";
                com.example.l.EdukaTIC.User usuario = new com.example.l.EdukaTIC.User();
                usuario.setD1m( opc );

                Intent in = new Intent( dia1.this, d1Menu.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgD1m2 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                opc = "2";
                com.example.l.EdukaTIC.User usuario = new com.example.l.EdukaTIC.User();
                usuario.setD1m( opc );

                Intent in = new Intent( dia1.this, d1Menu.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );

        img3 = (ImageView) findViewById( R.id.imgB1 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        img4 = (ImageView) findViewById( R.id.imgHome );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( dia1.this, Menu.class );
                startActivity( in );
                finish();
            }
        } );



    }
}
