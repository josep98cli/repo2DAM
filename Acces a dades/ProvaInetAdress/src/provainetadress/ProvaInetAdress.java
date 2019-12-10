/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provainetadress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author vesprada
 */
public class ProvaInetAdress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // array d'adreces IP
		InetAddress[] adreces = new InetAddress[4];
		// per nom
		String url = "www.ieslluissimarro.org";
		// per ip
		String ip = "172.217.16.228";
		// per nom
		String nom = "localhost";
		try {
			// Obtenim objectes InetAddress de diferents maneres
			adreces[0] = InetAddress.getLoopbackAddress();
			adreces[1] = InetAddress.getByName(url);
			adreces[2] = InetAddress.getByName(ip);
			adreces[3] = InetAddress.getByName(nom);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("Adreça de " + url + ": " + adreces[1]);
		for (InetAddress adreça : adreces) {
			if (adreça.isLoopbackAddress()) {
				System.out.println(adreça.getHostName() + " té una adreça loopback");
				// Per poder-ho mostrar, passem IP a text
				System.out.println("L'adreça és: " + adreça.getHostAddress());
			} else {
				System.out.println(adreça.getHostName() + " no té una adreça loopback");
				// Per poder-ho mostrar, passem IP a text
				System.out.println("L'adreça és: " + adreça.getHostAddress());
			}
		}

		System.out.println("------------------------------");
		// Obtenir Localhost
		InetAddress local;
		try {
			// InetAddress local = new InetAddress(); // Error
			local = InetAddress.getLocalHost();
			System.out.println("Localhost amb getLocalHost: " + local.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------");
		// Obtenir Localhost
		InetAddress local2 = InetAddress.getLoopbackAddress();
		System.out.println("Localhost amb getLoopbackAddress: " + local2.getHostAddress());

		// Obtenir un conjunt d'ips
		InetAddress[] adreces2;
		String url2 = "epicgames.com";
		System.out.println("------------------------------");
		System.out.println("Adreces diverses adreces de: " + url2);
		try {
			adreces2 = InetAddress.getAllByName(url2);
			
			for (InetAddress adreça : adreces2) {
				// Per poder-ho mostrar, passem IP a text
				System.out.println("L'adreça és: " + adreça.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    }
    
}
