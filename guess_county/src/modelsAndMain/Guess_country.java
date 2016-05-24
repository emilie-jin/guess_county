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
import java.util.Map.Entry;
import java.util.Scanner;
import score.Question;

/**
 *
 * @author yuzhujin
 */
public class Guess_country {

    public static Map<Pays, Integer> paysScore = new HashMap<>();
    //public static Map<Question, Integer> questionScore = new HashMap<>();
    public static int currentQuestionDegree = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Récupération du nom de tous les pays
        //Attribution d'un score de 0 à tous les pays
        loadPaysData();
        //Mise à 0 du score de réponse des questions
        Map<Question, Integer> questionScore = loadQuestions();
        //Sélection d'une question parmi celles qui ont un score discriminant faible
        Question questionsRaised=pickQuesion(questionScore,currentQuestionDegree);
    
        Scanner sc = new Scanner(System.in); 
        
        System.out.println(questionsRaised.getQuestion());
        System.out.println("--------------------Your answer--------------------");
        System.out.println("1.No 2.Rather not 3.I don't know 4.Rather yes 5.Yes");
        int score = sc.nextInt();
        System.out.println("Your reponse: " + score);
        
        
        questionScore.replace(questionsRaised, 0, score);
        //System.out.println("map:"+ questionScore);
//        System.out.println("map:"+ paysScore);
        
    }

    //Récupération du nom de tous les pays
    //Attribution d'un score de 0 à tous les pays
    private static void loadPaysData() {
        PaysController pc = new PaysController();
        ArrayList<Pays> listPays = pc.getPaysData();
        listPays.stream().forEach((pays) -> {
            paysScore.put(pays, 0);
        });
    }

    //Mise à 0 du score de réponse des questions
    private static Map<Question, Integer> loadQuestions() {
        Map<Question, Integer> questionScore = new HashMap<>();
        questionScore.put(new Question("Hemisphere", "Northern"), 0);
        questionScore.put(new Question("Continent", "Europe"), 0);
        questionScore.put(new Question("NumberOfLanguages", "1"), 0);
        questionScore.put(new Question("AmountOfPeople", "200000"), 0);
        questionScore.put(new Question("Area", "1000000"), 0);
        questionScore.put(new Question("Ocean/Sea", "Atlantic Ocean"), 0);
        questionScore.put(new Question("Currency", "US Dollar"), 0);
        questionScore.put(new Question("OfficialLanguages", "English"), 0);
        questionScore.put(new Question("NationalSport", "Football"), 0);
        questionScore.put(new Question("Religions", "Islam"), 0);
        questionScore.put(new Question("NumberOfBoundaries", "1"), 0);
        questionScore.put(new Question("PoliticalRegime", "Federal State"), 0);
        
        return questionScore;
    }

    private static Question pickQuesion(Map<Question, Integer> questionScore,int currentQuestionDegree) {
        //Sélection d’une question parmi celles qui ont un score discriminant faible
        int lowestQuestionDegree = 12;
        Question question = null;
        for(Entry<Question, Integer> entry : questionScore.entrySet()) {
                if(entry.getKey().getQuestionDegre()<lowestQuestionDegree){
                    lowestQuestionDegree=entry.getKey().getQuestionDegre();
                    question  = entry.getKey();
                    
                }    
                
        }
        return question;
    }

}
