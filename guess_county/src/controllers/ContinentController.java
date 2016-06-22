/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author yuzhujin
 */
public class ContinentController extends ClassController{
    public ArrayList<String> getListContinent(){
        ArrayList<String> listContinent = new ArrayList<String>();
        listContinent.add("Amerique du Nord");
        listContinent.add("Asie");
        listContinent.add("Oceanie");
        listContinent.add("Afrique");
        listContinent.add("Europe");
        listContinent.add("Amerique du Sud");
        return listContinent;
    }
}
