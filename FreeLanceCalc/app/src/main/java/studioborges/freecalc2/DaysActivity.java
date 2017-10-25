package studioborges.freecalc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import java.sql.Time;

public class DaysActivity extends AppCompatActivity {

    public int semanasvacaciones;
    public int diasvacaciones;
    public int finesdesemana;
    public int diaslibres;
    public int diasinactivox;
    public int diasemergencias;
    public int diaslaborables;
    public int tiempo;
    public static int horaslaborables;
    private EditText etext;
    private String stext;
    private boolean faltainfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        Intent intent = getIntent();

    }

    /** Called when the user clicks the Before button */
    public void Time(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Next button */
    public void Income(View view) {
        // Do something in response to button
        etext = (EditText) findViewById(R.id.edittext1);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            semanasvacaciones = 0;
        } else {
            semanasvacaciones = Integer.parseInt(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext2);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            diaslibres = 0;
        } else {
            diaslibres = Integer.parseInt(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext3);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            diasemergencias = 0;
        } else {
            diasemergencias = Integer.parseInt(etext.getText().toString());
        }
        if (faltainfo){
            Toast.makeText(this, "Faltó información", Toast.LENGTH_SHORT).show();
        }
        finesdesemana  = (52 - semanasvacaciones) * 2;
        diasvacaciones = semanasvacaciones * 7;
        diaslaborables = TimeActivity.diastrabajo - diasvacaciones - finesdesemana - diasemergencias - diaslibres;
        horaslaborables = (TimeActivity.horastrabajo * diaslaborables) + TimeActivity.horasreunion;
        Intent intent = new Intent(this, IncomeActivity.class);
        startActivity(intent);

    }

}
