package com.sinetskiy.training.webservices.jaxb.main;

import com.sinetskiy.training.webservices.jaxb.example.People;
import com.sinetskiy.training.webservices.jaxb.example.Persone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Satrt {

    public static void main(String[] args) {

        Persone persone1 = new Persone(1, "Ivan");
        Persone persone2 = new Persone(2, "Nikolay");
        Persone persone3 = new Persone(3, "David");
        Persone persone4 = new Persone(4, "Michele");
        Persone persone5 = new Persone(5, "Катя");

        People people = new People();

        people.getPeople().add(persone1);
        people.getPeople().add(persone2);
        people.getPeople().add(persone3);
        people.getPeople().add(persone4);
        people.getPeople().add(persone5);

        try {
            File file = new File("resources\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
            Marshaller  marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(people, file);
            marshaller.marshal(people, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
