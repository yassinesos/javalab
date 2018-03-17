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

/**
 * Classe d'essai pour les fichiers. Elle utilise :
 *
 * System : Contient plusieurs attributs et méthodes utiles au dialogue
 *          avec le system d'exploitation.
 *
 * @version 1.0
 * @author Alain Lebret
 */
public class EssaiFichier {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        Fichier fb = new Fichier("test");
        OperationMathematique om1 = new OperationMathematique();

        try {
            om1.resoudre("3 / 0");
        } catch (OperationException e) {
            e.printStackTrace();
        }

        // Création et écriture dans le fichier
        fb.ecrire(om1);

        // Lecture du fichier pour vérification
        System.out.println("\nLecture dans le fichier");
        System.out.println(fb.lire().toString());
    }
} // Fin EssaiFichier