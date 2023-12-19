package com.example.direitoafelicidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import modelDominio.CanalYoutube;
import modelDominio.Conteudo;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.MyViewHolder> {
    private ArrayList<CanalYoutube> listaCanais;
    private YoutubeOnClickListener YoutubeOnClickListener;

    public YoutubeAdapter(ArrayList<CanalYoutube> listaCanais, YoutubeOnClickListener YoutubeOnClickListener) {
        this.listaCanais = listaCanais;
        this.YoutubeOnClickListener = YoutubeOnClickListener;
    }

    @Override
    public YoutubeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_youtube, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final YoutubeAdapter.MyViewHolder holder, final int position) {


        Conteudo canal = listaCanais.get(position);
        holder.tvNomeCanal.setText(canal.getNomeConteudo());


        // clique no item do cliente
        if (YoutubeOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    YoutubeOnClickListener.onClickYoutube(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaCanais.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeCanal;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeCanal = itemView.findViewById(R.id.tvNomeCanal);


        }
    }

    public interface YoutubeOnClickListener {
        public void onClickYoutube(View view, int position);
    }

}
