/*
 * SVEN is an open source Java library for machine learning, image analysis
 * and computer vision educational projects.
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
package util;

import java.io.IOException;


/**
 * <p>Classe de lecture au clavier. Elle utilise :
 * <pre>
 * Byte         : encapsule une valeur de type primitif <I>byte</I>.
 * Double       : encapsule le type primitif <I>double</I>.
 * Integer      : encapsule une valeur de type primitif <I>int</I>.
 * IOException  : indique une erreur d'entrée/sortie quelconque.
 * Short        : encapsule une valeur de type primitif <I>short</I>.
 * String       : représente une chaîne de caractères dont le contenu ne
 * peut être modifié.
 * System       : contient plusieurs attributs et méthodes utiles au dialogue
 * avec le système d'exploitation.
 * </pre>
 * <p>
 * <p>Les fonctions étant statiques, leur appel se fait comme suit :</p>
 * <pre>
 * String chaine = Lecture.S(); // pour récupérer une chaine au clavier
 * byte octet    = Lecture.b(); // pour récupérer un octet au clavier
 * short eCourt  = Lecture.s(); // pour récupérer un entier court au clavier
 * int entier    = Lecture.i(); // pour récupérer un entier au clavier
 * long eLong    = Lecture.l(); // pour récupérer un entier long au clavier
 * float reelF   = Lecture.f(); // pour récupérer un réel simple précision
 * double reelD  = Lecture.d(); // pour récupérer un réel double précision
 * char car      = Lecture.c(); // pour récupérer un caractère
 * </pre>
 *
 * @author Anne Tasso
 * @version 1.0
 */
public class Lecture {
    /**
     * Lecture d'une chaîne de caractères au clavier
     */
    public static String S() {
        StringBuilder tmp = new StringBuilder();
        char C;

        try {
            while ((C = (char) System.in.read()) != '\n') {
                if (C != '\r') {
                    tmp.append(C);
                }
            }
        } catch (IOException e) {
            System.err.println("Lecture:S() - Erreur de frappe");
            System.exit(0);
        }

        return tmp.toString();
    } // fin de S()

    /**
     * Lecture d'un octet au clavier
     */
    public static byte b() {
        byte x = 0;

        try {
            x = Byte.parseByte(S());
        } catch (NumberFormatException e) {
            System.err.println("Lecture:b() - Format numerique incorrect");
            System.exit(0);
        }

        return x;
    } // fin de b()

    /**
     * Lecture d'un entier court (2 octets) au clavier
     */
    public static short s() {
        short x = 0;

        try {
            x = Short.parseShort(S());
        } catch (NumberFormatException e) {
            System.err.println("Lecture:s() - Format numerique incorrect");
            System.exit(0);
        }

        return x;
    } // fin de s()

    /**
     * Lecture d'un entier (4 octets) au clavier
     */
    public static int i() {
        int x = 0;

        try {
            x = Integer.parseInt(S());
        } catch (NumberFormatException e) {
            System.err.println("Lecture:i() - Format numerique incorrect");
            System.exit(0);
        }
        return x;
    } // fin de i()

    /**
     * Lecture d'un entier long (8 octets) au clavier
     */
    public static long l() {
        long x = 0;

        try {
            x = Integer.parseInt(S());
        } catch (NumberFormatException e) {
            System.err.println("Lecture:l() - Format numerique incorrect");
            System.exit(0);
        }
        return x;
    } // fin de l()

    /**
     * Lecture d'un réel double précision au clavier
     */
    public static double d() {
        double x = 0.0;

        try {
            x = Double.valueOf(S());
        } catch (NumberFormatException e) {
            System.err.println("Lecture:d() - Format numerique incorrect");
            System.exit(0);
        }
        return x;
    } // fin de d()

    /**
     * Lecture d'un réel simple précision au clavier
     */
    public static float f() {
        float x = 0.0f;

        try {
            x = Double.valueOf(S()).floatValue();
        } catch (NumberFormatException e) {
            System.err.println("Lecture:f() - Format numerique incorrect");
            System.exit(0);
        }
        return x;
    } // fin de f()

    /**
     * Lecture d'un caractère unicode au clavier
     */
    public static char c() {
        String tmp = S();

        if (tmp.length() == 0) {
            return '\n';
        } else {
            return tmp.charAt(0);
        }
    } // fin de c()
} // Fin de Lecture
