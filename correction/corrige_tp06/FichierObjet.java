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

import java.io.*;

/**
 * Gestion d'un fichier de sérialisation des objets. Elle utilise :
 *
 * ClassNotFoundException : Indique qu'une application essaie de charger une
 * classe introuvable.
 * FileInputStream        : Flux d'entrée permettant la lecture d'octets depuis
 * un fichier (spécifié par une instance de <code>File</code> ou
 * par son nom).
 * FileOutputStream       : Flux d'octets permettant l'écriture de données dans
 * un fichier (spécifié par une instance de <code>File</code> ou
 * par son nom).
 * IOException            : Indique une erreur d'entrée/sortie quelconque.
 * ObjectInputStream      : Permet la désérialisation de types primitifs Java et
 * d'objets sérialisés à l'aide de la classe ObjectOutputStream.
 * ObjectOutputStream     : Permet la sérialisation de types Java primitifs ou
 * d'objets sérialisables (implémentants <code>Serializable</code>).
 *
 * @author Anne Tasso
 * @version 1.0
 */
public class FichierObjet {
    /**
     * flot de sortie permettant l'envoi d'objets
     */
    private ObjectOutputStream fWo = null;

    /**
     * flot d'entrée permettant la réception d'objets
     */
    private ObjectInputStream fRo = null;

    /**
     * mode d'ouverture du fichier (Lecture ou Ecriture)
     */
    private char mode;

    /**
     * Ouverture du fichier objet.
     *
     * @param nomDuFichier nom du fichier objet à ouvrir
     * @param s            mode d'ouverture du fichier  (lecture ("L" ou "R") / écriture ("E" ou "W"))
     * @see java.io.IOException
     */
    public void ouvrir(String nomDuFichier, String s) throws IOException {
        mode = (s.toUpperCase()).charAt(0);

        if (mode == 'R' || mode == 'L') {
            fRo = new ObjectInputStream(new FileInputStream(nomDuFichier));
        } else {
            if (mode == 'W' || mode == 'E') {
                fWo = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
            }
        }
    }

    /**
     * Fermeture du fichier objet.
     *
     * @see java.io.IOException
     */
    public void fermer() throws IOException {
        if (mode == 'R' || mode == 'L') {
            fRo.close();
        } else {
            if (mode == 'W' || mode == 'E') {
                fWo.close();
            }
        }
    }

    /**
     * Lecture d'un Objet dans le fichier objet.
     *
     * @return une référence sur l'objet lu
     * @see java.io.IOException
     * @see java.lang.ClassNotFoundException
     */
    public Object lire() throws IOException, ClassNotFoundException {
        return fRo.readObject();
    }

    /**
     * Ecriture d'un Objet dans le fichier objet.
     *
     * @param tmp référence de l'objet à écrire
     * @see java.io.IOException
     */
    public void ecrire(Object tmp) throws IOException {
        if (tmp != null) {
            fWo.writeObject(tmp);
        }
    }
} // Fin FichierObjet
