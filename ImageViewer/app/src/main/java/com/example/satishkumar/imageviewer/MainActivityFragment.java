package com.example.satishkumar.imageviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final int[] image_index = {0};
        final int MAX_IMAGE_COUNT = 5;

        final Integer[] mImageIds = new Integer[]{
                R.drawable.audi_xxxhdpi,
                R.drawable.bentley_xxhdpi,
                R.drawable.bmw_xhdpi,
                R.drawable.camero_hdpi,
                R.drawable.charger_mdpi,
        };

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button a = (Button)rootView.findViewById(R.id.previous_btn);

        if (a == null){
            Log.i("MainActivityFragment", "The button is null");
        } else{
            Log.i("MainActivityFragment", "The button is not null");
        }

        image_index[0] = -1;

        a.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     Log.i("MainActivityFragment", "The prev button is clicked!");

                                     if (image_index[0] == 0){}
                                     else if (image_index[0] != -1) {
                                          image_index[0]--;
                                     }
                                     else
                                         image_index[0] = MAX_IMAGE_COUNT - 1;

                                     ImageView imgView = (ImageView)rootView.findViewById(R.id.myimage);
                                     imgView.setImageResource(mImageIds[image_index[0]]);
                                 }
                             }
        );
/*      Next button */
        Button b = (Button)rootView.findViewById(R.id.next_btn);
        if (b == null){
            Log.i("MainActivityFragment", "The button is null");
        } else{
            Log.i("MainActivityFragment", "The button is not null");
        }
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     Log.i("MainActivityFragment", "The button is clicked!");
                                     image_index[0]++;

                                     if (image_index[0] == MAX_IMAGE_COUNT) {
                                         image_index[0] = 0;
                                     }
                                     ImageView imgView = (ImageView)rootView.findViewById(R.id.myimage);
                                     imgView.setImageResource(mImageIds[image_index[0]]);
                                 }
                              }
        );

        return rootView;


    }
}