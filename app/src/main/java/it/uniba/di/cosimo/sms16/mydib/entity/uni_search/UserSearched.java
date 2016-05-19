package it.uniba.di.cosimo.sms16.mydib.entity.uni_search;

/**
 * Created by Cosimo on 19/05/2016.
 */
public class UserSearched {
    String nome, cognome, tipo, email,id;

    public UserSearched(String id,String nome, String cognome, String tipo, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.tipo = tipo;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
