/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsAndMain;

/**
 *
 * @author yuzhujin
 */
public class Pays {
    private int id_pays;
    private String nom;
    private double superficie;
    private int nbHabitants;
    private String monnaie;
    private int nbLangages;
    private int nbFrontieres;
    private String continent;
    private String hemisphere;
    /*
    private static final String FILE_PATH="";
    private Utilitary documentHandler;
    private Document doc;
    */
    //private NodeList nodeList; 
    
    public Pays() {        
    }

    public Pays(int id_pays, String nom, double superficie, int nbHabitants, String monnaie, int nbLangages, int nbFrontieres, String continent, String hemisphere) {
        this.id_pays = id_pays;
        this.nom = nom;
        this.superficie = superficie;
        this.nbHabitants = nbHabitants;
        this.monnaie = monnaie;
        this.nbLangages = nbLangages;
        this.nbFrontieres = nbFrontieres;
        this.continent = continent;
        this.hemisphere = hemisphere;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }
    
    

    public int getId_pays() {
        return id_pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public String getMonnaie() {
        return monnaie;
    }

    public void setMonnaie(String monnaie) {
        this.monnaie = monnaie;
    }

    public int getNbLangages() {
        return nbLangages;
    }

    public void setNbLangages(int nbLangages) {
        this.nbLangages = nbLangages;
    }

    public int getNbFrontieres() {
        return nbFrontieres;
    }

    public void setNbFrontieres(int nbFrontieres) {
        this.nbFrontieres = nbFrontieres;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getHemisphere() {
        return hemisphere;
    }

    public void setHemisphere(String hemisphere) {
        this.hemisphere = hemisphere;
    }
    
    
}
