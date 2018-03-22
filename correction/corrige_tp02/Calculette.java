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
package corrige_tp02;

/**
 * Calculette syntaxique chargée d'analyser une chaîne de caractères spécifiant le calcul
 * à réaliser. Les chaînes de caractères doivent respecter la forme suivante : <br />
 * <code>operande1</code> <code>operation</code> <code>operande2</code>.
 *
 * @author Alain Lebret
 * @version 1.2
 */
public class Calculette {
    /**
     * opérande 1 de la calculette
     */
    private OperationMathematique operation;

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     */
    public Calculette() {
        operation = new OperationMathematique();
    }

    /**
     * Effectue le calcul souhaité en fonction de l'opération donnée.
     *
     * @param operation Opération mathématique à réaliser (+, -, * et /)
     */
    public void calculer(String operation) {
        try {
            this.operation.resoudre(operation);
        } catch (OperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Redéfinition de la méthode toString permettant de retourner des informations
     * sur l'objet sous la forme d'une chaîne de caractères.
     *
     * @return chaîne de caractères représentant le calcul effectué
     */
    public String toString() {
        return String.format("\n%s\n", operation.toString());
    }
} // Fin Calculette