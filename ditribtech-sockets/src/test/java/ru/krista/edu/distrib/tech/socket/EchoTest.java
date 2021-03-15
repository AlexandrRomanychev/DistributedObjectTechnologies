package ru.krista.edu.distrib.tech.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EchoTest {

    @Test
    void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", 5555);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }

    @Test
    void givenClient1_whenServerResponds_thenCorrect() throws IOException {
        EchoClient client1 = new EchoClient();
        client1.startConnection("127.0.0.1", 6666);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
    }

    @Test
    void givenClient2_whenServerResponds_thenCorrect() throws IOException {
        EchoClient client2 = new EchoClient();
        client2.startConnection("127.0.0.1", 6666);
        String msg1 = client2.sendMessage("hello");
        String msg2 = client2.sendMessage("world");
        String terminate = client2.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
    }
}
