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

/**
 * Classe d'essai pour la calculette en mode UDP. Elle utilise :
 * <PRE>
 * System      : Contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.3
 */
public class EssaiServeur {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        CalculetteSauvegarde calculette = new CalculetteSauvegarde(5);
        EmetteurUDP emetteur = new EmetteurUDP(4001);
        RecepteurUDP recepteur = new RecepteurUDP(4000);

        while (true) {
            System.out.println("Serveur UDP - Attente d'un calcul");
            String tmp = recepteur.recevoir();
            if (tmp.equals("fin")) {
                return;
            }
            System.out.println("Le calcul recu est : \n" + tmp);
            calculette.calculer(tmp);
            calculette.sauvegarder();
            tmp = calculette.toString();
            System.out.println("Le resultat envoye est : \n" + tmp);
            emetteur.envoyer("127.0.0.1", tmp);
        }
    }
} // Fin Essai
