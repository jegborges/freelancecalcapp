package studioborges.freecalc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class TimeActivity extends AppCompatActivity {

    public static int diastrabajo;
    public static int horastrabajo;
    public static int horasreunion;
    private EditText etext;
    private String stext;
    private boolean faltainfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Intent intent = getIntent();
        horastrabajo = 0;
        diastrabajo = 0;

    }

    /** Called when the user clicks the Before button */
    public void Main(View view) {
        // Do something in response to button


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Next button */
    public void Days(View view) {
        // Do something in response to button
        faltainfo = false;
        etext = (EditText) findViewById(R.id.edittext1);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            horastrabajo = 0;
        } else {
            horastrabajo = Integer.parseInt(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext2);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            diastrabajo = 0;
        } else {
            diastrabajo = 52 * (Integer.parseInt(etext.getText().toString()));
        }
        etext = (EditText) findViewById(R.id.edittext3);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            horasreunion = 0;
        } else {
            horasreunion = 52 * (Integer.parseInt(etext.getText().toString()));
        }
        if (faltainfo){
            Toast.makeText(this, "Faltó información", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(this, DaysActivity.class);
        startActivity(intent);
    }

}
