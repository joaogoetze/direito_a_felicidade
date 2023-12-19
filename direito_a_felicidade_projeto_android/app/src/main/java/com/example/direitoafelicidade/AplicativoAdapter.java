package com.example.direitoafelicidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import modelDominio.Aplicativo;

public class AplicativoAdapter extends RecyclerView.Adapter<AplicativoAdapter.MyViewHolder> {

    private List<Aplicativo> listaAplicativos;
    public AplicativoOnClickListener aplicativoOnClickListener;

    public AplicativoAdapter(List<Aplicativo> listaAplicativos, AplicativoAdapter.AplicativoOnClickListener aplicativoOnClickListener) {
        this.listaAplicativos = listaAplicativos;
        this.aplicativoOnClickListener = aplicativoOnClickListener;
    }

    @Override
    public AplicativoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_aplicativos, parent, false);

        return new AplicativoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AplicativoAdapter.MyViewHolder holder, final int position) {
        Aplicativo meuApp = listaAplicativos.get(position);
        holder.tvNomeAplicativo.setText(meuApp.getNomeConteudo());
        holder.tvLinkAplicativo.setText(meuApp.getLinkAplicativo());
        holder.tvDescricao.setText(meuApp.getDescricaoConteudo());


        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado (sem concatenação), deve ser feita a conversão com o String.valueOf() */

        // clique no item do cliente
        if (aplicativoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aplicativoOnClickListener.onClickAplicativo(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaAplicativos.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeAplicativo, tvLinkAplicativo, tvDescricao;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeAplicativo = (TextView) itemView.findViewById(R.id.tvNomeAplicativo);
            tvLinkAplicativo = (TextView) itemView.findViewById(R.id.tvLinkAplicativo);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);



        }
    }

    public interface AplicativoOnClickListener {
        public void onClickAplicativo(View view, int position);

    }
}
