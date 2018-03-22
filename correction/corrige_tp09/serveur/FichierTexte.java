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
package corrige_tp09.serveur;

import java.io.*;


/**
 * Gestion d'un fichier Texte. Elle utilise :
 * <p>
 * BufferedReader : Flux d'entrée de caractères pourvu d'une mémoire tampon
 * afin d'optimiser la lecture de caractères isolés, de
 * tableaux et de chaînes de caractères.
 * BufferedWriter : Flux de sortie de caractères pourvu d'une mémoire tampon
 * afin d'optimiser l'écriture de caractères isolés, de
 * tableaux et de chaînes de caractères.
 * File           : Représente un fichier ou un répertoire du système de
 * fichiers sur le système hôte.
 * FileReader     : Permet la lecture de caractères depuis un fichier
 * (spécifié par une instance de <code>File</code> ou
 * par son nom).
 * FileWriter     : Permet l'écriture de caractères dans un fichier
 * (spécifié par une instance de <code>File</code> ou
 * par son nom).
 * IOException    : Indique une erreur d'entrée/sortie quelconque.
 *
 * @author Anne Tasso
 * @version 1.0
 */
public class FichierTexte {
    /**
     * flot de sortie
     */
    private BufferedWriter fW;

    /**
     * flot d'entrée
     */
    private BufferedReader fR;

    /**
     * mode d'ouverture du fichier (Lecture ou Ecriture)
     */
    private char mode;

    /**
     * Ouverture du fichier texte.
     *
     * @param nomDuFichier nom du fichier texte à ouvrir
     * @param s            mode d'ouverture du fichier (lecture ("L" ou "R") / écriture ("E" ou "W"))
     * @see IOException
     */
    public void ouvrir(String nomDuFichier, String s) throws IOException {
        mode = (s.toUpperCase()).charAt(0);
        File f = new File(nomDuFichier);

        if (mode == 'R' || mode == 'L') {
            fR = new BufferedReader(new FileReader(f));
        } else {
            if (mode == 'W' || mode == 'E') {
                fW = new BufferedWriter(new FileWriter(f));
            }
        }
    }

    /**
     * Fermeture du fichier texte.
     *
     * @see IOException
     */
    public void fermer() throws IOException {
        if (mode == 'R' || mode == 'L') {
            fR.close();
        } else {
            if (mode == 'W' || mode == 'E') {
                fW.close();
            }
        }
    }

    /**
     * Lecture d'une ligne de texte dans le fichier texte.
     *
     * @return ligne de texte lue dans le fichier
     * @see IOException
     */
    public String lire() throws IOException {
        return fR.readLine();
    }

    /**
     * Ecriture d'une chaîne de caractères dans le fichier texte.
     *
     * @param s chaîne de caractères à écrire
     * @see IOException
     */
    public void ecrire(String s) throws IOException {
        if (s != null) {
            fW.write(s);
            fW.newLine();
            fW.flush();  // AJOUTE LE 17/03/2018
        }
    }
} // Fin FichierTexte