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
package tp01;

/**
 * Cette "classe" (en est-ce vraiment une au sens objet du terme ?) propose
 * de faire la somme des entiers passés en arguments.
 *
 * @author A. Lebret
 * @version 1.0 (01/2017)
 */
public class Somme {
    public static void main(String[] args) {
        int somme = 0;

        for (String digits : args) {
            try {
                somme += Integer.valueOf(digits);
            } catch (NumberFormatException e) {
                String message = String.format("Attention, \"%s\" n'est pas un nombre entier !", digits);
                System.err.println(message);
            }
        }
        System.out.println("tp01.Somme = " + somme);
    }
}
