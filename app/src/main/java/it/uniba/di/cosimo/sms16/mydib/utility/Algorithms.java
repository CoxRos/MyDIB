package it.uniba.di.cosimo.sms16.mydib.utility;

import java.util.ArrayList;

import it.uniba.di.cosimo.sms16.mydib.entity.profilo_utente.Esame;

public class Algorithms {

    public double getBaseLaurea(double media) {
        return (media*11)/3;
    }

    public double getMediaPonderata(ArrayList<Esame> esami) {
        double result = 0;
        int sommCFU = 0;
        for(Esame esame : esami) {
            result = result + (Integer.parseInt(esame.getVoto())*Integer.parseInt(esame.getCfu()));
            sommCFU += Integer.parseInt(esame.getCfu());
        }
        return result/sommCFU;
    }

    public double getMediaAritmetica(ArrayList<Esame> esami) {
        double result = 0;
        for(Esame esame : esami) {
            result = result + Integer.parseInt(esame.getVoto());
        }
        return result/esami.size();
    }

}
