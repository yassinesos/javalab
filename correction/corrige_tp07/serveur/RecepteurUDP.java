/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 14000 Caen, France
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package corrige_tp07.serveur;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.StringTokenizer;

/**
 * Récepteur de Datagrammes UDP. Il utilise :
 * <PRE>
 * DatagramPacket       : Représente un paquet de données pouvant transiter sur un réseau.
 * DatagramSocket       : Représente une connexion réseau permettant l'envoi
 * et la réception de paquets de données (DatagramPacket).
 * SocketException      : Indique une erreur dans le protocole de base d'une connexion
 * réseau.
 * IOException          : Indique une erreur d'entrée/sortie quelconque.
 * StringTokenizer      : Permet de découper une chaîne de caractères en éléments de
 * base suivant des séparateurs précis.
 * System               : Contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.0
 */
class RecepteurUDP {
    /**
     * port sur lequel s'effectue la réception
     */
    private int port;

    /**
     * Constructeur.
     *
     * @param unPort port sur lequel va s'effectuer la reception
     */
    public RecepteurUDP(int unPort) {
        port = unPort;
    }

    /**
     * Réception d'une chaine de caractères sur un port donné.
     *
     * @return chaine de caractères reçue
     */
    public String recevoir() {
        byte[] memoire = new byte[1000]; // tableau d'octets pour la réception de la trame
        String message; // message reçu et retourné par la méthode
        DatagramSocket socket; // socket de réception
        DatagramPacket reception; // paquet de réception

        /*
         * Réception du paquet - receive() est une méthode bloquante.
         */
        try {
            socket = new DatagramSocket(port); // Ouverture socket
            reception = new DatagramPacket(memoire, memoire.length); // Création du paquet de réception
            socket.receive(reception); // Attente de réception d'une trame
            socket.close(); // Fermeture de la socket
        } catch (SocketException e) {
            System.err.println("RecepteurUDP:recevoir() - Erreur lors de la création de la socket");
        } catch (IOException e) {
            System.err.println("RecepteurUDP:recevoir() - Erreur lors de la réception sur la socket");
        }

        /*
         * Extraction du caractères de fin de trame
         */
        String trame = new String(memoire);
        StringTokenizer t = new StringTokenizer(trame, "@");
        message = t.nextToken();

        return message;
    }
} // Fin RecepteurUDP
