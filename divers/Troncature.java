/*
 * Copyright 2017 Alain Lebret.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.math.BigDecimal;

/**
 * Cette "classe" (en est-ce vraiment une au sens objet du terme ?) propose
 * trois manières simples de tronquer un double.
 *
 * @author A. Lebret
 * @version 1.0 (01/2017)
 */
public class Troncature {

    /**
     * Troncature en utilisant astucieusement {@code Math.floor} et
     * {@code Math.pow}.
     *
     * @param x Le nombre devant être tronqué
     * @param nbDecimales Nombre de décimales conservées par la troncature
     * @return Le nombre tronqué sous forme d'une chaîne de caractères
     * @see java.lang.Math
     */
    public static String tronquer1(final double x, final int nbDecimales) {
        int multiplicateur;
        double nombreTronque;

        multiplicateur = (int) Math.pow(10, nbDecimales);
        if (x >= 0) {
            nombreTronque = Math.floor(x * multiplicateur) / multiplicateur;
        } else {
            nombreTronque = -1 * Math.floor(-x * multiplicateur) / multiplicateur;
        }
        return String.valueOf(nombreTronque);
    }

    /**
     * Troncature en utilisant les propriétés des {@code BigDecimal}.
     *
     * @param x Le nombre devant être tronqué
     * @param nbDecimales Nombre de décimales conservées par la troncature
     * @return Le nombre tronqué sous forme d'une chaîne de caractères
     * @see java.math.BigDecimal
     */
    public static String tronquer2(final double x, final int nbDecimales) {
        BigDecimal bd = new BigDecimal(String.valueOf(x)).setScale(nbDecimales,
            BigDecimal.ROUND_DOWN);
        return bd.toPlainString();
    }

    /**
     * Troncature en utilisant les propriétés des {@code String}.
     *
     * @param x Le nombre devant être tronqué
     * @param nbDecimales Nombre de décimales conservées par la troncature
     * @return Le nombre tronqué sous forme d'une chaîne de caractères
     * @see java.lang.String
     */
    public static String tronquer3(final double x, final int nbDecimales) {
        String[] parties = (String.valueOf(x)).split("\\.");
        String resultat = parties[0];

        if (nbDecimales != 0) {
            resultat = resultat + "." + parties[1].substring(0, nbDecimales);
        } else {
            if (x < 0 && x > -1)
                resultat = resultat.substring(1);
        }
        return resultat;
    }

    public static void main(String[] args) {
        double nombre;
        int nbDecimales;

        if (args.length != 2) {
            System.out.println("Deux arguments sont nécessaires");
            System.exit(0);
        }

        try {
            nbDecimales = Integer.parseInt(args[1]);
            if (nbDecimales < 0) {
                throw new NumberFormatException();
            }
            nombre = new Double(args[0]);

            System.out.println(tronquer1(nombre, nbDecimales));
            System.out.println(tronquer2(nombre, nbDecimales));
            System.out.println(tronquer3(nombre, nbDecimales));
        } catch (NumberFormatException e) {
            System.out.println("Erreur d'écriture ; le premier argument "
                + "doit être un double et le deuxième "
                + "un entier positif ou nul");
        }
    }
}
