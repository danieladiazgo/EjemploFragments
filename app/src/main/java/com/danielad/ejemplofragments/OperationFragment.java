package com.danielad.ejemplofragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationFragment extends Fragment implements View.OnClickListener {

    Opinterface opinterface;
    Button bCalcular;
    private String info ="Hola datos";

    public OperationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_operation, container, false);

        bCalcular = (Button) view.findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(this);
        return view;
    }

    /*public void calcular (View view){

        opinterface.openDataFragment();

    }*/

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
        opinterface.openDataFragment(info);
    }
}
