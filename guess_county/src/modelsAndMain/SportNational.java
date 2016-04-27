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
public class SportNational {

    private int idSport;
    private String nom;

    public SportNational() {

    }

    public SportNational(int initialId, String initialName) {
        this.idSport = initialId;
        this.nom = initialName;
    }

    /**
     * @return the idSport
     */
    public int getIdSport() {
        return idSport;
    }

    /**
     * @param idSport the idSport to set
     */
    public void setIdSport(int idSport) {
        this.idSport = idSport;
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
