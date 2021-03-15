package ru.krista.edu.distrib.tech.socket;

import java.io.*;
import java.net.Socket;

/**
 * Сканирование занятых портов
 * */
public class PortScanner {

    private static int PORT_COUNT = 65535;

    public static void main(String[] args) {
        for (int port=0; port<=PORT_COUNT; port++) {
            try {
                Socket socket = new Socket("localhost", port);
                socket.close();
            } catch (IOException e) {
                System.out.println("Занятый порт " + port);
            }
        }
    }
}
