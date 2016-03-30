/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess_county;

/**
 *
 * @author Adrien
 */
public class Continent {
    private int idContinent;
    private String nom;

    public Continent() {
    }

    public Continent(int idContinent, String nom) {
        this.idContinent = idContinent;
        this.nom = nom;
    }

    
    
    /**
     * @return the idContinent
     */
    public int getIdContinent() {
        return idContinent;
    }

    /**
     * @param idContinent the idContinent to set
     */
    public void setIdContinent(int idContinent) {
        this.idContinent = idContinent;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
