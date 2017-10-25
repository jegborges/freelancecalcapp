package studioborges.freecalc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class IncomeActivity extends AppCompatActivity {

    public static float sueldo;
    public static float emergencias;
    private EditText etext;
    private String stext;
    private boolean faltainfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        Intent intent = getIntent();

    }

    /** Called when the user clicks the Before button */
    public void Days(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DaysActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Next button */
    public void Outcome(View view) {
        // Do something in response to button
        etext = (EditText) findViewById(R.id.edittext1);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            sueldo = 0;
        } else {
            sueldo = Float.parseFloat(etext.getText().toString());
        }
        etext = (EditText) findViewById(R.id.edittext2);
        stext = etext.getText().toString();
        if (stext.matches("")){
            faltainfo = true;
            emergencias = 0;
        } else {
            emergencias = Float.parseFloat(etext.getText().toString());
        }
        if (faltainfo){
            Toast.makeText(this, "Faltó información", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(this, OutcomeActivity.class);
        startActivity(intent);
    }

}