package modelDominio;

import java.io.Serializable;

public class PaginaWeb extends Conteudo implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private String linkPagina;
    private String autorPagina;

    public PaginaWeb(int codConteudo, String nomeConteudo, String descricaoConteudo,
                     String descricaoIndicacao, String tematicaConteudo,
                     String linkPagina, String autorPagina) {
            super(codConteudo, nomeConteudo, descricaoConteudo,
                    descricaoIndicacao, tematicaConteudo);
            this.linkPagina = linkPagina;
            this.autorPagina = autorPagina;
    }





    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    public String getAutorPagina() {
        return autorPagina;
    }

    public void setAutorPagina(String autorPagina) {
        this.autorPagina = autorPagina;
    }

    @Override
    public String toString() {
        return "PaginaWeb{" +
                "  codConteudo='" + getCodConteudo() + '\'' +
                ", nomeConteudo='" + getNomeConteudo() + '\'' +
                ", descricaoConteudo='" + getDescricaoConteudo() + '\'' +
                ", descricaoIndicacao='" + getDescricaoIndicacao() + '\'' +
                ", tematicaConteudo='" + getTematicaConteudo() + '\'' +
                ", linkPagina='" + linkPagina + '\'' +
                ", autorPagina='" + autorPagina + '\'' +
                '}';
    }
}
