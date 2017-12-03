package com.sinetskiy.training.webservices.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParser {

    public void parse(String xmlPath) {

        try {

            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            saxParser.parse(xmlPath, new SaxHndler());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class SaxHndler extends DefaultHandler {

        String content = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            switch (qName) {

                case "person": {
                    System.out.println("id= " + attributes.getValue("id"));
                    System.out.println("type= " + attributes.getValue("type"));
                    break;
                }
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {

            switch (qName) {
                case "city" : {
                    System.out.println(qName + ": " + content);
                    break;
                }

                case "name" : {
                    System.out.println(qName + ": " + content);
                    break;
                }
            }
        }

        public void characters(char ch[], int start, int length) throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }
    }
}
