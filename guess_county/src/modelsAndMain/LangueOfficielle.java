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
public class LangueOfficielle {
    private int idLangue;
    private String nom;

    public LangueOfficielle() {
    }

    public LangueOfficielle(int idLangue, String nom) {
        this.idLangue = idLangue;
        this.nom = nom;
    }

    
    
    /**
     * @return the idLangue
     */
    public int getIdLangue() {
        return idLangue;
    }

    /**
     * @param idLangue the idLangue to set
     */
    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
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
