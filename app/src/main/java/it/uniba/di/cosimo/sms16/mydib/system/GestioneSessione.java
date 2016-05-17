package it.uniba.di.cosimo.sms16.mydib.system;

import java.util.ArrayList;

import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;

/**
 * Created by Cosimo on 16/05/2016.
 */
public class GestioneSessione {

    public static void setContacts(ArrayList<E_Contacts> contacts) {
        GestioneSessione.contacts = contacts;
    }

    public static ArrayList<E_Contacts> contacts = new ArrayList<E_Contacts>();

    public static ArrayList<E_Contacts> getContacts() {
        return contacts;
    }
}
