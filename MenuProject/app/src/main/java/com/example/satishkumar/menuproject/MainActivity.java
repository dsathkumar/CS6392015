package com.example.satishkumar.menuproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.ACTION_VIEW;


public class MainActivity extends Activity {
//    Button sendSms,callPhone;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        sendSms = (Button) findViewById(R.id.sms);
//        callPhone = (Button) findViewById(R.id.phone);
    }

    public void sendSms(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("address", new String("01234"));
        intent.putExtra("sms_body", "Test ");
        startActivity(intent);
    }

    public void PhoneCall(View v) {
        Intent intent = new Intent(ACTION_DIAL);
        intent.setData(Uri.parse("tel:9179249569"));
        startActivity(intent);
    }

    public void webPage(View v){
        Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(intent);
    }

    public void mapLaunch(View v){
        String geoUri = String.format("geo:13.0539,80.2641");
        Uri geo = Uri.parse(geoUri);
        Intent geoMap = new Intent(ACTION_VIEW,geo);
        startActivity(geoMap);
    }

    public void shareScreen(View v){
        Intent intent = new Intent(ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "CS639");
        intent.putExtra(Intent.EXTRA_TEXT,"Join CS639");
        startActivity(Intent.createChooser(intent,"Share the love"));
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newActivity(View view) {
        Intent intent = new Intent(getBaseContext(),NewActivity.class);
        startActivity(intent);
    }

    public void helpActivity(View view) {
        Intent intent = new Intent(getBaseContext(),HelpActivity.class);
        startActivity(intent);
    }

}