package com.stivenduque.myrecyclerview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CirculoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CirculoFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    Button btnSend;
    ImageView imageCirlce;
    EditText etRadio;
    TextView tvResult;
    RadioGroup radioGroup;
    RadioButton radioButton;
    private String radio;
    private float resultado;
    public CirculoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);
        btnSend = view.findViewById(R.id.btn_send_cicle);
        imageCirlce = view.findViewById(R.id.fragment_image_circle);
        etRadio = view.findViewById(R.id.et_radio_circle);
        tvResult = view.findViewById(R.id.tv_radio_circle);
        radioGroup = view.findViewById(R.id.rgrup_circle);
        radioButton = view.findViewById(R.id.radio_area_circle);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_area_circle:

                        btnSend.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setRadio(etRadio.getText().toString());
                                if (getRadio().equals("")){etRadio.setError("Ingrese el radio");}
                                else {
                                    resultado = (float) (Math.pow(Float.valueOf(getRadio()),2) * Math.PI);
                                    tvResult.setText("El área es: " + String.valueOf(resultado));
                                    tvResult.setTextSize(20);
                                    tvResult.setFocusable(true);
                                }
                            }
                        });

                        break;
                    case R.id.radio_perimetro_circle:

                        btnSend.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setRadio(etRadio.getText().toString());
                                if (getRadio().equals("")){etRadio.setError("Ingrese el radio");}
                                else {
                                    resultado = (float) (2*Math.PI*Float.valueOf(getRadio()));
                                    tvResult.setText("El perimetro es: " + String.valueOf(resultado));
                                    tvResult.setTextSize(20);
                                    tvResult.setFocusable(true);
                                }
                            }
                        });
                        break;
                }
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
