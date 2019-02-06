package com.example.l.EdukaTIC.solicitud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.l.EdukaTIC.R;
import com.example.l.EdukaTIC.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class solicitud_resultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{


    String idMonitor;
    String para;
    String ubicacion;
    String sol;
    String respuesta;
    TextView r;

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1;

    User usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_solicitud_resultado );

        rq = Volley.newRequestQueue(this);
        enviarSolicitud();

        img1 = (ImageView) findViewById( R.id.imgSolResBK );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


    }

    private void enviarSolicitud() {

        usuario = new User();
        idMonitor = usuario.getIdU();
        para = getIntent().getStringExtra( "para" );
        ubicacion = getIntent().getStringExtra( "ubicacion" );
        sol = getIntent().getStringExtra( "solicitud" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/solicitud.php?idU="+idMonitor+
                "&para="+para+"&ubicacion="+ubicacion+"&solicitud="+sol;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( this,"Fallo", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText( this,"Listo papa", Toast.LENGTH_LONG).show();
        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        r = (TextView)findViewById( R.id.txtSolRes );
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            respuesta =  jsonObject.optString( "validador" );

            if(respuesta.equals( "1" )){
                r.setText( "Se creò la solicitud" );
            }if(respuesta.equals( "21" )){
                r.setText( "Upss, no Se creò la solicitud" );
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
