package com.desafiolatam.prueba4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView name,code,date,value,uom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        code = findViewById(R.id.codeId);
        name = findViewById(R.id.nameId);
        uom = findViewById(R.id.unitOfMeasureId);
        value = findViewById(R.id.valueId);
        date = findViewById(R.id.dateId);


        Mindicador clientRest = new Interceptors().theMostBasicInterceptor();
        clientRest.getData().enqueue(new Callback<Wrapper>() {
            @Override
            public void onResponse(Call<Wrapper> call, Response<Wrapper> response) {

                switch (response.code()) {
                    case 200:
                        //Toast.makeText(MainActivity.this,String.valueOf(response.body().getUtm().getValor()), Toast.LENGTH_SHORT).show();
                        Log.d("P4", "onResponse: "+response.body().getUtm().getNombre());
                        Log.d("P4", "onResponse: "+response.body().getUtm().getFecha());
                        Log.d("P4", "onResponse: "+response.body().getUtm().getCodigo());
                        Log.d("P4", "onResponse: "+response.body().getUtm().getUnidad_medida());
                        Log.d("P4", "onResponse: "+response.body().getUtm().getValor());
                        code.setText(response.body().getUtm().getCodigo());
                        name.setText(response.body().getUtm().getNombre());
                        uom.setText(response.body().getUtm().getUnidad_medida());
                        value.setText(String.valueOf(response.body().getUtm().getValor()));
                        date.setText(response.body().getUtm().getFecha());

                        break;
                    case 401:
                        Toast.makeText(MainActivity.this,"No Autorizado", Toast.LENGTH_SHORT).show();
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onFailure(Call<Wrapper> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("P4", "onFailure: "+t.getMessage());
            }
        });


    }



}
