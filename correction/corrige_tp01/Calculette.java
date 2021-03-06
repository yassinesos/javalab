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
package corrige_tp01;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Calculette syntaxique chargée d'analyser une chaîne de caractères spécifiant le calcul
 * à réaliser. Les chaînes de caractères doivent respecter la forme suivante : <br />
 * <code>operande1</code> <code>operateur</code> <code>operande2</code>.
 *
 * @author Alain Lebret
 * @version 1.1
 */
public class Calculette {
    /**
     * Opérande 1 de la calculette
     */
    private double operande1;

    /**
     * Opérande 2 de la calculette
     */
    private double operande2;

    /**
     * Opération effectuée sur la calculette ('+', '-', '*' et '/')
     */
    private char operateur;

    /**
     * Résultat de l'opération
     */
    private double resultat;

    /**
     * Constructeur par défaut. Celui-ci initialise les opérandes à 0 et
     * l'opérateur par défaut est l'addition.
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
        Scanner sc = new Scanner(operationSansEspaces);

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
            char operateurATester = operateurs.charAt(i);
            if (operationSansEspaces.indexOf(operateurATester) != -1) {
                operateur = String.valueOf(operateurATester).charAt(0);
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
        //decomposerAvecStringEtSplit(operation);

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
        return String.format("\n%s %s %s =  %s\n", operande1, operateur, operande2, resultat);
    }
} // Fin Calculette
