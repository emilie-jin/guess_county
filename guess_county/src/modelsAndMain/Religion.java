/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsAndMain;

/**
 *
 * @author Adrien
 */
public class Religion {
    
    private int idReligion;
    private String nom;

    public Religion(int idReligion, String nom) {
        this.idReligion = idReligion;
        this.nom = nom;
    }

    public Religion() {
    }

    /**
     * @return the idReligion
     */
    public int getIdReligion() {
        return idReligion;
    }

    /**
     * @param idReligion the idReligion to set
     */
    public void setIdReligion(int idReligion) {
        this.idReligion = idReligion;
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
