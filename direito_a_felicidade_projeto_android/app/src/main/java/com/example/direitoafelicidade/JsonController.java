package com.example.direitoafelicidade;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.Base64OutputStream;
import android.util.Log;
import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;

import modelDominio.Aplicativo;
import modelDominio.Artigo;
import modelDominio.CanalYoutube;
import modelDominio.Livro;
import modelDominio.PaginaWeb;
import modelDominio.Filme;
import modelDominio.Serie;

public class JsonController {

    public static Bitmap ByteArrayToBitmap(byte[] byteArray)
    {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Log.d("Imagem","ArrayInputStream: "+ arrayInputStream);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        Log.d("Imagem","Capa em Bitmap: "+ bitmap);
        return bitmap;
    }

    public static ArrayList<CanalYoutube> obtemCanaisYoutube(JSONObject jsonObject, String response ) {

        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<CanalYoutube> listaCanais = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("canal");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");
                String linkCanal = jsonConsulta.getString("linkCanal");
                
                String capaCanalString = jsonConsulta.getString("capacanal");
                Log.d("Teste capa","var capaCanalString: " + capaCanalString);
                byte[] capaCanalByte = capaCanalString.getBytes();


                Bitmap capaCanal = ByteArrayToBitmap(capaCanalByte);

                CanalYoutube canalYoutube = new CanalYoutube(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo, linkCanal, capaCanal);
                listaCanais.add(canalYoutube);
            }
            Log.d("Teste", "Teste se está adicionando na lista " + listaCanais);
            return listaCanais;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("Teste try", "Erro JSON: " + e.getMessage());
            return null;
        }
    }


    public static ArrayList<Serie> obtemSeries (JSONObject jsonObject, String response)
    {
        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<Serie> listaSeries = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("series");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");

                String capaSerieString = jsonConsulta.getString("capaSerie");
                byte[] capaSerie = capaSerieString.getBytes();
                String sinopseSerie = jsonConsulta.getString("sinopseSerie");
                String duracaoSerieString = jsonConsulta.getString("duracaoSerie");
                int duracaoSerie= Integer.parseInt(duracaoSerieString);
                String temporadaSerieString = jsonConsulta.getString("temporadaSerie");
                int temporadaSerie = Integer.parseInt(temporadaSerieString);
                String anoLancamentoSerieString = jsonConsulta.getString("anoLancamentoSerie");
                int anoLancamentoSerie = Integer.parseInt(anoLancamentoSerieString);
                String plataFormaSerie = jsonConsulta.getString("plataformaSerie");

                Serie serie = new Serie(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao,
                                        tematicaConteudo, capaSerie, sinopseSerie, duracaoSerie, temporadaSerie,
                                        anoLancamentoSerie, plataFormaSerie);
                listaSeries.add(serie);
            }
            Log.d("Teste", "Teste se está adicionando na lista " + listaSeries);
            return listaSeries;
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }










    public static ArrayList<PaginaWeb> obtemPaginasWeb(JSONObject jsonObject, String response ) {

        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<PaginaWeb> listaPaginasWeb = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("sites");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");

                String linkPagina = jsonConsulta.getString("linkPagina");
                String autorPagina = jsonConsulta.getString("autorPagina");

                PaginaWeb paginaWeb = new PaginaWeb(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo, linkPagina, autorPagina);
                listaPaginasWeb.add(paginaWeb);
            }
            Log.d("Teste", "Teste se está adicionando na lista " + listaPaginasWeb);
            return listaPaginasWeb;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("Teste try", "Erro JSON: " + e.getMessage());
            return null;
        }
    }



    //Método que trata o resultado da consutla JSON, transforamndo em objetos e adicionando na lista
    public static ArrayList<Livro> obtemLivros(JSONObject jsonObject, String response ) {

        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<Livro> listaLivros = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("livros");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");




                String editoraLivro = jsonConsulta.getString("editoraLivro");
                String capaLivroString = jsonConsulta.getString("capaLivro");
                int capaLivro = Integer.parseInt(capaLivroString);
                String anoLivroString = jsonConsulta.getString("anoLivro");
                int anoLivro = Integer.parseInt(anoLivroString);
                String paginasLivroString = jsonConsulta.getString("paginasLivro");
                int paginasLivro = Integer.parseInt(paginasLivroString);
                String autorLivro = jsonConsulta.getString("autorLivro");
                String generoLivro = jsonConsulta.getString("generoLivro");



                Livro livro = new Livro(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo, editoraLivro, capaLivro,anoLivro,paginasLivro,autorLivro,generoLivro);
                listaLivros.add(livro);
            }
            Log.d("Teste", "Teste se está adicionando na lista " + listaLivros);
            return listaLivros;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("Teste try", "Erro JSON: " + e.getMessage());
            return null;
        }
    }



    public static ArrayList<Aplicativo> obtemAplicativos(JSONObject jsonObject, String response ) {

        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<Aplicativo> listaAplicativos = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("aplicativo");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");


                String logoAplicativoString = jsonConsulta.getString("logoAplicativo");
                int logoAplicativo = Integer.parseInt(logoAplicativoString);
                String linkAplicativo = jsonConsulta.getString("linkAplicativo");
                String desenvolvedorAplicativo = jsonConsulta.getString("desenvolvedoresAplicativo");
                int gratisAplicativo = Integer.parseInt(jsonConsulta.getString("gratisAplicativo"));


                Aplicativo app = new Aplicativo(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo, logoAplicativo, linkAplicativo,desenvolvedorAplicativo,gratisAplicativo);
                listaAplicativos.add(app);
            }
            Log.d("Teste", "Teste se está adicionando na lista " + listaAplicativos);
            return listaAplicativos;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("Teste try", "Erro JSON: " + e.getMessage());
            return null;
        }
    }

    public static ArrayList<Artigo> obtemArtigos(JSONObject jsonObject, String response ) {

        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<Artigo> listaArtigos = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("artigo");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");




                String linkArtigo = jsonConsulta.getString("linkArtigo");
                String resumoArtigo = jsonConsulta.getString("resumoArtigo");
                int anoPublicacaoArtigo = Integer.parseInt(jsonConsulta.getString("anoPublicacao"));
                Log.d("AnoPublicacao", String.valueOf(anoPublicacaoArtigo));
                String autorArtigo = jsonConsulta.getString("autorArtigo");



                Artigo artigo = new Artigo(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo, linkArtigo, resumoArtigo,anoPublicacaoArtigo,autorArtigo);
                listaArtigos.add(artigo);
            }
            Log.d("TesteArtigos", "Teste se está adicionando na lista " + listaArtigos);
            return listaArtigos;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("Teste try", "Erro JSON: " + e.getMessage());
            return null;
        }
    }




    public static ArrayList<Filme> obtemFilmes(JSONObject jsonObject, String response ) {

        Log.d("Retorno", "jsonObject " + jsonObject.toString());
        Log.d("Retorno", "Response " + response);

        try
        {
            ArrayList<Filme> listaFilmes = new ArrayList<>();
            JSONObject jsonConsulta = new JSONObject();
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("filmes");

            for(int x=0; x<jsonArray.length(); x++)
            {
                jsonConsulta = jsonArray.getJSONObject(x);
                String codConteudoString = jsonConsulta.getString("codConteudo");
                int codConteudo = Integer.parseInt(codConteudoString);
                String nomeConteudo = jsonConsulta.getString("nomeConteudo");
                String descricaoConteudo = jsonConsulta.getString("descricaoConteudo");
                String descricaoIndicacao = jsonConsulta.getString("descricaoIndicacao");
                String tematicaConteudo = jsonConsulta.getString("tematicaConteudo");



                int capaFilme =Integer.parseInt(jsonConsulta.getString("capaFilme"));
                String sinopseFilme = jsonConsulta.getString("sinopseFilme");
                int duracaoFilme = Integer.parseInt(jsonConsulta.getString("duracaoFilme"));
                int anoLancamentoFilme = Integer.parseInt(jsonConsulta.getString("anoLancamentoFilme"));
                String plataformasFilme = jsonConsulta.getString("plataformaFilme");



                Filme filme = new Filme(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo, capaFilme, sinopseFilme,duracaoFilme, anoLancamentoFilme, plataformasFilme);
                listaFilmes.add(filme);
            }
            Log.d("Teste", "Teste se está adicionando na lista " + listaFilmes);
            return listaFilmes;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("Teste try", "Erro JSON: " + e.getMessage());
            return null;
        }
    }



}
