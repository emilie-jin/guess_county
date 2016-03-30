/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.w3c.dom.NodeList;

/**
 *
 * @author Adrien
 */
public class SportNationalController extends ClassController {

    public SportNationalController() {
        super();
    }

    /**
     * @return the SportNationalById
     */
    public NodeList getSportNationalById() {
        return super.getNodeList("idSportNational");
    }

}
