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

import corrige_tp06.FichierTexte;
import corrige_tp06.OperationMathematique;

/**
 * Calculette bénéficiant d'une sauvegarde des opérations dans un fichier. Ce dernier
 * est un fichier texte pour des raisons de validation rapide (relecture du fichier avec
 * un éditeur de texte). Pour des applications plus conséquentes, l'emploi d'un fichier
 * binaire sera appréciable.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class CalculetteSauvegarde extends Calculette {
    /**
     * Fichier texte utilisé dans le corrigé pour une validation rapide
     */
    private FichierTexte ft;

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     */
    public CalculetteSauvegarde(int uneTaille) {
        super(uneTaille);
        ft = new FichierTexte();
    }

    /**
     * Effectue la sauvegarde souhaitée
     */
    public void sauvegarder() {
        try {
            ft.ouvrir("calculette.txt", "E");

            for (OperationMathematique operation : operations) {
                if (operation != null) {
                    ft.ecrire(operation.toString());
                }
            }
            ft.fermer();
        } catch (java.io.IOException e) {
            System.err.println("CalculetteSauvegarde:sauvegarder() - Echec lors de la sauvegarde");
        }
    }
} // Fin CalculetteSauvegarde