package com.example.satishkumar.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageDownloader imageDownloader = new ImageDownloader();
                imageDownloader.execute("https://raw.githubusercontent.com/dsathkumar/CS6392015/master/GatewayofIndia.png");            }
        });
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

    public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected void onPreExecute(){
            //Setup is done here
        }
        @Override protected Bitmap doInBackground(String... params) {
            try{
                URL url = new URL(params[0]);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                if(httpCon.getResponseCode() != 200) throw new Exception("Failed to connect");
                InputStream is = httpCon.getInputStream();
                return BitmapFactory.decodeStream(is);
            }
            catch(Exception e){
                Log.e("Image", "Failed to load image", e);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... params){
            //Update a progress bar here, or ignore it, it's up to you
        }

        @Override protected void onPostExecute(Bitmap img){

            ImageView iv = (ImageView) findViewById(R.id.imageView);

            if(iv!=null && img!=null){
                iv.setImageBitmap(img);
            }
        }



        @Override
        protected void onCancelled(){
            // Handle what you want to do if you cancel this task
        }
    }

}
