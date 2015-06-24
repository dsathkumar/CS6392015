package com.example.satishkumar.dollarconv;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void dollarConv(View view) {

 //       Double value1 = Double.parseDouble(R.id.editTextDollar.getText().toString());

        EditText edit_text = (EditText) findViewById(R.id.editTextDollar);
        double edittextValue = Double.parseDouble(edit_text.getText().toString());

        double convValue;
        convValue = edittextValue * 586.84;

        Context context = getApplicationContext();
        CharSequence text = "Result - " + convValue;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        TextView textView = (TextView) findViewById(R.id.textViewResult);
        textView.setText("CFA "+String.format("%.2f", convValue));

    }
}
