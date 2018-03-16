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

import java.util.Scanner;
import java.util.regex.Pattern;

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
     * Décompose l'opération en utilisant un Scanner.
     *
     * @param operation Opération mathématique à réaliser (+, -, * et /)
     */
    private void decomposerAvecScanner(String operation) {
        String motif = "([ +\\-*/])";
        String operationSansEspaces = operation.replaceAll(" ", "");
        Scanner sc = new Scanner(operationSansEspaces.replaceAll(" ", ""));

        sc.useDelimiter(Pattern.compile(motif));
        operande1 = Double.parseDouble(sc.next());
        operateur = sc.findInLine(motif).charAt(0);
        operande2 = Double.parseDouble(sc.next());
    }

    /**
     * Décompose l'opération en utilisant la méthode split d'un String.
     *
     * @param operation Opération mathématique à réaliser (+, -, * et /)
     */
    private void decomposerAvecStringEtSplit(String operation) {
        String motif = "([ +\\-*/])";
        String operateurs = "+-*/";
        String operationSansEspaces = operation.replaceAll(" ", "");

        String[] operandes = operationSansEspaces.split(motif);
        for (int i = 0; i < operateurs.length(); i++) {
            char ope = operateurs.charAt(i);
            if (operationSansEspaces.indexOf(ope) != -1) {
                operateur = String.valueOf(ope).charAt(0);
                break;
            }
        }
        operande1 = Double.parseDouble(operandes[0]);
        operande2 = Double.parseDouble(operandes[1]);
    }

    /**
     * Effectue le calcul souhaité en fonction de l'opération donnée.
     *
     * @param operation Opération mathématique à réaliser (+, -, * et /)
     */
    public void calculer(String operation) {

        decomposerAvecScanner(operation);

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