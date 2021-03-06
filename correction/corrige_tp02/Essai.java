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

import java.util.Scanner;

/**
 * Calculette syntaxique chargée d'analyser une chaîne de caractères spécifiant le calcul
 * à réaliser. Les chaînes de caractères doivent respecter la forme suivante : <br />
 * <code>operande1</code> <code>operation</code> <code>operande2</code>.<br />
 * La chaîne de caractères <code>"fin"</code> permet de quitter l'application par appel de
 * la méthode <code>System.exit(-1)</code>.
 *
 * @author Alain Lebret
 * @version 1.2
 */
public class Essai {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        Calculette calculette = new Calculette();
        Scanner scanner = new Scanner(System.in);

        String calcul;

        while (true) {
            System.out.println("\nCalculette - version 1.2");
            System.out.println("------------------------");
            System.out.println("Entrer une opération sous la forme :\noperande1 <operateur> operande2 (fin pour quitter)");
            System.out.print(">> ");

            calcul = scanner.nextLine();
            if (calcul.equals("fin")) {
                return;
            }
            calculette.calculer(calcul);
            System.out.println(calculette.toString());
        }
    }
} // Fin Essai