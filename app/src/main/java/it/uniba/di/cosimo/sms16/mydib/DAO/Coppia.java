package it.uniba.di.cosimo.sms16.mydib.DAO;

/**
 * Created by sergiocorvino on 01/06/16.
 */
public class Coppia {

    private String key, value;

    public Coppia(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
