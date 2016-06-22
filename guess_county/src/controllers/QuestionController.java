/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import score.Question;

/**
 *
 * @author Adrien
 */
public class QuestionController {

    public Map<Question, Integer> getQuestionContinent() {
        Map<Question, Integer> questionScoreContient = new HashMap<>();
        ContinentController cc = new ContinentController();
        ArrayList<String> listContinent = cc.getListContinent();
        listContinent.stream().forEach((continent) -> {
            questionScoreContient.put(new Question("Continent", continent), 0);
        });
        return questionScoreContient;
    }
    public Map<Question, Integer> getQuestionContinent(ArrayList<String> listContinent) {
        Map<Question, Integer> questionScoreContient = new HashMap<>();
        listContinent.stream().forEach((continent) -> {
            questionScoreContient.put(new Question("Continent", continent), 0);
        });
        return questionScoreContient;
    }
 
    
}
