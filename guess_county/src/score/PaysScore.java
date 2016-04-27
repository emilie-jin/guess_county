/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import guess_county.Pays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author yuzhujin
 */
public class PaysScore {

    private final Map<Pays,Integer> paysScore;

    public PaysScore() {
        this.paysScore = new HashMap<>();
    }
    
    public void addPays(Pays p){
        this.paysScore.put(p, 0);
    }
    
    
}
