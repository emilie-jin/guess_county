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
public class Politique {
    private int idPolitique;
    private String nom;

    public Politique(int idPolitique, String nom) {
        this.idPolitique = idPolitique;
        this.nom = nom;
    }

    public Politique() {
    }

    /**
     * @return the idPolitique
     */
    public int getIdPolitique() {
        return idPolitique;
    }

    /**
     * @param idPolitique the idPolitique to set
     */
    public void setIdPolitique(int idPolitique) {
        this.idPolitique = idPolitique;
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
