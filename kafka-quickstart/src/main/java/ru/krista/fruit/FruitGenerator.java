package ru.krista.fruit;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import ru.krista.models.Fruit;

import javax.enterprise.context.ApplicationScoped;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class FruitGenerator {

    private Random random = new Random();

    @Outgoing("generated-fruit")
    public Multi<Fruit> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .onOverflow().drop()
                .map(tick -> new Fruit("apple", random.nextInt(100)));
    }

}
