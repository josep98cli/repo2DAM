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

public class CLientUDP {
	// adreça del servidor
	InetAddress serverIP;
	// port del servidor
	int serverPort;
	// socket per a la connexió
	DatagramSocket socket;
	// comptador de missatges enviats
	int comptador = 0;

	// mètode per inicialitzar el client
	// ipservidor, port i nou socket
	public void init(String host, int port) throws SocketException, UnknownHostException {
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}

	// mètode per a les primeres dades
	private byte[] getFirstRequest() {
		// la primera petició d'informació
		String cadena = "Inici de comunicació";
		byte[] missatge = new byte[1024];
		return cadena.getBytes();
	}

	// mètode que comprova si ha de continuar enviant dades
	private boolean mustContinue(byte[] sendingData) {
		// en aquest cas només comprova si les dades tenen l'String 'Final'
		// hem de passar dades a String
		boolean continua = true;
		String cadena = "";
		try {
			cadena = new String(sendingData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// si la cadena és "close" ha d'acabar
		if (cadena.equals("close")) {
			continua = false;
		}
		return continua;
	}

	private byte[] getDataToRequest(byte[] data, int length) {
		// Dóna un text per ser enviat al servidor
		// missatge a enviar
		byte[] missatge = new byte[1024];
		// Mostrem missatge rebut des del servidor
		String cadena = "";
		// convertim de byte a String
		try {
			cadena = new String(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// Mostrem el missatge
		System.out.println("Rebut: " + cadena.trim());
		cadena = "";
		// Enviarà 5 missatges, i després acabarà
		if (this.comptador < 5) {
			// creem un nou missatge
			cadena = "Missatge Client " + this.comptador;
		} else {
			cadena = "close";
		}
		// passem a byte[] la cadena
		missatge = cadena.getBytes();
		return missatge;
	}

	public void runClient() throws IOException {
		byte[] receivedData = new byte[1024];
		byte[] sendingData;
		DatagramPacket packet;
		// primeres dades a enviar
		sendingData = getFirstRequest();
		// Cadena del missatge a enviar i a rebre
		String cadena = "";
		// mentre no tenim el missatge d'acabar l'enviament
		while (mustContinue(sendingData)) {

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
			// incrementem el comptador de missatges enviats
			this.comptador++;
			// provem de rebre del servidor un nou paquet, renovem el missatge
			receivedData = new byte[1024];
			packet = new DatagramPacket(receivedData, 1024);
			socket.receive(packet);
			// Obtenim més dades per a enviar, si cal
			sendingData = getDataToRequest(packet.getData(), packet.getLength());

		}
		//ja s'ha acabat d'enviar tota la informació
		System.out.println("Fi de comunicació");

	}

	public void close() {
		if (socket != null && !socket.isClosed()) {
			socket.close();
		}
	}

	public static void main(String[] args) {
		// creem nou objecte client i iinicalitzem valors de connexió
		CLientUDP client = new CLientUDP();
		String ipServidor = "192.168.8.39";
		int portServidor = 55000;
		//inicialitzem el servidor amb les dades de la connexió
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

