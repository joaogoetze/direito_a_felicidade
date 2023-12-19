package modelDominio;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.sql.Blob;

public class CanalYoutube extends Conteudo implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private String linkCanal;
    private Bitmap capaCanal;

    public CanalYoutube(int codConteudo, String nomeConteudo, String descricaoConteudo,
                        String descricaoIndicacao, String tematicaConteudo,
                        String linkCanal, Bitmap capaCanal) {
        super(codConteudo, nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo);
        this.linkCanal = linkCanal;
        this.capaCanal = capaCanal;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLinkCanal() {
        return linkCanal;
    }

    public void setLinkCanal(String linkCanal) {
        this.linkCanal = linkCanal;
    }

    public Bitmap getCapaCanal() {
        return capaCanal;
    }

    public void setCapaCanal(Bitmap capaCanal) {
        this.capaCanal = capaCanal;
    }

    @Override
    public String toString() {
        return "CanalYoutube{" +
                "  codConteudo='" + getCodConteudo() + '\'' +
                ", nomeConteudo='" + getNomeConteudo() + '\'' +
                ", descricaoConteudo='" + getDescricaoConteudo() + '\'' +
                ", descricaoIndicacao='" + getDescricaoIndicacao() + '\'' +
                ", tematicaConteudo='" + getTematicaConteudo() + '\'' +
                ", linkCanal='" + linkCanal + '\'' +
                ", capaCanal=" + capaCanal +
                '}';
    }
}
