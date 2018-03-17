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
package corrige_tp06;

import java.io.IOException;

/**
 * Classe d'essai pour les fichiers textes. Elle utilise :
 *
 * IOException : Indique une erreur d'entrée/sortie quelconque.
 * System      : Contient plusieurs attributs et méthodes utiles au
 *               dialogue avec le system d'exploitation.
 *
 * @version 1.0
 * @author Alain Lebret
 */
public class EssaiFichierTexte {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        FichierTexte ft = new FichierTexte();

        try {
            // Création et écriture dans le fichier Texte
            ft.ouvrir("test.txt", "E");
            System.out.println("Ecriture dans le fichier");
            ft.ecrire("La vie est belle en TSII.\n\n"); // deux sauts de ligne à la fin
            ft.ecrire("Et ce n'est pas tout!");
            ft.fermer();

            // Lecture du fichier pour vérification
            ft.ouvrir("test.txt", "L");
            System.out.println("\nLecture dans le fichier");
            System.out.println(ft.lire());
            System.out.println(ft.lire()); // lecture des sauts de ligne
            System.out.println(ft.lire()); // ...
            System.out.println(ft.lire());
            ft.fermer();
        } catch (IOException e) {
            System.err.println("Erreur durant la manipulation du fichier");
        }
    }
} // EssaiFichierTexte
