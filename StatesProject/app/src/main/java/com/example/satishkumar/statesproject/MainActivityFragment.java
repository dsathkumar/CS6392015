package com.example.satishkumar.statesproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Populating listview with state names

        String[] stateNames = {
                "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming",
        };

        List<String> stateNamesList = new ArrayList<>(Arrays.asList(stateNames));

        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, stateNames);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        listView.setAdapter(listadapter);
        listView.setOnItemClickListener(onItemClickListener);
        return rootView;
    }


    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            // TODO Auto-generated method stub
            //do your job here, position is the item position in ListView
            GoogleMap map;
            String s = arg0.getItemAtPosition(position).toString();

            Context context = getActivity().getApplicationContext();
            int duration = Toast.LENGTH_SHORT;


            if (s == "Delaware") {
//                String geoUri = String.format("geo:39.1619,-75.5267");
//                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:39.1619,-75.5267?q=39.1619,-75.5267(DOVER)"));
                startActivity(geoMap);
            //    map.addMarker();
            } else {
                CharSequence text = "Please Click Delaware";
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            };

//            Intent intent = new Intent(getActivity(),JavaCupActivity.class);
//            startActivity(intent);


        }
    };

}
