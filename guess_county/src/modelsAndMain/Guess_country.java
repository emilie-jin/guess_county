/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsAndMain;

import controllers.PaysController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yuzhujin
 */
public class Guess_country {

    public static Map<Pays, Integer> paysScore = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        paysScore.put(null, 0);
        PaysController pc = new PaysController();
        ArrayList<Pays> listPays = pc.getPaysData();
        loadPaysData(listPays);
    }

    private static void loadPaysData(ArrayList<Pays> listPays) {
        for (Pays pays : listPays) {
            paysScore.put(pays, 0);
            System.out.println(pays.getId_pays());
            System.out.println(pays.getNom());
        }
    }

}
