package Armia;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class Czolg {

    ArrayList<Rozkaz> rozkazy = new ArrayList<Rozkaz>();

    public void przyjmijRozkaz(Rozkaz rozkaz) {
        rozkazy.add(rozkaz);
    }

    public String ostatniRozkaz() {
        return "Ostatni rozkaz do mnie: " + rozkazy.get(rozkazy.size()-1).getMessage();
    }

    public String wszystkieRozkazy() {
        StringBuilder output = new StringBuilder();
        for(Rozkaz rozkaz : rozkazy) {
            output.append(rozkaz + " \n");
        }
        output.append(" \n");
        return output.toString();
    }

}