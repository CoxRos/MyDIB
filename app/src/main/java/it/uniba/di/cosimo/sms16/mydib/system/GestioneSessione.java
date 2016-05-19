package it.uniba.di.cosimo.sms16.mydib.system;

import java.util.ArrayList;

import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_search.UserSearched;

/**
 * Created by Cosimo on 16/05/2016.
 */
public class GestioneSessione {

    public static ArrayList<E_Contacts> contacts = new ArrayList<E_Contacts>();
    public static ArrayList<UserSearched> userSearched = new ArrayList<UserSearched>();

    public static void setContacts(ArrayList<E_Contacts> contacts) {
        GestioneSessione.contacts = contacts;
    }
    public static ArrayList<E_Contacts> getContacts() {
        return contacts;
    }

    public static ArrayList<UserSearched> getUserSearched() {
        return userSearched;
    }

    public static void setUserSearched(ArrayList<UserSearched> userSearched) {
        GestioneSessione.userSearched = userSearched;
    }
}
