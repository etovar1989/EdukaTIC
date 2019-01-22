package com.example.l.EdukaTIC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class dia2 extends AppCompatActivity {

    ImageView img1,img2,img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia2 );

        img1 = (ImageView)findViewById( R.id.imgD2M );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( dia2.this, d2Manana.class );
                startActivity( in );
            }
        } );



        img2 = (ImageView)findViewById( R.id.imgD2T );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( dia2.this, d2Tarde.class );
                startActivity( in );

            }
        } );

        img3 = (ImageView) findViewById( R.id.imgB4 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }
}
