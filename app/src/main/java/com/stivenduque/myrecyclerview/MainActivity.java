package com.stivenduque.myrecyclerview;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TrianguloFragment.OnFragmentInteractionListener,
        CirculoFragment.OnFragmentInteractionListener, CuadradoFragment.OnFragmentInteractionListener, CuboFragment.OnFragmentInteractionListener{
    private List<Figure> figures;
    TrianguloFragment trianguloFragment;
    CirculoFragment circuloFragment;
    CuadradoFragment cuadradoFragment;
    CuboFragment cuboFragment;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.fragment_container);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        initFigures();
        recyclerView.setAdapter(new RecyclerViewAdapter(figures, new RecyclerViewOnClickListener() {
            @Override
            public void onClick(View view, int position) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (position){
                    case 0:
                        linearLayout.removeAllViews();
                        trianguloFragment = new TrianguloFragment();
                        transaction.add(R.id.fragment_container, trianguloFragment).commit();
                        break;
                    case 1:
                        linearLayout.removeAllViews();
                        circuloFragment = new CirculoFragment();
                        transaction.add(R.id.fragment_container, circuloFragment).commit();

                        break;
                    case 2:
                        linearLayout.removeAllViews();
                        cuadradoFragment = new CuadradoFragment();
                        transaction.add(R.id.fragment_container, cuadradoFragment).commit();
                        break;
                    case 3:
                        linearLayout.removeAllViews();
                        cuboFragment = new CuboFragment();
                        transaction.add(R.id.fragment_container, cuboFragment).commit();
                        break;

                }
            }
        }));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private  void initFigures(){
        figures = new ArrayList<Figure>();
        figures.add(new Figure("Triangulo", "Área y perimetro", R.drawable.triangulo));
        figures.add(new Figure("Circulo", "Área y perimetro",R.drawable.circulo));
        figures.add(new Figure("Cuadrado","Área y perimetro", R.drawable.cuadrado));
        figures.add(new Figure("Cubo","volumen", R.drawable.cubo));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {}
}
