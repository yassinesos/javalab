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

/**
 * Calculette bénéficiant d'une sauvegarde des opérations dans un fichier. Ce dernier
 * est un fichier texte pour des raisons de validation rapide (relecture du fichier avec
 * un éditeur de texte). Pour des applications plus conséquentes, l'emploi d'un fichier
 * binaire sera appréciable. Elle voit sa méthode <code>sauvegarder</code> modifiée.
 * Elle utilise :
 * <PRE>
 * IOException : Indique une erreur d'entrée/sortie quelconque
 * System      : Contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </PRE>
 *
 * @author Alain Lebret
 * @version 1.1
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
    public void sauvegarder(String unNomFichier) {
        try {
            ft.ouvrir(unNomFichier, "E");

            for (int i = 0; i < compteur; i++) {
                ft.ecrire(operations[i].toString());
            }
            ft.fermer();
        } catch (java.io.IOException e) {
            System.err.println("CalculetteSauvegarde:sauvegarder() - Echec lors de la sauvegarde");
        }
    }
} // Fin CalculetteSauvegarde