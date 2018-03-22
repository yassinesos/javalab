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

/**
 * Classe d'essai pour le serveur
 *
 * @author Alain Lebret
 * @version 1.3
 */
public class EssaiServeur {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        ServeurTCP serveur = new ServeurTCP(9090, 2);

        while (true) {
            serveur.ecouter();
        }
    }
} // Fin Essai