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
package corrige_tp09.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * La classe Service ouvre un flot d'entrée et un flot de sortie sur la socket de
 * communication du client. Elle reçoit le calcul à effectuer et le transmet
 * à la calculette. Une fois le calcul effectué, le résultat est renvoyé par la
 * socket.   Elle utilise :
 * <PRE>
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
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.0
 */
class Service extends Thread {
    /**
     * Indicateur de fin du service
     */
    protected boolean serviceTermine = false;
    /**
     * Numéro du service
     */
    protected int numero;
    /**
     * Objet ServeurTCP avec lequel le Service opère
     */
    ServeurTCP serveur;
    /**
     * Socket de communication
     */
    Socket socket;
    /**
     * Flot d'entrée pour les objets résultats (de type String)
     */
    ObjectInputStream entree = null;
    /**
     * Flot de sortie pour les objets requêtes (de type String)
     */
    ObjectOutputStream sortie = null;
    /**
     * Calculette
     */
    CalculetteSauvegarde calculette;

    /**
     * Constructeur par défaut. Récupère la référence de la socket du Serveur, instancie
     * la calculette et construit les flots de communication.
     *
     * @param unServeur serveur TCP avec lequel le service coopère
     * @param uneSocket socket de communication
     */
    Service(ServeurTCP unServeur, Socket uneSocket, int unNumero) {
        this.serveur = unServeur;
        this.socket = uneSocket;
        this.numero = unNumero;
        calculette = new CalculetteSauvegarde(5);

        // connexion avec le client via la socket
        try {
            entree = new ObjectInputStream(socket.getInputStream());
            sortie = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException exc) {
            System.err.println("Service:constructeur() - Ouverture des flots de communication impossible");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Met en route le service de calcul.
     */
    private void rendreService() {
        try {
            System.out.println("Service - La calculette attend un calcul");
            String tmp = (String) entree.readObject();

            if (tmp.equals("fin")) {
                serviceTermine = true;
            }

            System.out.println("Service - Le calcul a effectuer est : " + tmp);
            calculette.calculer(tmp);
            System.out.println("Service - Calcul effectue");
            calculette.sauvegarder("calculette" + numero + ".txt");
            System.out.println("Service - Sauvegarde effectuee sur le serveur");
            tmp = calculette.toString();
            sortie.writeObject(tmp);
            System.out.println("Service - Resultat transmis au client");
            sortie.flush(); // Chaque flot gagne à  être nettoyé après lecture ou écriture
        } catch (IOException exc) {
            System.err.println("Service:rendreService() - Le service n'a pu etre rendu");
            serviceTermine = true;
        } catch (ClassNotFoundException e) {
            System.err.println("ClientTCP:requeter() - Objet inconnu.");
        }
    }

    /**
     * Fin du service avec fermeture de la socket et des flots de communication associés.
     */
    public void terminer() {
        // fermeture des flots
        try {
            System.out.println("Service - Fin");
            socket.close();
            entree.close();
            sortie.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Redéfinition de la méthode run des Thread
     */
    public void run() {
        while (!serviceTermine) {
            this.rendreService();
        }

        this.terminer();
    }

} // Fin Service