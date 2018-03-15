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
package tp4;

import java.io.Serializable;

/**
 * Définie une opération mathématique de la forme <code>operande1 operateur operande2</code>.
 * Elle utilise :
 * <pre>
 * Double          : encapsule le type primitif <i>double</i>.
 * String          : représente une chaîne de caractères dont le contenu ne peut
 * être modifié.
 * StringTokenizer : permet de découper une chaîne de caractères en éléments de base
 * base suivant des séparateurs précis.
 * </pre>
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class OperationMathematique extends Operation implements Serializable {
    /**
     * résultat de l'opération
     */
    private double resultat;

    /**
     * Constructeur par défaut.
     */
    public OperationMathematique() {
        super(); // appel du constructeur parent
        this.resultat = 0.0;
    }

    /**
     * Résolution de l'Opération souhaitée : operande1 &lt;operation&gt; operande2. Une utilisation de
     * la classe <code>StringTokenizer</code> permet de découper une chaîne en sous-chaînes par
     * l'intermédiaire de sa méthode <code>nextToken()</code>. Ces sous-chaînes sont alors
     * transformées en objets "enveloppes" (Double, Character, ...), phase intermédiaire avant
     * de pouvoir récupérer la valeur des types de base associés.<br>
     * Classes utilisées : <br><blockquote>
     * <code><b>StringTokenizer</b></code> avec sa méthode <code>String nextToken()</code><br>
     * <code><b>System</b></code> avec sa méthode <code><b>void</b> exit(<b>int</b> nb)</code><br>
     * <code><b>Double</b></code> avec sa méthode <code><b>double</b> parseDouble(String s)</code><br>
     * <code><b>String</b></code> avec sa méthode <code><b>char</b> charAt(<b>int</b> index)</code></blockquote>
     *
     * @param operation chaîne de caractères décrivant l'opération à effectuer
     * @see java.util.StringTokenizer
     * @see java.lang.System
     * @see java.lang.Double
     */
    public void resoudre(String operation) throws OperationException {
        double operande1 = 0, operande2 = 0;
        char operateur;

        java.util.StringTokenizer analyseur = new java.util.StringTokenizer(operation);
        try {
            operande1 = Double.parseDouble(analyseur.nextToken());
        } catch (NumberFormatException e) {
            this.setOperation("Format invalide");
        }
        operateur = (analyseur.nextToken()).charAt(0);
        try {
            operande2 = Double.parseDouble(analyseur.nextToken());
        } catch (NumberFormatException e) {
            this.setOperation("Format invalide");
        }

        this.setOperation(operation);

        switch (operateur) {
            case '+':
                resultat = operande1 + operande2;
                break;
            case '-':
                resultat = operande1 - operande2;
                break;
            case '/':
                resultat = operande1 / operande2;
                break;
            case '*':
                resultat = operande1 * operande2;
                break;
            default:
                resultat = Double.NaN;
                throw new OperationException("Opérateur non reconnu");
        }
    }

    /**
     * Redéfinition de la méthode toString permettant de retourner des informations
     * sur l'objet sous la forme d'une chaîne de caractères.
     *
     * @return chaîne de caractères représentant le calcul effectué
     */
    public String toString() {
        return this.getOperation() + " = " + resultat;
    }
} // Fin OperationMathematique