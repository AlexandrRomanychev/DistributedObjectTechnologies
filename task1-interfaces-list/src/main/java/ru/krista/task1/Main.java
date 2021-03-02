package ru.krista.task1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {

    private static void getInterfaceList(){
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ne = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddress = ne.getInetAddresses();
                System.out.println("**********************************************");
                System.out.println("Имя интерфейса компьютера: " + ne.getName());
                while (inetAddress.hasMoreElements()) {
                    System.out.println("IP-адрес компьютера: " + inetAddress.nextElement().getHostAddress());
                }
                byte[] mac = ne.getHardwareAddress();
                StringBuilder sb = new StringBuilder();
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                }
                System.out.println("MAC-адрес компьютера: "+ sb.toString());
            }
        } catch (SocketException ex) {
            System.err.println("Ошибка при получении списка интерфейсов!");
        }
    }

    public static void main(String[] args) {
        getInterfaceList();
    }
}
