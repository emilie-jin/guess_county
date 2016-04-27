/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

/**
 *
 * @author yuzhujin
 */
public class Question {

    private int questionDegre;
    private String sujet;
    private String question;

    public Question(String subject, String parameter) {
        setQuestionAttributes(sujet, parameter);
    }

    /**
     * @return the questionDegre
     */
    public int getQuestionDegre() {
        return questionDegre;
    }

    /**
     * @param questionDegre the questionDegre to set
     */
    public void setQuestionDegre(int questionDegre) {
        this.questionDegre = questionDegre;
    }

    /**
     * @return the sujet
     */
    public String getSujet() {
        return sujet;
    }

    /**
     * @param sujet the sujet to set
     */
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public final void setQuestionAttributes(String sujet, String parameter) {
        switch (sujet) {
            case "Hemisphere":
                this.setQuestionDegre(0);
                this.setQuestion("Is your counrty located in the " + parameter + " hemlisphere?");
                break;
            case "Continent":
                this.setQuestionDegre(0);
                this.setQuestion("Is the country we're looking for part of " + parameter + "?");
                break;
            case "Nombre de langues":
                this.setQuestionDegre(1);
                this.setQuestion("Are more than " + parameter + " language(s) spoken in your country?");
                break;
            case "Nombre d'habitants":
                this.setQuestionDegre(3);
                this.setQuestion("Does your country host more than " + parameter + " people?");
                break;
            case "Superficie":
                this.setQuestionDegre(3);
                this.setQuestion("Is the country you're thinking of bigger than " + parameter + " m²?");
                break;
            case "Ocean/Mer":
                this.setQuestionDegre(4);
                this.setQuestion("Does the " + parameter + " bord the country searched?");
                break;
            case "Monnaie":
                this.setQuestionDegre(9);
                this.setQuestion("Is the " + parameter + " the official currency of your country?");
                break;
            case "Langues officielles":
                this.setQuestionDegre(8);
                this.setQuestion("Is " + parameter + " an official language in the country you're thinking of?");
                break;
            case "Sport national":
                this.setQuestionDegre(7);
                this.setQuestion("Is " + parameter + " the national sport?");
                break;
            case "Religions":
                this.setQuestionDegre(5);
                this.setQuestion("Is " + parameter + " a major religion followed in the country you're thinking of?");
                break;
            case "Nombre de frontières":
                this.setQuestionDegre(2);
                this.setQuestion("Does your country have more than " + parameter + " boundaries?");
                break;
            case "Politique":
                this.setQuestionDegre(6);
                this.setQuestion("Is the country seeked a " + parameter + "?");
                break;
            default:
                break;
        }
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }
}
