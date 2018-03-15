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
package tp3;

import tp2.Calculette;
import util.Lecture;

/**
 *   Classe d'essai pour la calculette. Elle utilise :
 *   <pre>
 *   String : représente une chaîne de caractères dont le contenu ne
 *            peut être modifié.
 *   System : contient plusieurs attributs et méthodes utiles au dialogue
 *            avec le system d'exploitation.
 *   </pre>
 *   @version 1.3
 *   @author Alain Lebret
 */
public class Essai {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        Calculette calculette = new Calculette();
        String calcul;

        while (true) {
            System.out.println("\nCalculette - version 1.3");
            System.out.println("------------------------");
            System.out.println("\"Entrer une opération sous la forme :\\noperande1 <operateur> operande2 (fin pour quitter)\"");
            System.out.print(">> ");

            calcul = Lecture.S();
            if (calcul.equals("fin")) {
                return;
            }
            calculette.calculer(calcul);
            System.out.println(calculette.toString());
        }
    }
} // Fin Essai