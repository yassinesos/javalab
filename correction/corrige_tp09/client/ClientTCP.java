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
package corrige_tp09.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Client utilisant le protocole TCP.  Elle utilise :
 * <pre>
 * ClassNotFoundException : Indique qu'une application essaie de charger une
 * classe introuvable.
 * IOException            : Indique une erreur d'entrée/sortie quelconque.
 * ObjectInputStream      : Permet la désérialisation de types primitifs Java et
 * d'objets sérialisés à l'aide de la classe ObjectOutputStream.
 * ObjectOutputStream     : Permet la sérialisation de types Java primitifs ou
 * d'objets sérialisables (implémentants <code>Serializable</code>).
 * Socket                 : Représente une connexion réseau.
 * System                 : Contient plusieurs attributs et méthodes utiles au
 * dialogue avec le system d'exploitation.
 * </pre>
 *
 * @author Alain Lebret
 * @version 1.0
 */
class ClientTCP {
    /**
     * port de communication
     */
    private int port;

    /**
     * socket de communication
     */
    private Socket socket = null;

    /**
     * Flot de sortie pour les objets requêtes (de type String)
     */
    private ObjectOutputStream sortie = null;

    /**
     * Flot d'entrée pour les objets résultats (de type String)
     */
    private ObjectInputStream entree = null;


    /**
     * Constructeur par défaut.
     *
     * @param unPort port de communication
     */
    public ClientTCP(int unPort) {
        port = unPort;
    }

    /**
     * Connexion au serveur TCP. Les canaux de communications sont instanciés et la
     * socket de communication créée.
     *
     * @param unServeur le serveur distant.
     */
    public void connecter(String unServeur) {
        try {
            System.out.println("ClientTCP - Etablissement du canal de communication");
            socket = new Socket(unServeur, port);
            sortie = new ObjectOutputStream(socket.getOutputStream());
            entree = new ObjectInputStream(socket.getInputStream());
            System.out.println("ClientTCP - Connecte au serveur");
        } catch (IOException e) {
            System.err.println("ClientTCP:connecter() - Connexion au serveur impossible.");
        }
    }

    /**
     * Transmission de la requête sous la forme d'un objet de type String, récupération
     * de la réponse sous la forme d'un objet de type String et retour de la dite réponse.
     *
     * @param uneRequete requête à effectuer
     * @return le résultat de la requête
     */
    public String requeter(String uneRequete) {
        String tmp = null;

        try {
            System.out.println("ClientTCP - Envoi de la requête : " + uneRequete);
            sortie.writeObject(uneRequete);
            System.out.println("ClientTCP - Requête envoyée");
            sortie.flush();
            tmp = (String) entree.readObject();
            System.out.println("ClientTCP - Réponse Reçue du serveur : " + tmp);
        } catch (IOException e) {
            System.err.println("ClientTCP:requeter() - Connexion au serveur impossible.");
        } catch (ClassNotFoundException e) {
            System.err.println("ClientTCP:requeter() - Objet inconnu.");
        }

        return tmp;
    }

    /**
     * Déconnexion avec fermeture de la socket et des flots de communication associés.
     */
    public void deconnecter() {
        try {
            System.out.println("ClientTCP - Déconnexion...");
            entree.close();
            sortie.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("ClientTCP:deconnecter() - Connexion au serveur impossible.");
        }
    }
} // Fin ClientTCP
