package com.example.direitoafelicidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import modelDominio.Filme;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.MyViewHolder> {

    private ArrayList<Filme> listaFilmes;
    public FilmeAdapter.FilmeOnClickListener FilmeOnClickListener;

    public FilmeAdapter(ArrayList<Filme> listaFilmes, FilmeAdapter.FilmeOnClickListener FilmeOnClickListener) {
        this.listaFilmes = listaFilmes;
        this.FilmeOnClickListener = FilmeOnClickListener;
    }

    @Override
    public FilmeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_filmes, parent, false);

        return new FilmeAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final FilmeAdapter.MyViewHolder holder, final int position) {

        Filme meuFilme = listaFilmes.get(position);
        holder.tvNomeFilme.setText(meuFilme.getNomeConteudo());
        holder.tvDuracao.setText(String.valueOf(meuFilme.getDuracaoFilme()));
        holder.tvAnoFilme.setText(String.valueOf(meuFilme.getAnoLancamentoFilme()));
        holder.tvSinopse.setText(meuFilme.getSinopseFilme());

        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado (sem concatenação), deve ser feita a conversão com o String.valueOf() */

        // clique no item do cliente
        if (FilmeOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FilmeOnClickListener.onClickFilme(holder.itemView, position);
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView tvNomeFilme, tvDuracao, tvAnoFilme, tvSinopse;

        public MyViewHolder(View itemView) {
            super(itemView);
          tvNomeFilme = (TextView) itemView.findViewById(R.id.tvNomeFilme);
          tvDuracao = (TextView) itemView.findViewById(R.id.tvDuracao);
          tvAnoFilme = (TextView) itemView.findViewById(R.id.tvAnoFilme);
          tvSinopse = (TextView) itemView.findViewById(R.id.tvSinopse);



        }
    }

    public interface FilmeOnClickListener {
        public void onClickFilme(View view, int position);

    }
}
