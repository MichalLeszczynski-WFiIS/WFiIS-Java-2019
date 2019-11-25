package Armia;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class CentrumDowodzenia {

    private ArrayList<Czolg> czolgi = new ArrayList<>();

    public void zarejestrujCzolg(Czolg czolg) {
        czolgi.add(czolg);
    }

    public void wydajRozkaz(String czolg,Rozkaz rozkaz) {
        czolgi.get(Integer.parseInt(czolg)-1).przyjmijRozkaz(rozkaz);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Do tej pory centrum dowodzenia wydalo nastepujace rozkazy: \n");
        for(int i = 1; i < czolgi.size() + 1; i ++) {
            output.append("Czolg nr ").append(i).append(" otrzymal rozkazy:\n");
            output.append(czolgi.get(i-1).wszystkieRozkazy());
        }
        return output.toString();
    }

}