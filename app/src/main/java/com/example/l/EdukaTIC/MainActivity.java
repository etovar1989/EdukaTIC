package com.example.l.EdukaTIC;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace( R.id.escenario,  new SesionFragment()).commit();


        img1 = (ImageView) findViewById( R.id.imgClose );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
    }






}
