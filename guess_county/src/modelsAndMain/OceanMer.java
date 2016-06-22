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
public class OceanMer {
    private int idOceanMer;
    private String nom;

    public OceanMer(int idOceanMer, String nom) {
        this.idOceanMer = idOceanMer;
        this.nom = nom;
    }

    public OceanMer() {
    }

    
    /**
     * @return the idOceanMer
     */
    public int getIdOceanMer() {
        return idOceanMer;
    }

    /**
     * @param idOceanMer the idOceanMer to set
     */
    public void setIdOceanMer(int idOceanMer) {
        this.idOceanMer = idOceanMer;
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
