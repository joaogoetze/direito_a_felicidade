package com.example.direitoafelicidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import modelDominio.PaginaWeb;

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.MyViewHolder> {

    private List<PaginaWeb> listaPaginasWeb;
    public PaginaWebOnClickListener paginaWebOnClickListener;

    public SiteAdapter(List<PaginaWeb> listaPaginasWeb, PaginaWebOnClickListener paginaWebOnClickListener) {
        this.listaPaginasWeb = listaPaginasWeb;
        this.paginaWebOnClickListener = paginaWebOnClickListener;
    }

    @Override
    public SiteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SiteAdapter.MyViewHolder holder, final int position) {

        PaginaWeb minhaPaginaWeb = listaPaginasWeb.get(position);
        holder.tvPaginaWebNome.setText(minhaPaginaWeb.getNomeConteudo());
        holder.tvAutorSite.setText(minhaPaginaWeb.getAutorPagina());
        holder.tvLinkSite.setText(minhaPaginaWeb.getLinkPagina());
        holder.tvDescricaoSite.setText(minhaPaginaWeb.getDescricaoConteudo());


        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado (sem concatenação), deve ser feita a conversão com o String.valueOf() */

        // clique no item do cliente
        if (paginaWebOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    paginaWebOnClickListener.onClickPaginaWeb(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaPaginasWeb.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPaginaWebNome, tvAutorSite, tvLinkSite, tvDescricaoSite;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvPaginaWebNome = (TextView) itemView.findViewById(R.id.tvNomeSite);
            tvAutorSite = (TextView) itemView.findViewById(R.id.tvAutorSite);
            tvLinkSite = (TextView) itemView.findViewById(R.id.tvLink);
            tvDescricaoSite = (TextView) itemView.findViewById(R.id.tvDescricao);

        }
    }

    public interface PaginaWebOnClickListener {
        public void onClickPaginaWeb(View view, int position);

    }
}
