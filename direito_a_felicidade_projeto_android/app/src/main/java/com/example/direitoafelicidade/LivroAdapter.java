package com.example.direitoafelicidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import modelDominio.Livro;

public class LivroAdapter  extends RecyclerView.Adapter<LivroAdapter.MyViewHolder> {

    private List<Livro> listaLivros;
    public LivroAdapter.LivroOnClickListener LivroOnClickListener;

    public LivroAdapter(List<Livro> listaLivros, LivroAdapter.LivroOnClickListener LivroOnClickListener) {
        this.listaLivros = listaLivros;
        this.LivroOnClickListener = LivroOnClickListener;
    }

    @Override
    public LivroAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_livros, parent, false);

        return new LivroAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final LivroAdapter.MyViewHolder holder, final int position) {


        Livro livro = listaLivros.get(position);
        holder.tvNomeLivro.setText(livro.getNomeConteudo());
        holder.tvAutor.setText(livro.getAutorLivro());
        holder.tvGenero.setText(livro.getGeneroLivro());

        // clique no item do cliente
        if (LivroOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LivroOnClickListener.onClickLivro(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeLivro,tvAutor,tvGenero;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeLivro = itemView.findViewById(R.id.tvNomeLivro);
            tvAutor = itemView.findViewById(R.id.tvAutor);
            tvGenero = itemView.findViewById(R.id.tvGenero);

        }
    }

    public interface LivroOnClickListener {
        public void onClickLivro(View view, int position);
    }


}
