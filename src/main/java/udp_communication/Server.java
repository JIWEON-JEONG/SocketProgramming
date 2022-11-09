package udp_communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    //DatagramSocket
    //DatagramPacket
    public static void main(String[] args) {
        //try 문 안에서 실행되기 때문에 따로 close 안해줘도 됨.
        //주의할점 : 바이트로 생각해야한다.
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                System.out.println("UDP Waiting...");
                socket.receive(packet);
                byte[] receivedData = packet.getData();
                System.out.println("[Client-Info]" + packet.getOffset() + ", " + packet.getLength());
                String message = new String(receivedData, packet.getOffset(), packet.getLength());
                System.out.println("[Client]" + message);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
