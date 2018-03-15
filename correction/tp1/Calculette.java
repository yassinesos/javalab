/*
 * Java programming laboratory work.
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
package tp1;

import java.util.StringTokenizer;

/**
 * Calculette syntaxique chargée d'analyser une chaîne de caractères spécifiant le calcul
 * à réaliser. Les chaînes de caractères doivent respecter la forme suivante : <br />
 * <code>operande1</code> <code>operation</code> <code>operande2</code>.<br />
 * La chaîne de caractères <code>"fin"</code> permet de quitter l'application par appel de
 * la méthode <code>System.exit(-1)</code>.  Elle utilise :
 * <pre>
 * Double          : encapsule le type primitif <i>double</i>.
 * String          : représente une chaîne de caractères dont le contenu ne peut
 * être modifié.
 * StringTokenizer : permet de découper une chaîne de caractères en éléments de base
 * base suivant des séparateurs précis.
 * System          : contient plusieurs attributs et méthodes utiles au dialogue
 * avec le system d'exploitation.
 * </pre>
 *
 * @author Alain Lebret
 * @version 1.1
 */
public class Calculette {
    /**
     * opérande 1 de la calculette
     */
    private double operande1;

    /**
     * opérande 2 de la calculette
     */
    private double operande2;

    /**
     * opération effectuée sur la calculette
     */
    private char operateur;

    /**
     * résultat de l'opération
     */
    private double resultat;

    /**
     * Constructeur par défaut. Celui-ci initialise les attributs de la classe.
     */
    public Calculette() {
        operande1 = operande2 = resultat = 0.0;
        operateur = '+';
    }

    /**
     * Effectue le calcul souhaité : operande1 operation operande2. Une utilisation de
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
     * @param op chaîne de caractères décrivant l'opération à effectuer
     * @see java.util.StringTokenizer
     * @see java.lang.System
     * @see java.lang.Double
     */
    public void calculer(String op) {
        if (op.equals("fin")) {
            System.exit(-1);
        } else {
            StringTokenizer t = new StringTokenizer(op);

            operande1 = Double.parseDouble(t.nextToken());
            operateur = (t.nextToken()).charAt(0);
            operande2 = Double.parseDouble(t.nextToken());

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
        return "\n" + operande1 + " " + operateur + " " + operande2 + " =  " + resultat + "\n";
    }
} // Fin Calculette