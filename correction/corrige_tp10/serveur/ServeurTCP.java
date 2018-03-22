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
package corrige_tp10.serveur;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Permet de présenter la communication sous TCP - mode Client/Serveur.  Elle utilise :
 * <PRE>
 * IOException  : Indique une erreur d'entrée/sortie quelconque.
 * ServerSocket : Implémente une écoute réseau du côté serveur, c'est-à-dire
 * un objet attendant la connexion d'un client pour établir
 * une connexion.
 * System       : Contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.1
 */
class ServeurTCP {
    /**
     * Port de communication
     */
    private int port;

    /**
     * Socket de contrôle chargée de l'écoute des connexions sur le port
     */
    private ServerSocket receptionniste = null;

    /**
     * Tableau de Services proposé permettant à plusieurs clients d'effectuer des calculs
     */
    private Service[] serviceCalculette;

    /**
     * Numéro du service courant
     */
    private int serviceCourant;

    /**
     * Constructeur par défaut. Met en route la socket de contrôle.
     *
     * @param unPort port de communication
     */
    public ServeurTCP(int unPort, int unNombreClients) {
        port = unPort;
        serviceCalculette = new Service[unNombreClients];
        serviceCourant = 0;

        // Création de la socket de contrôle
        try {
            System.out.println("ServeurTCP - Serveur demarre");
            receptionniste = new ServerSocket(port);
        } catch (IOException exc) {
            System.err.println("ServeurTCP:constructeur() - Impossible de démarrer le serveur");
        }
    }

    /**
     * Attente de la connexion d'un client et création d'un nouveau Service
     * si c'est le cas.
     */
    public void ecouter() {
        try {
            System.out.println("ServeurTCP - Attente d'un client...");
            serviceCalculette[serviceCourant] = new Service(this, receptionniste.accept(), serviceCourant);
            System.out.println("ServeurTCP - Client connecté");
            serviceCalculette[serviceCourant].start();
            System.out.println("ServeurTCP - Service démarré");
            serviceCourant++;
            System.out.println("ServeurTCP - Service rendu");
        } catch (IOException exc) {
            System.err.println("ServeurTCP:ecouter() - problème de connexion");
        }
    }

    /**
     * Accession au numéro du service en cours
     *
     * @return numéro du service courant
     */
    public int getServiceCourant() {
        return serviceCourant;
    }

} // Fin ServeurTCP