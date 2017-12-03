package com.sinetskiy.training.webservices.start;

import com.sinetskiy.training.webservices.parsers.DomParser;
import com.sinetskiy.training.webservices.parsers.SaxParser;
import com.sinetskiy.training.webservices.parsers.StaxParser;

public class Main {

    public static void main(String[] args) {

        String xmlPath = "resource\\people.xml";
        new DomParser().parse(xmlPath);
        new SaxParser().parse(xmlPath);
        new StaxParser().parse(xmlPath);

    }
}
