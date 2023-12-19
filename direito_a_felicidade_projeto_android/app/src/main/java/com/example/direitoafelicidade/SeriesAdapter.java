package com.example.direitoafelicidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import modelDominio.Serie;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;


public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyViewHolder> {
    private List<Serie> listaSeries;
    public SerieOnClickListener serieOnClickListener;

    public SeriesAdapter(List<Serie> listaSeries, SerieOnClickListener serieOnClickListener) {
        this.listaSeries = listaSeries;
        this.serieOnClickListener = serieOnClickListener;
    }

    @Override
    public SeriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new SeriesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SeriesAdapter.MyViewHolder holder, final int position) {

        Serie minhaSerie = listaSeries.get(position);
        holder.tvNomeSerie.setText(minhaSerie.getNomeConteudo());
        holder.tvSinopse.setText(minhaSerie.getSinopseSerie());
        holder.tvDescricao.setText(minhaSerie.getDescricaoConteudo());
        holder.tvTematica.setText(minhaSerie.getTematicaConteudo());
        holder.tvDescricaoIndicacao.setText(minhaSerie.getDescricaoIndicacao());

        if (serieOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    serieOnClickListener.onClickSerie(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaSeries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeSerie, tvSinopse, tvDescricao, tvTematica, tvDescricaoIndicacao;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeSerie = (TextView) itemView.findViewById(R.id.tvNomeSerie);
            tvSinopse = (TextView) itemView.findViewById(R.id.tvSinopse);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            tvTematica = (TextView) itemView.findViewById(R.id.tvTematica);
            tvDescricaoIndicacao = (TextView) itemView.findViewById(R.id.tvDescricaoIndicacao);

        }
    }

    public interface SerieOnClickListener {
        public void onClickSerie(View view, int position);

    }

}
