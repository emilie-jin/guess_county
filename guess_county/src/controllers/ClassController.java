/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Adrien
 */
public abstract class ClassController {

    private static final String FILE_PATH = "C:\\Users\\Adrien\\Documents\\Travail\\EPSI\\Cours\\IA\\guess_county\\test.xml";
    private final Utilitary documentHandler;
    private final Document doc;

    public ClassController() {
        this.documentHandler = new Utilitary(FILE_PATH);
        this.doc = documentHandler.getDocument();
    }
    
    /**
     * @return the doc
     */
    public Document getDoc() {
        return doc;
    }
    
    public NodeList getNodeList(String tagName){
        NodeList result;
        //result = this.getDoc().getElementsByTagName(tagName);
        result = this.getDoc().getChildNodes();
        return result;
    }


}
