/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Adrien
 */
public class Utilitary {

    private File file;
    private Document document;

    public Utilitary(String filePath) {
        try {
            final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            this.file = new File(filePath);
            this.document = documentBuilder.parse(this.file);
            this.document.getDocumentElement().normalize();
        }
        catch(IOException | ParserConfigurationException | SAXException e){
            System.out.println("Error while initializing Utilitary class");
        }
    }

    /**
     * @return the document
     */
    public Document getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(Document document) {
        this.document = document;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
}
