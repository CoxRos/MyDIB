package it.uniba.di.cosimo.sms16.mydib.entity.profilo_utente;

/**
 * Created by Cosimo on 20/05/2016.
 */
public class Esame {
    String titolo,professore,data;
    int cfu,voto;

    public Esame(String titolo, String data, int cfu, int voto) {
        this.titolo = titolo;
        this.professore = professore;
        this.data = data;
        this.cfu = cfu;
        this.voto = voto;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
}
