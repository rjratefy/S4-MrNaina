/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

/**
 *
 * @author jaona
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class Web { 
     public static void main(String argv[]) {

        try {
            //Obtenir la configuration du sax parser
            SAXParserFactory spfactory = SAXParserFactory.newInstance();
            //Obtenir une instance de l'objet parser
            SAXParser saxParser = spfactory.newSAXParser();

            /*les trois méthodes sont déclarées dans le
 corp du DefaltHandler*/
            DefaultHandler handler = new DefaultHandler() {

                boolean bnom = false;
                boolean bprenom = false;
                boolean bmobile = false;
                boolean bemail = false;

                /*cette méthode est invoquée à chaque fois que parser rencontre
 une balise ouvrante '<' */
                @Override
                public void startElement(String uri, String localName,
                        String qName, Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("nom")) {
                        bnom = true;
                    }

                    if (qName.equalsIgnoreCase("prenom")) {
                        bprenom = true;
                    }

                    if (qName.equalsIgnoreCase("mobile")) {
                        bmobile = true;
                    }

                    if (qName.equalsIgnoreCase("email")) {
                        bemail = true;
                    }
                }

                /*cette méthode est invoquée à chaque fois que parser rencontre
 une balise fermante '>' */
                @Override
                public void endElement(String uri, String localName,
                        String qName) throws SAXException {

                    if (qName.equalsIgnoreCase("nom")) {
                        bnom = false;
                    }

                    if (qName.equalsIgnoreCase("prenom")) {
                        bprenom = false;
                    }

                    if (qName.equalsIgnoreCase("mobile")) {
                        bmobile = false;
                    }

                    if (qName.equalsIgnoreCase("email")) {
                        bemail = false;
                    }
                }

                /*imprime les données stockées entre '<' et '>' */
                @Override
                public void characters(char ch[], int start,
                        int length) throws SAXException {

                    if (bnom) {
                        System.out.println("Nom : "
                                + new String(ch, start, length));
                        bnom = false;
                    }

                    if (bprenom) {
                        System.out.println("Prenom : "
                                + new String(ch, start, length));
                        bprenom = false;
                    }

                    if (bmobile) {
                        System.out.println("Mobile : "
                                + new String(ch, start, length));
                        bmobile = false;
                    }

                    if (bemail) {
                        System.out.println("Email : "
                                + new String(ch, start, length));
                        bemail = false;
                    }
                }

            };

            saxParser.parse("web.xml", handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
        }
    }
    
}
