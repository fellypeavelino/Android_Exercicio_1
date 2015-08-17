package com.example.felipe.exercicio_1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int mResultado;
    TextView mTextViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResultado = (TextView)findViewById(R.id.resultado);
        if(savedInstanceState != null){
            mResultado = savedInstanceState.getInt("resultado");
            mTextViewResultado.setText(mResultado);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("resultado",mResultado);
    }

    public void consultar(View v){
        EditText mGasolina = (EditText)findViewById(R.id.editText_gasolina);
        EditText mAlcool = (EditText)findViewById(R.id.editText_alcool);

        Double gasolina = Double.parseDouble(mGasolina.getText().toString());
        Double Alcool = Double.parseDouble(mAlcool.getText().toString());

        if(gasolina * 0.7 >= Alcool){
            mResultado = R.string.resultado_alcool;
        }else{
            mResultado = R.string.resultado_gasolina;
        }

        mTextViewResultado.setText(mResultado);
    }
}
