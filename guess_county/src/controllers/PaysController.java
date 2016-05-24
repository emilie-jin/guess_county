package controllers;

import modelsAndMain.Pays;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yuzhujin
 */
public class PaysController extends ClassController {

    private final int XML_PAYS_LOCATION = 0;

    public PaysController() {
        super();
    }

    public NodeList getPaysList() {
        NodeList listPays = super.getNodeList("ROW");

        return listPays;
    }

    public ArrayList getPaysData() {
        ArrayList<Pays> listPaysResult = new ArrayList();
        NodeList listPays = this.getPaysList();
//        for (int i = 0; i < listPays.getLength(); ++i) {
        Element pays = (Element) listPays.item(XML_PAYS_LOCATION);
        NodeList namelist = pays.getElementsByTagName("pays");
        //NodeList hemispherelist = pays.getElementsByTagName("Hemisphere");

        for (int k = 0; k < namelist.getLength(); ++k) {
            Pays newPays = new Pays();
            Element name = (Element) namelist.item(k);
            String nameText = name.getTextContent();
            System.out.println(k);
            //Element hemisphere = (Element) hemispherelist.item(k);
            //String hemisphereText = hemisphere.getTextContent();
            newPays.setNom(nameText);
            //newPays.setHemisphere(hemisphereText);
            listPaysResult.add(newPays);
//            }·
        }
        return listPaysResult;
    }
    
    public ArrayList getPaysAnswer(String colone,String reponse,String parameter){
        ArrayList<Pays> listPaysAnswer = new ArrayList();
        NodeList listPays = this.getPaysList();
//        for (int i = 0; i < listPays.getLength(); ++i) {
        Element pays = (Element) listPays.item(XML_PAYS_LOCATION);
        NodeList namelist = pays.getElementsByTagName("pays");
        
        for (int k = 0; k < namelist.getLength(); ++k) {
            Pays newPays = new Pays();
            Element name = (Element) namelist.item(k);
            String nameText = name.getTextContent();
            System.out.println(k);
            //Element hemisphere = (Element) hemispherelist.item(k);
            //String hemisphereText = hemisphere.getTextContent();
            newPays.setNom(nameText);
            //newPays.setHemisphere(hemisphereText);
//            listPaysResult.add(newPays);
//            }·
        }
        
        return listPaysAnswer;
    }

    @Override
    public String toString() {
        NodeList listPays = this.getPaysList();
        return this.getPaysData().toString();
    }

}
