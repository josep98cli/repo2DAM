/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientudp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author vesprada
 */
public class ClientUdp {
    // adreça del servidor
	InetAddress serverIP;
	// port del servidor
	int serverPort;
	// socket per a la connexió
	DatagramSocket socket;

	// mètode per inicialitzar el client
	// ipservidor, port i nou socket
	public void init(String host, int port) throws SocketException, UnknownHostException {
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}

	public void runClient() throws IOException {
		byte[] receivedData = new byte[1024];
		byte[] sendingData;
		//per comprovar si el servidor envia resposta
		boolean respostaRebuda =false;
		DatagramPacket packet;
		// dades a enviar
		String cadena = "Josep";
		byte[] missatge = new byte[1024];
		sendingData = cadena.getBytes();
		// mentre no rebem resposta del servidor
		while (!respostaRebuda) {
			// creació del paquet a enviar, indicant missatge, ip i port destí
			packet = new DatagramPacket(sendingData, sendingData.length, this.serverIP, this.serverPort);

			// Enviament del missatge
			socket.send(packet);
			// convertim de byte a String per visualitzar
			try {
				cadena = new String(packet.getData(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("Enviat: " + cadena);

			// provem de rebre del servidor un nou paquet, renovem el missatge
			receivedData = new byte[1024];
			packet = new DatagramPacket(receivedData, 1024);
			socket.receive(packet);
			receivedData = packet.getData();
			// convertim de byte a String
			try {
				cadena = new String(receivedData, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("Rebut: " + cadena);
			//per acabar, només rebem un missatge del servidor
			respostaRebuda = true;

		}
		// ja s'ha acabat d'enviar tota la informació
		System.out.println("Fi de comunicació");

	}

	public void close() {
		if (socket != null && !socket.isClosed()) {
			socket.close();
		}
	}

	public static void main(String[] args) {
		// creem nou objecte client i iinicalitzem valors de connexió
		ClientUdp client = new ClientUdp();
		String ipServidor = "192.168.8.39";
		int portServidor = 60000;
		// inicialitzem el servidor amb les dades de la connexió
		try {
			client.init(ipServidor, portServidor);
		} catch (SocketException | UnknownHostException e1) {
			e1.printStackTrace();
		}
		try {
			client.runClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
		client.close();

	}
}
