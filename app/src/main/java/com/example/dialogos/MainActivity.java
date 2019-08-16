package com.example.dialogos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, DialogoFragment.OnInicioSessionListener {

    Button alerta1, alerta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alerta1 = (Button) findViewById(R.id.btn_1);
        alerta2 = (Button) findViewById(R.id.btn_2);

        alerta1.setOnClickListener(this);
        alerta2.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_1:
                //Dialogo.alerta(this, v).show();
                //Dialogo.lista(this, v).show();
                //Dialogo.listaCheck(this, v).show();
                DialogoFragment dialogo = new DialogoFragment();
                dialogo.show(getSupportFragmentManager(), "DIALOGO");
                break;

            case R.id.btn_2:
                //Dialogo.confirmacion(this,v).show();
                Dialogo.listaRadio(this, v).show();
                break;
        }

    }

    @Override
    public void onIniciarListener() {
        Toast.makeText(this, "Bienvenido",Toast.LENGTH_SHORT).show();
    }
}
