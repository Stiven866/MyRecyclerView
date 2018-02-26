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
 * {@link TrianguloFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TrianguloFragment extends Fragment  {

    private OnFragmentInteractionListener mListener;

    EditText etAltura, etBase, etSideA,etSideB, etSideC;
    RadioGroup radioGroup;
    Button btnSend;
    TextView tvArea, tvPerimetro;
    RadioButton radioButton;
    private String altura, base, sideA,sideB,sideC;
    private float resultado;

    public TrianguloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_triangulo, container, false);
        radioGroup = view.findViewById(R.id.rgrup_triangulo);
        etAltura = view.findViewById(R.id.et_altura_triangulo);
        etBase = view.findViewById(R.id.et_base_triangulo);
        etSideA = view.findViewById(R.id.et_a_triangulo);
        etSideB = view.findViewById(R.id.et_b_triangulo);
        etSideC = view.findViewById(R.id.et_c_triangulo);
        btnSend = view.findViewById(R.id.btn_send);
        tvArea = view.findViewById(R.id.tv_area);
        tvPerimetro = view.findViewById(R.id.tv_perimetro);
        radioButton = view.findViewById(R.id.radio_area_triangulo);

        etSideA.setEnabled(false);
        etSideB.setEnabled(false);
        etSideC.setEnabled(false);
        etAltura.setEnabled(false);
        etBase.setEnabled(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_area_triangulo:
                        etAltura.setFocusable(true);
                        etSideA.setEnabled(false);
                        etSideB.setEnabled(false);
                        etSideC.setEnabled(false);
                        etAltura.setEnabled(true);
                        etBase.setEnabled(true);
                        etSideA.setError(null);
                        etSideB.setError(null);
                        etSideC.setError(null);

                        btnSend.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               setAltura(etAltura.getText().toString());
                               if (getAltura().equals("")){etAltura.setError("Ingrese la altura");}
                               else{
                                   setBase(etBase.getText().toString());
                                   if (getBase().equals("")){etBase.setError("Ingrese la base");}
                                   else{
                                       resultado =Float.valueOf(getAltura())*Float.valueOf(getBase());
                                       tvArea.setText("El area es: " + String.valueOf(resultado));
                                       tvArea.setTextSize(20);
                                       tvArea.setFocusable(true);
                                   }
                               }
                            }
                        });


                        break;
                    case R.id.radio_perimetro_triangulo:
                        etAltura.setEnabled(false);
                        etBase.setEnabled(false);
                        etSideA.setEnabled(true);
                        etSideB.setEnabled(true);
                        etSideC.setEnabled(true);
                        etBase.setError(null);
                        etAltura.setError(null);
                        btnSend.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setSideA(etSideA.getText().toString());
                                if (getSideA().equals("")){etSideA.setError("Ingrese el lado A");}
                                else {
                                    setSideB(etSideB.getText().toString());
                                    if (getSideB().equals("")){etSideB.setError("Ingrese el lado B");}
                                    else {
                                        setSideC(etSideC.getText().toString());
                                        if (getSideC().equals("")){etSideC.setError("ingrse el lado C");}
                                        else {
                                            resultado = Float.valueOf(getSideA()) + Float.valueOf(getSideB()) + Float.valueOf(getSideC());
                                            tvPerimetro.setText("El Perimetro es: " + String.valueOf(resultado));
                                            tvPerimetro.setTextSize(20);
                                            tvPerimetro.setFocusable(true);
                                        }
                                    }
                                }
                            }
                        });

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



    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
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
