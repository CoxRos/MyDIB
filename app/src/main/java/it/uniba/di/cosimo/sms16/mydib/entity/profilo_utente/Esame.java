package it.uniba.di.cosimo.sms16.mydib.entity.profilo_utente;

/**
 * Created by sergiocorvino on 06/06/16.
 */
public class Esame {

    String materia,data,cfu,voto;

    public Esame(String materia, String data, String cfu, String voto) {
        this.materia = materia;
        this.data = data;
        this.cfu = cfu;
        this.voto = voto;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCfu() {
        return cfu;
    }

    public void setCfu(String cfu) {
        this.cfu = cfu;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
