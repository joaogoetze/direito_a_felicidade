package modelDominio;

import java.io.Serializable;

public class Aplicativo extends Conteudo implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private int logoAplicativo;
    private String linkAplicativo;
    private String desenvolvedorAplicativo;
    private int gratisAplicativo;

    public Aplicativo(int codConteudo, String nomeConteudo, String descricaoConteudo,
                      String descricaoIndicacao, String tematicaConteudo,
                      int logoAplicativo, String linkAplicativo, String desenvolvedorAplicativo, int gratisAplicativo) {
        super(codConteudo, nomeConteudo, descricaoConteudo,
                descricaoIndicacao, tematicaConteudo);
        this.logoAplicativo = logoAplicativo;
        this.linkAplicativo = linkAplicativo;
        this.desenvolvedorAplicativo = desenvolvedorAplicativo;
        this.gratisAplicativo = gratisAplicativo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getLogoAplicativo() {
        return logoAplicativo;
    }

    public void setLogoAplicativo(Byte logoAplicativo) {
        this.logoAplicativo = logoAplicativo;
    }

    public String getLinkAplicativo() {
        return linkAplicativo;
    }

    public void setLinkAplicativo(String linkAplicativo) {
        this.linkAplicativo = linkAplicativo;
    }

    public String getDesenvolvedorAplicativo() {
        return desenvolvedorAplicativo;
    }

    public void setDesenvolvedorAplicativo(String desenvolvedorAplicativo) {
        this.desenvolvedorAplicativo = desenvolvedorAplicativo;
    }

    public int getGratisAplicativo() {
        return gratisAplicativo;
    }

    public void setGratisAplicativo(int gratisAplicativo) {
        this.gratisAplicativo = gratisAplicativo;
    }

    @Override
    public String toString() {
        return "Aplicativo{" +
                "  codConteudo='" + getCodConteudo() + '\'' +
                ", nomeConteudo='" + getNomeConteudo() + '\'' +
                ", descricaoConteudo='" + getDescricaoConteudo() + '\'' +
                ", descricaoIndicacao='" + getDescricaoIndicacao() + '\'' +
                ", tematicaConteudo='" + getTematicaConteudo() + '\'' +
                ", logoAplicativo=" + logoAplicativo +
                ", linkAplicativo=" + linkAplicativo +
                ", desenvolvedorAplicativo='" + desenvolvedorAplicativo + '\'' +
                ", gratisAplicativo=" + gratisAplicativo +
                '}';
    }
}
