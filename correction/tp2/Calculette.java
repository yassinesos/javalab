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
package tp2;

/**
 * Amélioration de la calculette du TP no 1 avec utilisation d'une super-classe
 * <code>Operation</code> ainsi que d'une classe fille <code>OperationMathematique</code>
 * chargée de la gestion des chaînes de caractères définissant les opérations
 * mathématiques à résoudre. Elle utilise :
 * <pre>
 * String : Représente une chaîne de caractères dont le contenu ne
 * peut être modifié.
 * System : Contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </pre>
 *
 * @author Alain Lebret
 * @version 1.2
 */
public class Calculette {
    /**
     * opération à effectuer
     */
    private OperationMathematique operation;

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     */
    public Calculette() {
        operation = new OperationMathematique();
    }

    /**
     * Effectue le calcul souhaité
     */
    public void calculer(String uneOperation) {
        if (uneOperation.equals("fin")) {
            System.exit(-1);
        } else {
            try {
                operation.resoudre(uneOperation);
            } catch (OperationException e) {
                System.err.println(e.toString());
            }
        }
    }

    /**
     * Redéfinition de la méthode toString permettant de retourner des informations
     * sur l'objet sous la forme d'une chaîne de caractères.
     *
     * @return chaîne de caractères représentant le calcul effectué
     */
    public String toString() {
        return operation.toString();
    }
} // Fin Calculette