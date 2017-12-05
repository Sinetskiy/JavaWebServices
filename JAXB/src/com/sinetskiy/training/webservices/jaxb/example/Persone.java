package com.sinetskiy.training.webservices.jaxb.example;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persone {

    // обязательно должен быть конструктор без параметров
    public Persone() {
    }

    public Persone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlAttribute(name="id", required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
