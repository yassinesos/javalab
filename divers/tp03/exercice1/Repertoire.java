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
package tp03.exercice1;

import java.io.File;

/**
 * Classe permettant de lister et d'afficher tous les fichiers d'un
 * répertoire.
 */
public class Repertoire {
    /**
     * Nom du répertoire
     */
    private String nom;

    public Repertoire(String nom) {
        this.nom = nom;
    }

    public static void main(String[] args) {
        Repertoire fr = new Repertoire("divers/tp03/exercice1");
        String[] liste = fr.parcourir();
        fr.afficher(liste);
    }

    public String[] parcourir() {
        File repertoire = new File(nom);
        String[] fichiers = null;

        if (repertoire.isDirectory()) {
            fichiers = repertoire.list();
        }
        return fichiers;
    }

    public void afficher(String[] fichiers) {
        if (fichiers != null) {
            for (String fichier : fichiers) {
                System.out.println(fichier);
            }
        }
    }
}
