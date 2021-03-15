package ru.krista.edu.distrib.tech.socket;

import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Обмен сообщениями между клиентом с сервером
 * */
public class Chating {

    private static Logger logger = Logger.getLogger(Chating.class.getName());

    public static void main(String[] args) {
        EchoClient client = new EchoClient();
        try {
            client.startConnection("localhost", 6000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите сообщение: ");
            String message = reader.readLine();
            String answer = client.sendMessage(message);
            System.out.println(answer);
            client.stopConnection();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при чтении ответа сервера", e);
        }

    }
}
