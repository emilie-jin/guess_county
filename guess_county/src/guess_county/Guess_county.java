/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess_county;

import controllers.PaysController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yuzhujin
 */
public class Guess_county {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<Pays,Integer> paysScore;
        paysScore = new HashMap<>();
        
//        paysScore.put(null, 0);
       
        PaysController pc = new PaysController();
        ArrayList<Pays> listPays = pc.getPaysListName();
        for (Pays pays: listPays) {
            paysScore.put(pays, 0);
            System.out.println(pays.getNom());
        }
        
        final String BEGINNING_OF_THE_QUESTION = "Est-ce que votre pays ";
        final String END_OF_THE_QUESTION = " ?";
    }

}
