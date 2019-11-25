package Armia;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Czolg {

    private ArrayList<Rozkaz> rozkazy = new ArrayList<>();

    void przyjmijRozkaz(Rozkaz rozkaz) {
        rozkazy.add(rozkaz);
    }

    public String ostatniRozkaz() {
        return "Ostatni rozkaz do mnie: " + rozkazy.get(rozkazy.size()-1).getMessage();
    }

    String wszystkieRozkazy() {
        StringBuilder output = new StringBuilder();
        for(Rozkaz rozkaz : rozkazy) {
            output.append(rozkaz).append(" \n");
        }
        output.append(" \n");
        return output.toString();
    }

}