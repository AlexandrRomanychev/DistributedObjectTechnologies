import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonConsumer {

    private final Logger logger = Logger.getLogger(PersonConsumer.class);

    @Incoming("persons-in")
    public void receive(Record<Integer, String> record) {
        logger.infof("Got a person from kafka " +  record.key()+ " " + record.value());
    }

}
