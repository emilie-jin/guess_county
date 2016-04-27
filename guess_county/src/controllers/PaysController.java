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

    private final int XML_PAYS_LOCATION = 0;

    public PaysController() {
        super();
    }

    public NodeList getPaysList() {
        NodeList listPays = super.getNodeList("pays");

        return listPays;
    }

    public ArrayList getPaysData() {
        ArrayList<Pays> listPaysResult = new ArrayList();
        NodeList listPays = this.getPaysList();
//        for (int i = 0; i < listPays.getLength(); ++i) {
        Element pays = (Element) listPays.item(XML_PAYS_LOCATION);
        NodeList namelist = pays.getElementsByTagName("name");
        NodeList idlist = pays.getElementsByTagName("id");

        for (int k = 0; k < namelist.getLength(); ++k) {
            Pays newPays = new Pays();
            Element name = (Element) namelist.item(k);
            String nameText = name.getTextContent();
            Element id = (Element) idlist.item(k);
            int payId = Integer.parseInt(id.getTextContent());
            newPays.setNom(nameText);
            newPays.setId_pays(payId);
            listPaysResult.add(newPays);
//            }·
        }
        return listPaysResult;
    }

    @Override
    public String toString() {
        NodeList listPays = this.getPaysList();
        return this.getPaysData().toString();
    }

}
