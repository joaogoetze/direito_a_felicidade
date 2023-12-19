package modelDominio;

import java.io.Serializable;

public class Filme extends Conteudo implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private int capaFilme;
    private String sinopseFilme;
    private int duracaoFilme;
    private int anoLancamentoFilme;
    private String plataformaFilme;

    public Filme(int codConteudo, String nomeConteudo, String descricaoConteudo,
                 String descricaoIndicacao, String tematicaConteudo,
                 int capaFilme, String sinopseFilme, int duracaoFilme, int anoLancamentoFilme,
                  String plataformaFilme) {
        super(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo);
        this.capaFilme = capaFilme;
        this.sinopseFilme = sinopseFilme;
        this.duracaoFilme = duracaoFilme;
        this.anoLancamentoFilme = anoLancamentoFilme;

        this.plataformaFilme = plataformaFilme;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCapaFilme() {
        return capaFilme;
    }

    public void setCapaFilme(Byte capaFilme) {
        this.capaFilme = capaFilme;
    }

    public String getSinopseFilme() {
        return sinopseFilme;
    }

    public void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    public int getDuracaoFilme() {
        return duracaoFilme;
    }

    public void setDuracaoFilme(int duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public int getAnoLancamentoFilme() {
        return anoLancamentoFilme;
    }

    public void setAnoLancamentoFilme(int anoLancamentoFilme) {
        this.anoLancamentoFilme = anoLancamentoFilme;
    }


    public String getPlataformaFilme() {
        return plataformaFilme;
    }

    public void setPlataformaFilme(String plataformaFilme) {
        this.plataformaFilme = plataformaFilme;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "capaFilme=" + capaFilme +
                ", sinopseFilme='" + sinopseFilme + '\'' +
                ", duracaoFilme=" + duracaoFilme +
                ", anoLancamentoFilme=" + anoLancamentoFilme +

                ", plataformaFilme='" + plataformaFilme + '\'' +
                '}';
    }
}
