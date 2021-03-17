package ru.krista.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlSerialization {

    private static Logger logger = Logger.getLogger(XmlSerialization.class.getName());

    public String serialize(Object object) {
        try {
            return new XmlMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.log(Level.SEVERE, "Ошибка сериализации", e);
            return null;
        }
    }

    public Object deserialize(String xmlStr, Class clazz) {
        try {
            return new XmlMapper().readValue(xmlStr, clazz);
        } catch (JsonProcessingException e) {
            logger.log(Level.SEVERE, "Ошибка десерелиализации", e);
            return null;
        }
    }
}
