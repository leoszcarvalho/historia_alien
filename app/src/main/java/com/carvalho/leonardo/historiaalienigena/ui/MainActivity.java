package com.carvalho.leonardo.historiaalienigena.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.carvalho.leonardo.historiaalienigena.R;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        campoNome = (EditText) findViewById(R.id.namEditText);


        /*

        CÓDIGO CASO SEJA NECESSÁRIA A DETECÇÃO DE EVENTOS DO TECLADO E TAMBÉM COMANDO COM MÉTODO hideKeyboard PARA
         ESCONDER O MESMO CASO SEJA NECESSÁRIO, OBS: MÉTODO hideKeyboard ESTÁ COMENTADO NO FINAL DESTE CÓDIGO
         NECESSÁRIO DESCOMENTAR O MESMO PARA FUNCIONAMENTO

        campoNome.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Log.d("evento", String.valueOf(event.getAction()));
                Log.d("chave", String.valueOf(KeyEvent.KEYCODE_ENTER));

                if(keyCode == 66) {


                    hideKeyboard(MainActivity.this);

                }

                return false;
            }
        });
        */



        start.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("nome", String.valueOf(campoNome.getText()));

                Log.d("name", String.valueOf(campoNome.getText()));

                startActivity(intent);
            }

        });

    }


    @Override
    protected void onResume() {

        super.onResume();

        campoNome.setText("");

    }


    /*
    public static void hideKeyboard(MainActivity activity)
    {
        try
        {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        catch (Exception e)
        {
            // Ignore exceptions if any
            Log.e("KeyBoardUtil", e.toString(), e);
        }
    }
    */

    //Teste para retornar
}
