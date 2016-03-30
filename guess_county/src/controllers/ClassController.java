/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import guess_county.Utilitary;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Adrien
 */
public abstract class ClassController {

    private static final String FILE_PATH = "";
    private final Utilitary documentHandler;
    private final Document doc;

    public ClassController() {
        this.documentHandler = new Utilitary(FILE_PATH);
        this.doc = documentHandler.getDocument();
    }

    public NodeList getNodeList(String tagName){
        NodeList result;
        result = this.getDoc().getElementsByTagName(tagName);
        return result;
    }

    /**
     * @return the doc
     */
    public Document getDoc() {
        return doc;
    }
}
