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
package corrige_tp10.client;

/**
 * Permet de lancer et stopper une application native.
 * Elle utilise :
 * <PRE>
 * IOException       : Indique une erreur d'entrée/sortie quelconque.
 * Process           : Représente un processus (programme distinct de la
 * machine virtuelle Java) et permet de le contrôler.
 * Runtime           : Permet à une application de dialoguer avec son
 * contexte d'exécution.
 * String            : Représente une chaîne de caractères dont le contenu
 * ne peut être modifié.
 * SecurityException : Déclenchée par le gestionnaire de sécurité pour
 * indiquer q'une violation de sécurité a eu lieu.
 * System            : Contient plusieurs attributs et méthodes utiles au
 * dialogue avec le système d'exploitation.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class Executeur {

    /**
     * Sous-processus à exécuter
     */
    private Process p = null;

    /**
     * Constructeur par défaut
     */
    public Executeur() {
    } // fin Constructeur par défaut

    /**
     * Permet l'exécution du sous-processus
     *
     * @param commande la commande que l'Executeur doit lancer
     * @see java.lang.Process
     * @see java.lang.Runtime
     */
    public void lancer(String commande) {
        try {
            /* Espace d'environnement dans lequel l'instance d'Executeur existe */
            Runtime r = Runtime.getRuntime();
            p = r.exec(commande);
        } catch (java.io.IOException e) {
            System.err.println("Erreur en E/S : " + e);
        } catch (java.lang.SecurityException e) {
            System.err.println("Atteinte à la sécurité : " + e);
        }
    } // fin lancer

    /**
     * Permet l'arrêt du sous-processus
     *
     * @see java.lang.Process
     */
    public void stopper() {
        p.destroy();
    } // fin stopper
} // Fin Executeur
