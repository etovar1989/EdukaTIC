package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class d2TardeMenu extends AppCompatActivity {
    private TextView tv1;
    String dato1,dato2;
    ImageView img1,img2,img3;
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


    }
}
