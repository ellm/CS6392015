package com.example.matthewell.matthewellmidterm;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Button submitButton;
    EditText inputData;
    TextView txtVal;
    int kiloResultInt;
    double kiloResultdbl;
    String kiloResultStr;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        submitButton = (Button) rootView.findViewById(R.id.button);
        inputData = (EditText) rootView.findViewById(R.id.editText);
        txtVal = (TextView) rootView.findViewById(R.id.textView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc();
                txtVal.setText(kiloResultStr);
            }
        });


        return rootView;
    }

    public void calc() {
        kiloResultInt = Integer.parseInt(inputData.getText().toString());
        kiloResultdbl = kiloResultInt * 1.609;
        kiloResultStr = Double.toString(kiloResultdbl);
    }

}