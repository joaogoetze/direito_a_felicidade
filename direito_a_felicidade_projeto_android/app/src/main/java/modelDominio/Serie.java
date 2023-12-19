package modelDominio;

import java.io.Serializable;

public class Serie extends Conteudo implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private byte[] capaSerie;
    private String sinopseSerie;
    private int duracaoSerie;
    private int temporadaSerie;
    private int anoLancamentoSerie;
    private String plataformaSerie;

    public Serie(int codConteudo, String nomeConteudo, String descricaoConteudo, String descricaoIndicacao, String tematicaConteudo,
                byte[] capaSerie, String sinopseSerie, int duracaoSerie, int temporadaSerie, int anoLancamentoSerie, String plataformaSerie) {
        super(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo);
        this.capaSerie = capaSerie;
        this.sinopseSerie = sinopseSerie;
        this.duracaoSerie = duracaoSerie;
        this.temporadaSerie = temporadaSerie;
        this.anoLancamentoSerie = anoLancamentoSerie;
        this.plataformaSerie = plataformaSerie;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte[] getCapaSerie() {
        return capaSerie;
    }

    public void setCapaSerie(byte[] capaSerie) {
        this.capaSerie = capaSerie;
    }

    public String getSinopseSerie() {
        return sinopseSerie;
    }

    public void setSinopseSerie(String sinopseSerie) {
        this.sinopseSerie = sinopseSerie;
    }

    public int getDuracaoSerie() {
        return duracaoSerie;
    }

    public void setDuracaoSerie(int duracaoSerie) {
        this.duracaoSerie = duracaoSerie;
    }

    public int getTemporadaSerie() {
        return temporadaSerie;
    }

    public void setTemporadaSerie(int temporadaSerie) {
        this.temporadaSerie = temporadaSerie;
    }

    public int getAnoLancamentoSerie() {
        return anoLancamentoSerie;
    }

    public void setAnoLancamentoSerie(int anoLancamentoSerie) {
        this.anoLancamentoSerie = anoLancamentoSerie;
    }

    public String getPlataformaSerie() {
        return plataformaSerie;
    }

    public void setPlataformaSerie(String plataformaSerie) {
        this.plataformaSerie = plataformaSerie;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "  codConteudo='" + getCodConteudo() + '\'' +
                ", nomeConteudo='" + getNomeConteudo() + '\'' +
                ", descricaoConteudo='" + getDescricaoConteudo() + '\'' +
                ", descricaoIndicacao='" + getDescricaoIndicacao() + '\'' +
                ", tematicaConteudo='" + getTematicaConteudo() + '\'' +
                ", capaSerie=" + capaSerie +
                ", sinopseSerie='" + sinopseSerie + '\'' +
                ", duracaoSerie=" + duracaoSerie +
                ", temporadaSerie=" + temporadaSerie +
                ", anoLancamentoSerie=" + anoLancamentoSerie +
                ", plataformaSerie='" + plataformaSerie + '\'' +
                '}';
    }
}
