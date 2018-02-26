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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CuboFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CuboFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    EditText etsideA, etsideB, etsideC;
    TextView tvResult;
    ImageView imageCube;
    Button btnSend;
    private String sideA, sideB,sideC;
    private float result;
    public CuboFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cubo, container, false);
        etsideA = view.findViewById(R.id.et_side_cubeA);
        etsideB = view.findViewById(R.id.et_side_cubeB);
        etsideC = view.findViewById(R.id.et_side_cubeC);
        tvResult = view.findViewById(R.id.tv_radio_cube);
        imageCube = view.findViewById(R.id.fragment_image_cube);
        btnSend = view.findViewById(R.id.btn_send_cube);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSideA(etsideA.getText().toString());
                if (getSideA().equals("")){etsideA.setError("Ingrese el lado A");}
                else {
                    setSideB(etsideB.getText().toString());
                    if (getSideB().equals("")){etsideB.setError("Ingrese el lado B");}
                    else {
                        setSideC(etsideC.getText().toString());
                        if (getSideC().equals("")){etsideC.setError("Ingrese el lado C");}
                        else {
                            result = Float.valueOf(getSideA()) * Float.valueOf(getSideB()) * Float.valueOf(getSideC());
                            tvResult.setText("El volumén es: "+ String.valueOf(result));
                            tvResult.setTextSize(20);
                            tvResult.setFocusable(true);
                        }
                    }
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

    public String getSideC() {
        return sideC;
    }

    public void setSideC(String sideC) {
        this.sideC = sideC;
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
