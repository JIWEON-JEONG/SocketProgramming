package udp_communication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    //DatagramSocket
    //DatagramPacket
    public static void main(String[] args) {
        //UDP - 다수끼리 통신 할때.
        //try 문 안에서 실행되기 때문에 따로 close 안해줘도 됨.
        try {
            DatagramSocket socket = new DatagramSocket();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                byte[] buffer = in.readLine().getBytes();
                InetAddress address = InetAddress.getByName("172.16.39.188");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);
                socket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
