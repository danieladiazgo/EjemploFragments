package com.danielad.ejemplofragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment implements View.OnClickListener {

    Opinterface opinterface;
    Button bVolver;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        Bundle bundle =getArguments();
        String dato = bundle.getString("data");

        Toast.makeText(getActivity(), dato, Toast.LENGTH_LONG).show();

        bVolver = (Button) view.findViewById(R.id.bVolver);
        bVolver.setOnClickListener(this);
        return view;

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            opinterface = (Opinterface) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+"must implemented communicator");
        }
    }

    @Override
    public void onClick(View view) {
        opinterface.openOperationFragment();
    }
}
