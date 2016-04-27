package controllers;

import guess_county.Pays;
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

    public PaysController() {
        super();
    }

    public NodeList getPaysList() {
        NodeList listPays = super.getNodeList("pays");

        return listPays;
    }

    public ArrayList getPaysListName() {
        ArrayList<Pays> listPaysResult = new ArrayList();
        NodeList listPays = this.getPaysList();
        for (int i = 0; i < listPays.getLength(); ++i) {
            Element pays = (Element) listPays.item(i);
            NodeList namelist = pays.getElementsByTagName("name");
            for (int k = 0; k < namelist.getLength(); ++k) {
                Pays newPays = new Pays();
                Element name = (Element) namelist.item(k);
                String nameText = name.getTextContent();
                newPays.setNom(nameText);
                listPaysResult.add(newPays);
            }
        }
        return listPaysResult;
    }

    @Override
    public String toString() {
        NodeList listPays = this.getPaysList();
        /*
         StringBuilder result = new StringBuilder();
         for (int i = 0; i < listPays.getLength(); ++i) {
         Element pays = (Element) listPays.item(i);
         String paysName = pays.getAttribute("name");
         result.append(paysName);
         }
         return result.toString();
         */
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < listPays.getLength(); ++i) {
//            Element pays = (Element) listPays.item(i);
//            NodeList namelist = pays.getElementsByTagName("name");
//            for (int k = 0; k < namelist.getLength(); ++k) {
//                Element name = (Element) namelist.item(k);
//                String nameText = name.getFirstChild().getNodeValue();
//                result.append(nameText);
//            }
//        }
//        return result.toString();
        return this.getPaysListName().toString();
    }

}
