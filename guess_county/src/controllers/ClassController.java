/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import guess_county.Utilitary;
import org.w3c.dom.Document;

/**
 *
 * @author Adrien
 */
public class ClassController {

    private static final String FILE_PATH = "";
    private final Utilitary documentHandler;
    private final Document doc;

    public ClassController() {
        this.documentHandler = new Utilitary(FILE_PATH);
        this.doc = documentHandler.getDocument();
    }
    
}
