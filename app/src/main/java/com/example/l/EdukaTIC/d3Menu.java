package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class d3Menu extends AppCompatActivity {
    private TextView tv1;
    String dato1,dato2,dato3;
    ImageView img1,img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d3_menu );

        dato1 = getIntent().getStringExtra( "taller" );
        dato2 = getIntent().getStringExtra( "opc" );
        dato3 = getIntent().getStringExtra( "nombre" );
        tv1 = (TextView)findViewById( R.id.txtTaller );

        tv1.setText( dato3 );

        Toast.makeText( this,"Opcion "+dato2, Toast.LENGTH_SHORT).show();

        img1= (ImageView) findViewById( R.id.imgValCC2 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d3Menu.this, d3ValCC.class );
                in.putExtra( "taller",dato1 );
                in.putExtra( "opc",dato2 );
                in.putExtra( "nombre",dato3 );
                startActivity( in );

            }
        } );

        img2= (ImageView) findViewById( R.id.imgValQR );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d3Menu.this, d3ValQR.class );
                in.putExtra( "taller",dato1 );
                in.putExtra( "opc",dato2 );
                in.putExtra( "nombre",dato3 );
                startActivity( in );

            }
        } );

        img3 = (ImageView) findViewById( R.id.imgB6 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


        img4 = (ImageView) findViewById( R.id.imgHome15 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(d3Menu.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                startActivity(intent);
                finish();

            }
        } );

    }
}
