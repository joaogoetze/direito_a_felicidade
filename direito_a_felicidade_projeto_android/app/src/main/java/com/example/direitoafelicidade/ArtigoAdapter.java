package com.example.direitoafelicidade;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import modelDominio.Artigo;

public class ArtigoAdapter  extends RecyclerView.Adapter<ArtigoAdapter.MyViewHolder>  {

    private List<Artigo> listaArtigos;
    public ArtigoAdapter.ArtigoOnClickListener ArtigoOnClickListener;

    public ArtigoAdapter(List<Artigo> listaArtigos, ArtigoAdapter.ArtigoOnClickListener ArtigoOnClickListener) {
        this.listaArtigos = listaArtigos;
        this.ArtigoOnClickListener = ArtigoOnClickListener;
    }

    @Override
    public ArtigoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_artigos, parent, false);

            return new ArtigoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ArtigoAdapter.MyViewHolder holder, final int position) {


        Artigo artigo = listaArtigos.get(position);
        holder.tvNomeArtigo.setText(artigo.getNomeConteudo());
        holder.tvAutorArtigo.setText(artigo.getAutorArtigo());
        Log.d("TesteNoAdapter",artigo.getAutorArtigo());
        holder.tvAnoArtigo.setText(String.valueOf(artigo.getAnoPublicacaoArtigo()));

        // clique no item do cliente
        if (ArtigoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArtigoOnClickListener.onClickArtigo(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaArtigos.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeArtigo,tvAutorArtigo, tvAnoArtigo;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeArtigo = (TextView)itemView.findViewById(R.id.tvNomeArtigo);
            tvAutorArtigo =(TextView)itemView.findViewById(R.id.tvAutorArtigo);
            tvAnoArtigo = (TextView)itemView.findViewById(R.id.tvAnoArtigo);


        }
    }

    public interface ArtigoOnClickListener {
        public void onClickArtigo(View view, int position);
    }



}
