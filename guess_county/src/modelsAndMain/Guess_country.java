/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsAndMain;

import controllers.ContinentController;
import controllers.PaysController;
import controllers.QuestionController;
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
        System.out.println("--------------------Total " + questionScore.size() + " Questions--------------------");
        System.out.println("--------------------Total " + paysScore.size() + " Pays--------------------");
        //Sélection d'une question parmi celles qui ont un score discriminant faible
        Question questionsRaised = pickQuesion(questionScore, currentQuestionDegree);

        Scanner sc = new Scanner(System.in);

        System.out.println(questionsRaised.getQuestion());
        System.out.println("--------------------Your answer--------------------");
        System.out.println("1.No 2.Rather not 3.I don't know 4.Rather yes 5.Yes");
        int score = sc.nextInt();
        questionScore.replace(questionsRaised, 0, score);

        boolean isOver = isOver();

        Question preQuestion = questionsRaised;
        int scoreNextQuestion = score;
        while (!isOver) {
            System.out.println(scoreNextQuestion);
            Question nextQuestion = analyseReponse(preQuestion.getSujet(), scoreNextQuestion, preQuestion);
            preQuestion = nextQuestion;
            System.out.println(nextQuestion.getQuestion());
            System.out.println("--------------------Your answer--------------------");
            System.out.println("1.No 2.Rather not 3.I don't know 4.Rather yes 5.Yes");
            scoreNextQuestion = sc.nextInt();
            questionScore.replace(questionsRaised, 0, scoreNextQuestion);
            System.out.println(questionScore);
            System.out.println(paysScore);
            isOver = isOver();
            if (isOver) {
                Map.Entry<Pays, Integer> maxEntry = null;
                for (Entry<Pays, Integer> entry : paysScore.entrySet()) {
                    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                        maxEntry = entry;
                    }
                }
                System.out.println("--------------------" + maxEntry.getKey().getNom() + "--------------------");
            }
        }

//        for (int i = 0; i < 10; i++) {
//            currentQuestionDegree++;
//            Question nextQuestion = analyseReponse(questionsRaised.getSujet(), score, currentQuestionDegree, questionsRaised);
//            System.out.println(nextQuestion.getQuestion());
//            System.out.println("--------------------Your answer--------------------");
//            System.out.println("1.No 2.Rather not 3.I don't know 4.Rather yes 5.Yes");
//            int scoreNextQuestion = sc.nextInt();
//            questionScore.replace(questionsRaised, 0, scoreNextQuestion);
//        }
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
//        questionScore.put(new Question("Continent", "Europe"), 0);
        QuestionController qc = new QuestionController();
        questionScore.putAll(qc.getQuestionContinent());
        questionScore.put(new Question("NumberOfLanguages", "1"), 0);
        questionScore.put(new Question("AmountOfPeople", "90000000"), 0);
        questionScore.put(new Question("Area", "2000000"), 0);
        questionScore.put(new Question("Ocean/Sea", "Atlantic Ocean"), 0);
        questionScore.put(new Question("Currency", "US Dollar"), 0);
        questionScore.put(new Question("OfficialLanguages", "English"), 0);
        questionScore.put(new Question("NationalSport", "Football"), 0);
        questionScore.put(new Question("Religions", "Islam"), 0);
        //questionScore.put(new Question("NumberOfBoundaries", "1"), 0);
        questionScore.put(new Question("NumberOfBoundaries", "5"), 0);
        questionScore.put(new Question("PoliticalRegime", "Federal State"), 0);

        return questionScore;
    }

    private static boolean isOver() {
        boolean isOver = false;
        Map.Entry<Pays, Integer> maxEntry = null;
        Map.Entry<Pays, Integer> secondEntry = null;
        for (Entry<Pays, Integer> entry : paysScore.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
                secondEntry = maxEntry;
            }
        }
        if (maxEntry != null && secondEntry != null) {
            if (maxEntry.getValue() - 10 > secondEntry.getValue()) {
                isOver = true;
            } else {
                isOver = false;
            }
        }

        if (currentQuestionDegree > 10) {
            isOver = true;
        } else {
            isOver = false;
        }
        return isOver;

    }

    private static Question pickQuesion(Map<Question, Integer> questionScore, int currentQuestionDegree) {
        //Sélection d’une question parmi celles qui ont un score discriminant faible
        int lowestQuestionDegree = 12;
        Question question = null;
        if (currentQuestionDegree == 0) {
            for (Entry<Question, Integer> entry : questionScore.entrySet()) {
                if (entry.getKey().getQuestionDegre() < lowestQuestionDegree) {
                    lowestQuestionDegree = entry.getKey().getQuestionDegre();
                    question = entry.getKey();

                }

            }
        } else {
            for (Entry<Question, Integer> entry : questionScore.entrySet()) {
                if (entry.getKey().getQuestionDegre() == currentQuestionDegree && entry.getValue() == 0) {
                    question = entry.getKey();
                }

            }
        }
        return question;
    }

    private static Question analyseReponse(String sujet, int score, Question questionsRaised) {
        Question newQuestionsRaised = null;
        PaysController pc = new PaysController();
        ArrayList<String> listPays = null;
        switch (sujet) {
            case "Hemisphere":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                //System.out.println(questionsRaised.getQuestion());

                if (score < 3) {
                    listPays = pc.getPaysAnswer("Hemisphere", "S", "equal");
                    System.out.println(listPays.size());
                    addScorePays(listPays, score);

                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Hemisphere", "N", "equal");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "Continent":

                if (score < 3) {
                    listPays = pc.getPaysAnswer("Continent", questionsRaised.getParameter(), "equal");
                    addScorePays(listPays, score);
                    newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Continent", questionsRaised.getParameter(), "notEqual");
                    addScorePays(listPays, score);
                    currentQuestionDegree++;
                    newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                    newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                }
                break;
            case "NumberOfLanguages":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Nombre_de_langages", questionsRaised.getParameter(), "more");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Nombre_de_langages", questionsRaised.getParameter(), "equal");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);

                }
                break;
            case "AmountOfPeople":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Nombre_d_habitants", questionsRaised.getParameter(), "less");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Nombre_d_habitants", questionsRaised.getParameter(), "more");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "Area":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Superficie", questionsRaised.getParameter(), "less");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Superficie", questionsRaised.getParameter(), "more");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "Ocean/Sea":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("OceanMer", questionsRaised.getParameter(), "notContent");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("OceanMer", questionsRaised.getParameter(), "content");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "Currency":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Monnaie", questionsRaised.getParameter(), "notContent");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Monnaie", questionsRaised.getParameter(), "content");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "OfficialLanguages":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Langues_officielles", questionsRaised.getParameter(), "notContent");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Langues_officielles", questionsRaised.getParameter(), "content");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "NationalSport":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Sport_national", questionsRaised.getParameter(), "notContent");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Sport_national", questionsRaised.getParameter(), "content");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "Religions":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Religions", questionsRaised.getParameter(), "notContent");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Religions", questionsRaised.getParameter(), "content");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "NumberOfBoundaries":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Nombre_de_frontieres", questionsRaised.getParameter(), "less");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Nombre_de_frontieres", questionsRaised.getParameter(), "less");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            case "PoliticalRegime":
                currentQuestionDegree++;
                newQuestionsRaised = pickQuesion(loadQuestions(), currentQuestionDegree);
                if (score < 3) {
                    listPays = pc.getPaysAnswer("Politique", questionsRaised.getParameter(), "notContent");
                    addScorePays(listPays, score);
                } else if (score > 3) {
                    listPays = pc.getPaysAnswer("Politique", questionsRaised.getParameter(), "content");
                    addScorePays(listPays, score);
                } else {
                    listPays = pc.getPaysData();
                    addScorePays(listPays, score);
                }
                break;
            default:
                break;
        }
        return newQuestionsRaised;
    }

    private static void addScorePays(ArrayList<String> listPays, int score) {
        for(String pays : listPays){

            for (Entry<Pays, Integer> entry : paysScore.entrySet()) {
                if (entry.getKey().getNom().equals(pays)) {
                    int newScore = entry.getValue() + score;
                    entry.setValue(newScore);
                }
            }

        };

    }

}
