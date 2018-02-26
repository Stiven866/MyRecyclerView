package com.stivenduque.myrecyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by stiven on 21/02/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FigureViewHolder> {

    private List<Figure> figures;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public RecyclerViewAdapter(List<Figure> figures, RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.figures = figures;
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }


    @Override
    public FigureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View figure = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new FigureViewHolder(figure);

    }

    @Override
    public void onBindViewHolder(FigureViewHolder holder, int position) {
        Figure figure = figures.get(position);
        holder.getTitleName().setText(figure.getFigureName());
        holder.getComentName().setText(figure.getFigureNameComent());
        holder.getIdPhoto().setImageResource(figure.getIdPhoto());
        }

    @Override
    public int getItemCount() {
        return figures.size();
    }

    public class FigureViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        private ImageView idPhoto;
        private TextView titleName, comentName;
        CardView cardView;
        public FigureViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            idPhoto = itemView.findViewById(R.id.figure_photo);
            titleName = itemView.findViewById(R.id.figure_name);
            comentName = itemView.findViewById(R.id.figure_name_coment);
            itemView.setOnClickListener(this);
        }



        public ImageView getIdPhoto() {
            return idPhoto;
        }

        public TextView getTitleName() {
            return titleName;
        }

        public TextView getComentName() {
            return comentName;
        }
        @Override
        public void onClick(View view) {
            recyclerViewOnClickListener.onClick(view, getAdapterPosition());
        }
    }

}
