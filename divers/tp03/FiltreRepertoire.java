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
package tp03;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * Classe permettant de lister et d'afficher tous les fichiers d'un
 * répertoire ayant une extension particulière.
 */
public class FiltreRepertoire implements FilenameFilter {
    /** Extension des fichiers à lister */
    private String extension;

    public FiltreRepertoire(String extension) {
        this.extension = extension;
    }

    public static void main(String[] args) {
        FiltreRepertoire fr = new FiltreRepertoire("java");
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrer un nom de répertoire : ");
        String r = sc.next();
        String[] liste = fr.parcourir(r);
        fr.afficher(liste);
    }

    public String[] parcourir(String nomRepertoire) {
        File repertoire = new File(nomRepertoire);
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

    @Override
    public boolean accept(File repertoire, String fichier) {
        boolean hasJavaExtension = false;
        if (fichier.endsWith(extension)) {
            hasJavaExtension = true;
        }
        return hasJavaExtension;
    }
}
