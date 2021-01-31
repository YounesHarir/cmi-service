package com.app.utils;

import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DateConverter {

    public XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
        Instant instant=date.toInstant();
        String dateTimeString = instant.toString();
        XMLGregorianCalendar date2
                = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
        return date2;
    }

}
