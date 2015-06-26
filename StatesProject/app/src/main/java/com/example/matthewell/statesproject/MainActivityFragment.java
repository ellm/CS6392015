package com.example.matthewell.statesproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.net.Uri;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Create Array
        String[] states = {
                "Alabama",
                "Alaska",
                "Arizona",
                "Arkansas",
                "California",
                "Colorado",
                "Connecticut",
                "Delaware",
                "Florida",
                "Georgia",
                "Hawaii",
                "Idaho",
                "Illinois",
                "Indiana",
                "Iowa",
                "Kansas",
                "Kentucky",
                "Louisiana",
                "Maine",
                "Maryland",
                "Massachusetts",
                "Michigan",
                "Minnesota",
                "Mississippi",
                "Missouri",
                "Montana",
                "Nebraska",
                "Nevada",
                "New Hampshire",
                "New Jersey",
                "New Mexico",
                "New York",
                "North Carolina",
                "North Dakota",
                "Ohio",
                "Oklahoma",
                "Oregon",
                "Pennsylvania",
                "Rhode Island",
                "South Carolina",
                "South Dakota",
                "Tennessee",
                "Texas",
                "Utah",
                "Vermont",
                "Virginia",
                "Washington",
                "West Virginia",
                "Wisconsin",
                "Wyoming"
        };

        // Create new Array List using Array
        List<String> stateAL = new ArrayList<String>(Arrays.asList(states));

        // Create the adapter (hook up data source)
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                states);

        // Set the View
        ListView lv = (ListView) rootView.findViewById(R.id.stateList);

        // Set the adaptor
        lv.setAdapter(stateAdapter);

        // Listener using a anonymous class
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.v("hello", "hello");
//                String txt = Integer.toString(position);
//                Log.v("heelo", txt );

                // Index 8 is Florida
                if (position == 8) {
                    String geoUri = String.format("geo:30.4381458,-84.3191127?q=30.4381458,-84.3191127(Florida+State+Capitol)");
                    Uri geo = Uri.parse(geoUri);
                    Intent geoMap = new Intent (Intent.ACTION_VIEW, geo);
                    startActivity(geoMap);
                }
            }
        });

        return rootView;
    }
}
