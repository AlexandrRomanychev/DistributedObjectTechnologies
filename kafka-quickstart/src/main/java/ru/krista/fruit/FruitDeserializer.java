package ru.krista.fruit;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import ru.krista.models.Fruit;

public class FruitDeserializer extends ObjectMapperDeserializer<Fruit> {
    public FruitDeserializer(){
        // pass the class to the parent.
        super(Fruit.class);
    }
}
