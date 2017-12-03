package com.sinetskiy.training.webservices.parsers;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaxParser {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void parse(String xmlPath) {
        try {
            XMLEventReader reader = XMLInputFactory.newInstance()
                                            .createXMLEventReader(new FileInputStream(xmlPath));

            XMLEventWriter writer = XMLOutputFactory.newInstance()
                                            .createXMLEventWriter(new FileWriter("resource\\staxParser.xml"));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            boolean cityTag = false;

            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                System.out.println(event);

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT: {

                        if(event.asStartElement().getName().toString().equalsIgnoreCase("city")){
                            cityTag = true;
                            continue;
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        if(cityTag) {
                            continue;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {

                        if(event.asEndElement().getName().toString().equalsIgnoreCase("city")) {
                            cityTag = false;
                            continue;
                        }

                        if(event.asEndElement().getName().toString().equalsIgnoreCase("person")) {
                            writer.add(eventFactory.createStartElement("", null, "date"));
                            writer.add(eventFactory.createCharacters(dateFormat.format(new Date())));
                            writer.add(eventFactory.createEndElement("", null, "date"));
                        }
                        break;
                    }
                }

                writer.add(event);
            }

            writer.flush();
            writer.close();

        } catch ( FileNotFoundException ex ){
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch ( XMLStreamException ex ){
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch ( IOException ex ){
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        try {

            XMLStreamReader reader = XMLInputFactory.newInstance()
                                    .createXMLStreamReader(new FileInputStream(new File(xmlPath)));

            while (reader.hasNext()){
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if("person".equals(reader.getLocalName())){

                            for (int i = 0; i < reader.getAttributeCount(); i++) {
                                System.out.println(reader.getAttributeName(i) + " = " + reader.getAttributeValue(i));
                            }
                            System.out.println();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        System.out.println(reader.getText().trim());
                        System.out.println();
                        break;
                }
            }
        } catch ( XMLStreamException ex ){
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch ( IOException ex ){
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
