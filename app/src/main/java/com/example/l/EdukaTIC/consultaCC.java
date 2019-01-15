package com.example.l.EdukaTIC;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class consultaCC extends AppCompatActivity {

    ImageView img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulta_cc );

        FragmentManager f = getSupportFragmentManager();
        f.beginTransaction().replace( R.id.contenido,  new ConsultaCCFragment()).commit();


        img4 = (ImageView) findViewById( R.id.imgBk );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }

}
