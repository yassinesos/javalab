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
package corrige_tp06;

import java.io.IOException;

/**
 * Classe d'essai pour les fichiers d'objets sérialisés. Elle utilise :
 * <p>
 * ClassNotFoundException : Indique qu'une application essaie de charger une
 * classe introuvable.
 * IOException            : Indique une erreur d'entrée/sortie quelconque.
 * System                 : Contient plusieurs attributs et méthodes utiles au
 * dialogue avec le system d'exploitation.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class EssaiFichierObjet {
    /**
     * Fonction principale
     */
    public static void main(String[] argument) {
        FichierObjet fb = new FichierObjet();
        OperationMathematique om1 = new OperationMathematique();
        OperationMathematique om2 = new OperationMathematique();

        try {
            om1.resoudre("3 - 4");
            om2.resoudre("4 / 0");
        } catch (OperationException e) {
            e.printStackTrace();
        }

        try {
            // Création et écriture dans le fichier Objet
            fb.ouvrir("test.obj", "E");
            System.out.println("Ecriture dans le fichier");
            fb.ecrire(om1);
            fb.ecrire(om2);
            fb.fermer();

            // Lecture du fichier pour vérification
            fb.ouvrir("test.obj", "L");
            System.out.println("\nLecture dans le fichier");
            System.out.println(fb.lire().toString());
            System.out.println(fb.lire().toString());
            fb.fermer();
        } catch (IOException e) {
            System.err.println("Erreur durant la manipulation du fichier");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur durant la manipulation des objets");
        }
    }
} // Fin EssaiFichierObjet
