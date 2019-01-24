package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class d2Manana extends AppCompatActivity {

    ImageView img1,img2,img3,img4;
    String opc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d2_manana );

        img1 = (ImageView)findViewById( R.id.imgIn );
        img2 = (ImageView)findViewById( R.id.imgOut );

        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc = "1";
                Intent in = new Intent( d2Manana.this, d2MenuManana.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );

        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc = "2";
                Intent in = new Intent( d2Manana.this, d2MenuManana.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );




        img3 = (ImageView) findViewById( R.id.imgB8 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        img4 = (ImageView) findViewById( R.id.imgHome6 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d2Manana.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );


    }
}
