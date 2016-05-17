package it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts;

/**
 * Created by Cosimo on 17/05/2016.
 */
public class E_Contacts {
    String titolo,descrizione,email,telefono;

    public E_Contacts(String titolo, String descrizione, String email, String telefono) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.email = email;
        this.telefono = telefono;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
