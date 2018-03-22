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
import java.net.*;

/**
 * Emetteur de Datagrammes UDP. Il utilise :
 * <PRE>
 * InetAddress          : Représente une adresse IP.
 * DatagramPacket       : Représente un paquet de données pouvant transiter sur un réseau.
 * DatagramSocket       : Représente une connexion réseau permettant l'envoi
 * et la réception de paquets de données (DatagramPacket).
 * SocketException      : Indique une erreur dans le protocole de base d'une connexion
 * réseau.
 * UnknownHostException : Indique que l'adresse IP d'une machine désignée par son nom n'a
 * pu être déterminée.
 * IOException          : Indique une erreur d'entrée/sortie quelconque.
 * System               : Contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.0
 */
class EmetteurUDP {
    /**
     * port sur lequel s'effectue l'emission
     */
    private int port;

    /**
     * Constructeur.
     *
     * @param unPort port sur lequel va s'effectuer l'emission
     */
    public EmetteurUDP(int unPort) {
        port = unPort;
    }

    /**
     * Envoi d'une chaine de caractères sur une machine destinataire.
     *
     * @param destinataire nom de la machine distante sur laquelle se fait l'envoi
     * @param mes          chaine de caractères à envoyer
     */
    public void envoyer(String destinataire, String mes) {
        String s = mes + "@"; // La chaîne est finalisée par un caractère de fin
        int longueur = s.length();
        byte[] message; // Tableau d'octets qui sera placé dans le paquet

        InetAddress adresse = null; // adresse du destinataire
        DatagramSocket socket; // socket de communication


        try {
            // Recherche du destinataire depuis son nom
            adresse = InetAddress.getByName(destinataire);
        } catch (UnknownHostException exc) {
            System.err.println("EmetteurUDP:envoyer() - Destinataire inconnu");
        }

        message = s.getBytes(); // Création du paquet d'octets à partir de la chaîne à envoyer

        try {
            // Création du paquet à envoyer
            DatagramPacket envoi = new DatagramPacket(message, longueur, adresse, port);

            socket = new DatagramSocket(); // Ouverture de la socket d'envoi
            socket.send(envoi); // Envoi du paquet au travers de la socket
            socket.close(); // Fermeture de la socket
        } catch (SocketException e) {
            System.err.println("EmetteurUDP:envoyer() - Erreur lors de la création de la socket");
        } catch (IOException e) {
            System.err.println("EmetteurUDP:envoyer() - Erreur lors de l'envoi sur la socket");
        }
    }
} // Fin EmetteurUDP