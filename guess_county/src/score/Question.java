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
public class Question {
    private final Map<String,Integer> questionDegre;

    public Question() {
        this.questionDegre = new HashMap<>();
    }
    
    public void addQuestion(String q,int degre){
        this.questionDegre.put(q, degre);
    }
}
