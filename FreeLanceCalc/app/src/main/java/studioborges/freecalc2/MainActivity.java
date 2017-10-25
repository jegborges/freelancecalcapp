package studioborges.freecalc2;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView link;
    private String sitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView link = (TextView) findViewById(R.id.textview7);
        sitio = "http://studioborges.com";
        link.setText(Html.fromHtml(sitio));

    }

    /** Called when the user clicks the Siguiente button */
    public void Time(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

}
