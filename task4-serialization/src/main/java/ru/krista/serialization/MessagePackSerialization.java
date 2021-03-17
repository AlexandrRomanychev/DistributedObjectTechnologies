package ru.krista.serialization;

import org.msgpack.MessagePack;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagePackSerialization {

    private static Logger logger = Logger.getLogger(JsonSerialization.class.getName());

    public byte[] serialization(Object object) {
        try {
            MessagePack messagePack = new MessagePack();
            return messagePack.write(object);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка сериализации", e);
            return new byte[]{};
        }
    }

    public Object deserialization(byte[] serializing, Class clazz) {
        try {
            return new MessagePack().read(serializing, clazz);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка десерелиализации", e);
            return null;
        }
    }
}
