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
package corrige_tp04;


import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Définie une opération mathématique de la forme <code>operande1 operateur operande2</code>.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class OperationMathematique extends Operation {
    /**
     * Résultat de l'opération
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
     * Résolution de l'Opération souhaitée : operande1 &lt;operation&gt; operande2.
     *
     * @param uneOperation chaîne de caractères décrivant l'opération à effectuer
     * @see java.util.Scanner
     * @see java.util.regex.Pattern
     * @see java.lang.Double
     */
    public void resoudre(String uneOperation) throws OperationException {
        if (uneOperation == null) {
            return;
        }

        String motif = "([ +\\-*/])";
        String operationSansEspaces = uneOperation.replaceAll(" ", "");
        this.setOperation(operationSansEspaces);
        Scanner sc = new Scanner(this.getOperation());

        sc.useDelimiter(Pattern.compile(motif));
        double operande1 = Double.parseDouble(sc.next());
        char operateur = sc.findInLine(motif).charAt(0);
        double operande2 = Double.parseDouble(sc.next());


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