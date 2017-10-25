package studioborges.freecalc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.round;

public class ResultActivity extends AppCompatActivity {

    public int horastotales;
    private float impuestos;
    private float seguros;
    private float ingresos;
    private float egresos;
    private float cobroporhora;
    private String mensaje;
    private ViewGroup elayout;
    private EditText etext;
    private String stext;
    private EditText rtext;
    private boolean faltainfo;
    private TextView link;
    private String sitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        elayout = (ViewGroup) findViewById(R.id.layoutresult);
        TextView link = (TextView) findViewById(R.id.textview7);
        sitio = "http://studioborges.com";
        link.setText(Html.fromHtml(sitio));
    }

    /** Called when the user clicks the Calcular button */
    public void Calculate(View View) {
        // Do something in response to button
        etext = (EditText) findViewById(R.id.edittext1);
        stext = etext.getText().toString();
        if (stext.matches("")){
            impuestos = 0;
        } else {
            impuestos = Float.parseFloat(etext.getText().toString());
        }

        etext = (EditText) findViewById(R.id.edittext4);
        stext = etext.getText().toString();
        if (stext.matches("")){
            seguros = 0;
        } else {
            seguros = Float.parseFloat(etext.getText().toString());
        }

        ingresos = IncomeActivity.sueldo;
        egresos = OutcomeActivity.gastos + impuestos + seguros;
        cobroporhora = round((egresos * 12) / DaysActivity.horaslaborables);
        if (ingresos <= egresos)
            Toast.makeText(this, "Mas egresos que el sueldo estimado", Toast.LENGTH_SHORT).show();
        mensaje = String.valueOf(cobroporhora);
        rtext = (EditText) findViewById(R.id.edittext2);
        rtext.setText(mensaje);


    }

    /** Called when the user clicks the Anterior button */
    public void Outcome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, OutcomeActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Inicio button */
    public void Main(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
