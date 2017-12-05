package com.sinetskiy.training.webservices.jaxb.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class People {

    @XmlElement(name="person")
    private List<Persone> people = new ArrayList<Persone>();

    public List<Persone> getPeople() {
        return people;
    }

    public void setPeople(List<Persone> people) {
        this.people = people;
    }
}
