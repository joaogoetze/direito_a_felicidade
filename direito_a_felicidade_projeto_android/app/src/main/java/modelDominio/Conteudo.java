package modelDominio;

import java.io.Serializable;

public class Conteudo implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private int codConteudo;
    private String nomeConteudo;
    private String descricaoConteudo;
    private String descricaoIndicacao;
    private String tematicaConteudo;


    public Conteudo(int codConteudo, String nomeConteudo, String descricaoConteudo, String descricaoIndicacao, String tematicaConteudo) {
        this.codConteudo = codConteudo;
        this.nomeConteudo = nomeConteudo;
        this.descricaoConteudo = descricaoConteudo;
        this.descricaoIndicacao = descricaoIndicacao;
        this.tematicaConteudo = tematicaConteudo;

    }

    public Conteudo(String nomeConteudo, String descricaoConteudo, String descricaoIndicacao, String tematicaConteudo) {
        this.nomeConteudo = nomeConteudo;
        this.descricaoConteudo = descricaoConteudo;
        this.descricaoIndicacao = descricaoIndicacao;
        this.tematicaConteudo = tematicaConteudo;
    }

    public Conteudo(int codConteudo) {
        this.codConteudo = codConteudo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCodConteudo() {
        return codConteudo;
    }

    public void setCodConteudo(int codConteudo) {
        this.codConteudo = codConteudo;
    }

    public String getNomeConteudo() {
        return nomeConteudo;
    }

    public void setNomeConteudo(String nomeConteudo) {
        this.nomeConteudo = nomeConteudo;
    }

    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    public void setDescricaoConteudo(String descricaoConteudo) {
        this.descricaoConteudo = descricaoConteudo;
    }

    public String getDescricaoIndicacao() {
        return descricaoIndicacao;
    }

    public void setDescricaoIndicacao(String descricaoIndicacao) {
        this.descricaoIndicacao = descricaoIndicacao;
    }

    public String getTematicaConteudo() {
        return tematicaConteudo;
    }

    public void setTematicaConteudo(String tematicaConteudo) {
        this.tematicaConteudo = tematicaConteudo;
    }



    @Override
    public String toString() {
        return "Conteudo{" +
                "codConteudo=" + codConteudo +
                ", nomeConteudo='" + nomeConteudo + '\'' +
                ", descricaoConteudo='" + descricaoConteudo + '\'' +
                ", descricaoIndicacao='" + descricaoIndicacao + '\'' +
                ", tematicaConteudo=" + tematicaConteudo +
                '}';
    }
}
