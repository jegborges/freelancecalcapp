package studioborges.freecalc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class OutcomeActivity extends AppCompatActivity {


    public float alquiler;
    public float internet;
    public float servicios;
    public float gasolina;
    public float honorarios;
    public static float gastos;
    private EditText etext;
    private String stext;
    private boolean faltainfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome);
        Intent intent = getIntent();

    }

    /** Called when the user clicks the Anterior button */
    public void Income(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, IncomeActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Siguiente button */
    public void Result(View view) {
        // Do something in response to button
        etext = (EditText) findViewById(R.id.edittext1);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            alquiler = 0;
        } else {
            alquiler = Float.parseFloat(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext2);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            internet = 0;
        } else {
            internet = Float.parseFloat(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext3);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            servicios = 0;
        } else {
            servicios = Float.parseFloat(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext4);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            honorarios = 0;
        } else {
            honorarios = Float.parseFloat(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext5);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            gasolina = 0;
        } else {
            gasolina = Float.parseFloat(etext.getText().toString());
        }
        if (faltainfo){
            Toast.makeText(this, "Faltó información", Toast.LENGTH_SHORT).show();
        }
        gastos = alquiler + internet + servicios + honorarios + gasolina + IncomeActivity.emergencias;
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

}
