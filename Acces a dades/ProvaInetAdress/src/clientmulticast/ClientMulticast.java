/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmulticast;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ClientMulticast {
	MulticastSocket socket;
	InetAddress multicastIP;
	int port;
	int comptador = 0;

	// mètode per inicialitzar el client ipservidor, port i nou socket
	public void init(String strIp, int portValue) throws SocketException, IOException {
		multicastIP = InetAddress.getByName(strIp);
		port = portValue;
		socket = new MulticastSocket(port);
	}

        //obté dades rebudes pel socket Multicast
        //Les mostra per pantalla, comprova si són les últimes a enviar.
	private boolean getData(byte[] data, int length) {
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
		// Comprovador de final
		if (cadena.contains("Acaba")) {
			return false;
		} else {
			return true;
		}
	}
        //si s'ha excedit el temps d'espera, simplement eixim de l'aplicació
	public boolean timeoutExceeded() {
		System.out.println("Temps d'espera Esgotat");
		return false;
	}
        //ficar en marxa el client, es limita a rebre dedes i mostrar-les
        //per pantalla
	public void runClient() throws IOException {
		DatagramPacket packet;
		byte[] receivedData;
		boolean continueRunning = true;
		// activem la subscripció
		socket.joinGroup(multicastIP);
		// el client atén el port fins que decideix finalitzar
		while (continueRunning) {
			// creació del paquet per rebre les dades
                        receivedData = new byte[1024];
			packet = new DatagramPacket(receivedData, 1024);
			// espera de les dades, màxim 5 segons
			socket.setSoTimeout(5000);
			try {
				// espera de les dades
				socket.receive(packet);
				// processament de les dades rebudes i obtenció de la resposta
				continueRunning = getData(packet.getData(), packet.getLength());
			} catch (SocketTimeoutException e) {
				// s'ha excedit el temps d'espera i cal saber què s'ha de fer
				continueRunning = timeoutExceeded();
			}
		}
		// es cancel·la la subscripció al grup de multicast
		//el client no cal que tanque la connexió, simplement deixa la subscripció.
		//si tancara el socket, cap altre client el podria utilitzar
		socket.leaveGroup(multicastIP);
		System.out.println("Acaba recepció multicast");
	}
        
	public static void main(String[] args) {
		// creem nou objecte client i iinicalitzem valors de connexió
		ClientMulticast client = new ClientMulticast();
		//Adreça multicast local 224.0.0.0 fins 224.0.0.255
		String ipServidor = "224.0.0.1";
		int portServidor = 5052;
		// inicialitzem el servidor amb les dades de la connexió
		try {
			client.init(ipServidor, portServidor);
		} catch (SocketException | UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			client.runClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
