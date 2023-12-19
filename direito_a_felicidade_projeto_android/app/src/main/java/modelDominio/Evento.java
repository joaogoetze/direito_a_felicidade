package modelDominio;

import java.io.Serializable;

public class Evento implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private int dataEvento;
    private String localEvento;
    private String responsavelEvento;

    public Evento(int dataEvento, String localEvento, String responsavelEvento) {
        this.dataEvento = dataEvento;
        this.localEvento = localEvento;
        this.responsavelEvento = responsavelEvento;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(int dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getResponsavelEvento() {
        return responsavelEvento;
    }

    public void setResponsavelEvento(String responsavelEvento) {
        this.responsavelEvento = responsavelEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "dataEvento=" + dataEvento +
                ", localEvento='" + localEvento + '\'' +
                ", responsavelEvento='" + responsavelEvento + '\'' +
                '}';
    }
}
