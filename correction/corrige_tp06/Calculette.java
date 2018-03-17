/*
 * SVEN is an open source Java library for machine learning, image analysis
 * and computer vision educational projects.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 4000 Caen, France
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
package corrige_tp06;

/**
 * Amélioration de la calculette du TP no 2 avec gestion d'un tableau des n dernières
 * opérations effectuées.
 *
 * @author Alain Lebret
 * @version 1.2
 */
public class Calculette {
    /**
     * opérations à effectuer
     */
    protected OperationMathematique[] operations; // protected pour les classes dérivées

    /**
     * compteur d'opérations effectuées
     */
    protected int compteur;   // idem

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     *
     * @param uneTaille taille maximale du tableau d'opérations
     */
    public Calculette(int uneTaille) {
        operations = new OperationMathematique[uneTaille];
        compteur = 0;
    }

    /**
     * Effectue le calcul souhaité
     */
    public void calculer(String uneOperation) {
        if (compteur % 5 == 0) {
            compteur = 0;
        }
        operations[compteur] = new OperationMathematique();
        try {
            operations[compteur].resoudre(uneOperation);
        } catch (OperationException e) {
            e.printStackTrace();
        }
        compteur++;
    }

    /**
     * Redéfinition de la méthode <code>toString</code> permettant de retourner des
     * informations sur l'objet sous la forme d'une chaîne de caractères.
     *
     * @return chaîne de caractères représentant le calcul effectué
     * @see StringBuffer
     */
    public String toString() {
        StringBuilder liste = new StringBuilder("");

        for (OperationMathematique operation : operations) {
            if (operation != null) {
                liste.append(operation.toString()).append("\n");
            } else {
                liste.append("Undefined\n");
            }
        }

        return liste.toString();
    }
} // Fin Calculette