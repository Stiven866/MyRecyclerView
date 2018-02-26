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
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CuadradoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CuadradoFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    ImageView imageCuadrado;
    Button btnSend;
    EditText etSideA, etSideB;
    TextView tvResult;
    RadioGroup radioGroup;
    private String sideA, sideB;
    private float result;
    public CuadradoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuadrado, container, false);
        imageCuadrado = view.findViewById(R.id.fragment_image_cuadrado);
        btnSend = view.findViewById(R.id.btn_send_cuadrado);
        etSideA = view.findViewById(R.id.et_cuadrado_ladoA);
        etSideB = view.findViewById(R.id.et_cuadrado_ladoB);
        tvResult = view.findViewById(R.id.tv_radio_cuadrado);
        radioGroup = view.findViewById(R.id.rgrup_cuadrado);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_area_cuadrad:
                        btnSend.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setSideA(etSideA.getText().toString());
                                if (getSideA().equals("")){etSideA.setError("Ingrese el lado A");}
                                else {
                                    setSideB(etSideB.getText().toString());
                                    if (getSideB().equals("")){etSideB.setError("Ingrese el lado B");}
                                    else {
                                        result = Float.valueOf(getSideA()) * Float.valueOf(getSideB());
                                        tvResult.setText("El área es: "+String.valueOf(result));
                                        tvResult.setTextSize(20);
                                        tvResult.setFocusable(true);
                                    }
                                }
                            }
                        });
                        break;
                    case R.id.radio_perimetro_cuadrado:

                        btnSend.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setSideA(etSideA.getText().toString());
                                if (getSideA().equals("")){etSideA.setError("Ingrese el lado A");}
                                else {
                                    setSideB(etSideB.getText().toString());
                                    if (getSideB().equals("")){etSideB.setError("Ingrese el lado B");}
                                    else {
                                        result = 2 * (Float.valueOf(getSideA()) + Float.valueOf(getSideB()));
                                        tvResult.setText("El perimetro es: "+String.valueOf(result));
                                        tvResult.setTextSize(20);
                                        tvResult.setFocusable(true);
                                    }
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

    public String getSideA() {
        return sideA;
    }

    public void setSideA(String sideA) {
        this.sideA = sideA;
    }

    public String getSideB() {
        return sideB;
    }

    public void setSideB(String sideB) {
        this.sideB = sideB;
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
