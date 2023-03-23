package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoGasolina,precoAlcool;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public  void calcularPreco(View view){

        String priceAlcool = precoAlcool.getText().toString();
        String priceGasolina = precoGasolina.getText().toString();
        boolean camposValidados = validarCampos(priceAlcool,priceGasolina);
        if(camposValidados){

            double valorAlcool = Double.parseDouble(priceAlcool);
            double valorGasolina = Double.parseDouble(priceGasolina);
            double resultado = valorAlcool/valorGasolina;
            if ( resultado >= 0.7){
                textResultado.setText("Melhor ultilizar Gasolina!");

            }else {
                textResultado.setText("Melhor ultilizar Alcool!");
            }

        }else
            textResultado.setText("Preencha todos os campos primeiro!");
    }

    public boolean validarCampos(String pAlcool, String pGasolina){

        boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){

            camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }



        return  camposValidados;



    }
}
