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
public class Hemisphere {
    private int id_hemisphere;
    private String nom;

    public Hemisphere(int id_hemisphere, String nom) {
        this.id_hemisphere = id_hemisphere;
        this.nom = nom;
    }

    public Hemisphere() {
    }

    
    public int getId_hemisphere() {
        return id_hemisphere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
