package com.example.direitoafelicidade;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Aplicativo;
import modelDominio.PaginaWeb;
import modelDominio.Usuario;

public class InformacoesApp extends Application {



    private Usuario usuarioLogado;

    ArrayList<PaginaWeb> listaPaginasWeb;
    ArrayList<Aplicativo> listaAplicativos;

    @Override
    public void onCreate()
    {
        super.onCreate();
        listaPaginasWeb = new ArrayList<PaginaWeb>();
        listaAplicativos = new ArrayList<Aplicativo>();
    }

    public ArrayList<PaginaWeb> getListaPaginasWeb()
    {
        return listaPaginasWeb;
    }

    public ArrayList<Aplicativo> getListaAplicativos()
    {
        return listaAplicativos;
    }

    public void setListaPaginasWeb(ArrayList<PaginaWeb> listaPaginasWeb)
    {
        this.listaPaginasWeb = listaPaginasWeb;
    }

    public void setListaAplicativos(ArrayList<Aplicativo> listaAplicativos)
    {
        this.listaAplicativos = listaAplicativos;
    }

    public Usuario getUsuariosLogado() {
        return usuarioLogado;
    }

    public void setUsuariosLogado(Usuario usuariosLogado) {
        this.usuarioLogado = usuariosLogado;
    }
}
