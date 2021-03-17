package ru.krista.serialization;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonSerialization {
    private static Logger logger = Logger.getLogger(JsonSerialization.class.getName());

    public String serialize(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка сериализации", e);
            return "";
        }
    }

    public Object deserialize(String jsonString, Class clazz)  {
        try {
            return new ObjectMapper().readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка десерелиализации", e);
            return null;
        }
    }
}
